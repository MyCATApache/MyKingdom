(function (global,$,undefined) {
    'use strict';
    var request = function(options){
        var url = options.url;
        var data = options.data;
        var type = options.type || 'get';
        var dataType = options.dataType || 'json';
        var token = getCookie('_token') || '' ; 
        var contentType = options.contentType || 'application/x-www-form-urlencoded';
        return $.ajax({
            url: url,
            data: data,
            type: type,
            dataType:dataType,
            headers: {
            	_token: token
            },
            contentType: contentType,
            success: function (data) {
                options.callBack(data);
            }
        })
    }
    var $_ajax = {
        get : function (options) {
            options.type='get';
            return request(options);
        },
        post : function (options) {
            options.type='post';
            return request(options);
        }
    }
    window.$_ajax = $_ajax;
    
    $(".header").load("/common/header.html");
})(window,jQuery);
(function ($,global) {
    'use strict';
    console.log("a");
    $('#adminCollapse').on('hidden.bs.collapse', function () {
        console.log('ok')
        $('#adminController').text("展开");
    });
    $('#adminCollapse').on('shown.bs.collapse', function () {
        console.log('ok')
        $('#adminController').text("收起");
    });
})(jQuery,window);


function getCookie(cookieName) {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; ");
    for(var i = 0; i < arrCookie.length; i++){
        var arr = arrCookie[i].split("=");
        if(cookieName == arr[0]){
            return arr[1];
        }
    }
    return "";
}