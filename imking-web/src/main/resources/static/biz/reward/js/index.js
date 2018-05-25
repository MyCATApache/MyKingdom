function GetRequest() {
    var url = location.search;
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    console.log(theRequest)
    return theRequest;
}
$(document).ready(function(){
    var param  = GetRequest();
    jQuery('#id').val(param.id)
});


jQuery('#previous').click(function(){
    alert(123)
});
jQuery('#next').click(function(){
    var id = jQuery('#id').val();
    var content = jQuery('#contentText').val();
    jQuery.ajax({
       type: "POST",
       url: "/api/reward/saveconnect",
       data: {id:id,content:content},
       dataType: "json",
       success: function(data){
           console.log(data);
           if(data.desc == 'success'){
               document.location = '/courses/index.html?id='+id
           }else{
               alert(data.data)
           }
       }
   })
});