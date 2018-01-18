$(function(){
	
	$_ajax.post({url:"/biz/loadAll" , callBack:function(json){
		var data = json.data;
		var html="";
		for(var x=0;x<data.length;x++){
			var row = data[x] ;
			html += '<li><label><input type="checkbox" value="' + row.id +  '"/>' + row.businessName + '</label></li>' ; 
		} 
		$("#biz").html( html );
	}})
})