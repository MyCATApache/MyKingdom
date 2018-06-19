var custInfoId = null ;
var isSubscribe = false ;
var isConfirm = false ;
$(function(){
	$_ajax.post({url:"/api/biz/loadAll" , callBack:function(json){
		var data = json.data;
		var html="";
		for(var x=0;x<data.length;x++){
			var row = data[x] ;
			html += '<li><label><input class="bizbox" type="checkbox" value="' + row.id +  '"/>' + row.businessName + '</label></li>' ; 
		} 
		$("#biz").html( html );
	}})
	
	$("#subscribe").click(function(){
		var bizboxs = $(".bizbox:checked");
		var name = $.trim($("input[name='name']").val());
		var phone = $.trim($("input[name='phone']").val());
		var email = $.trim($("input[name='email']").val());
		if(!bizboxs.length){
			alert("请选择您的服务项目");
			return ;
		}
		if("" == name){
			alert("请输入您的姓名");
			return ;
		}
		if("" == phone){
			alert("请输入您的手机号码");
			return ;
		}
		if("" == email){
			alert("请输入您的邮箱账号");
			return ;
		}
		if(isSubscribe){return false ;}
		var bizid=[];
		for(var x=0;x<bizboxs.length;x++){
			bizid.push($(bizboxs[x]).val()) ;
		}
		isSubscribe=true;
		$_ajax.post({url:"/api/biz/subscribe" ,data:{custName:name,phone:phone,bizid:bizid} , callBack:function(json){
			//alert(json.data);
			isSubscribe=false;
			$("#phoneMsg").html("您用&nbsp;"+phone+"&nbsp;号码成功预约");
			custInfoId = json.data ;
			$("#subscribeDiv").hide();
			$("#sureDiv").show();
		}}) 
	});
	
	$("#confirm").click(function(){
		if(isConfirm){
			return;
		}
		isConfirm=true;
		var confirmbox = $(".confirmbox:checked");
		if(!confirmbox.length){
			alert("请选择您方便接听电话的时间");
			return ;
		}
		var ccTime="";
		for(var x=0;x<confirmbox.length;x++){
			if(x>0){ccTime+=",";}
			ccTime+=$(confirmbox[x]).val();
		}
		$_ajax.post( {url:"/api/biz/confirm" ,data:{cstId:custInfoId,ccTime:ccTime} , callBack:function(json){
			$(".needhide").hide();
			$("#phoneMsg").html("您用&nbsp;" + $.trim($("input[name='phone']").val()) + "&nbsp;号码成功预约,方便接听电话时间：" + ccTime); 
		}});
	})
	
})