
var id;
$(function(){

});

//截取URL参数
function getQueryString(name) {
var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
var r = window.location.search.substr(1).match(reg);
if (r != null) {
    return decodeURI(r[2]);
}
return null;
}
//获取红包详情
$(".item").click(function(e) {
	var _id = jQuery('#id').val();
	jQuery.ajax({
	       type: "POST",
	       url: "/api/user/getUserInfo",
	       data: {id:_id},
	       dataType: "json",
	       success: function(data){
	           if(data.data != null){
	               //跳转到红包三
	               document.location = 'grabred-detail.html?id='+_id
	           }else{
	               alert(data.data)
	           }
	       },
	       error: function (err) {
	           console.log(err)
	       }
	   })
});
