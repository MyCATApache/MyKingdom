;(function(global,$){

	function ajax(params){
		var multipart = params && params.multipart?true:false;
		var contentType = 'application/json; charset=utf-8';
		var dataType = 'json';
		var jwt = global.sessionStorage.getItem('imk');
		var options = $.extend({dataType:dataType,contentType:contentType},params);
		if(multipart){
			options.cache = false;
			options.contentType = false;
    	    options.processData = false;
		}
		options.beforeSend = function(jqXhr,settings){
			var headers = jqXhr.getAllResponseHeaders();
			if(jwt){
				jqXhr.setRequestHeader('Authorization','Imking '+jwt)
			}
			// show loading
			global._loading.show();
		};
		options.complete = function(jqXhr,textStatus){
			// textStatus: "success", "notmodified", "nocontent", "error", "timeout", "abort", or "parsererror"
			// close loading
			console.log('complete',jqXhr,textStatus)
			global._loading.hide();
			if(401 == jqXhr.status){
				document.location.href = '/signin.html?redirectUrl='+window.encodeURIComponent(window.location.href);
			}
		};
		options.error = function(jqXhr,status){ // "timeout" "error" "abort" "parsererror"
			console.log('error',jqXhr,status)
		}
		//console.log(options)
		$.ajax(options);
		// res, status,jqxhr
		// err,status
	}

	var _ajax = {
			get:function(options){
				options.method = 'GET';
				ajax(options);
			},
			post:function(options){
				options.method = 'POST';
				ajax(options);
			},
			put:function(options){
				options.method = 'PUT';
				ajax(options);
			},
			del:function(options){
				options.method = 'DELETE';
				ajax(options);
			},
			multipart:function(options){
				//
				ajax(options);
			}
	};

	global._ajax = _ajax;

}(window,jQuery,undefined));

(function(global,jQuery){
	var _loading = {
		show:function(options){
			var loadingEl = $('#loading');
			if(loadingEl.length<=0){
				loadingEl = $('<div id="loading" class="loading show"><div class="loading-box"><div class="mask"></div><div class="loading-text">请稍候。。。</div></div></div>');
				$('body').append(loadingEl);
			}else{
				loadingEl.removeClass('hide').addClass('show');
			}
		},
		hide:function(){
			$('#loading').remove();
		}
	}
	global._loading = _loading;

})(window,jQuery,undefined);

(function(global,$){
	$(function () {
		'use strict'

        // 手机菜单
		var rootDom = $('.imk-root');
		$('#imk-menu-toggle').on('click',function () {
			rootDom.hasClass('menu-open')?rootDom.removeClass('menu-open'):rootDom.addClass('menu-open');
        })

        // 手机菜单我的模块折叠
		var mobileNavToggle = $('.my-nav-toggle');
		mobileNavToggle.on('click',function(){
			mobileNavToggle.hasClass('fa-angle-down')?
				mobileNavToggle.removeClass('fa-angle-down').addClass('fa-angle-up'):
				mobileNavToggle.removeClass('fa-angle-up').addClass('fa-angle-down');
		});

        // pc菜单，消息中心｜我的中心
		var navMessage = $('.nav-signin-message');
		var navMy = $('.nav-signin-my');
        navMessage.find('.nav-sigin-holder').on('mouseenter',function(){
            navMessage.find('.nav-dropdown').removeClass('d-none');
		});
        navMessage.find('.nav-sigin-holder').on('mouseleave',function(){
            navMessage.find('.nav-dropdown').addClass('d-none');
		});
        navMessage.find('.nav-dropdown').on('mouseenter',function () {
            navMessage.find('.nav-dropdown').removeClass('d-none');
        });
        navMessage.find('.nav-dropdown').on('mouseleave',function () {
            navMessage.find('.nav-dropdown').addClass('d-none');
        });
        navMy.find('.nav-sigin-holder').on('mouseenter',function(){
            navMy.find('.nav-dropdown').removeClass('d-none');
        });
        navMy.find('.nav-sigin-holder').on('mouseleave',function(){
            navMy.find('.nav-dropdown').addClass('d-none');
        });
        navMy.find('.nav-dropdown').on('mouseenter',function () {
            $(this).removeClass('d-none');
        });
        navMy.find('.nav-dropdown').on('mouseleave',function () {
            $(this).addClass('d-none');
        });

	});
})(window,jQuery,undefined);
