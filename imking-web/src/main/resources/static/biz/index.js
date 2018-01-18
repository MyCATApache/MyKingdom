$(function(){
	
	$_ajax.post({url:"/biz/loadAll" , callBack:function(json){
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
		var bizid=[];
		for(var x=0;x<bizboxs.length;x++){
			bizid.push($(bizboxs[x]).val()) ;
		}
		$_ajax.post({url:"/biz/subscribe" ,data:{custName:name,phone:phone,bizid:bizid} , callBack:function(json){
			alert(json.data);
		}}) 
	});
})