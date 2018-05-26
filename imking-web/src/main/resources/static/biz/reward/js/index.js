function getRequestParam() {
    var _url = location.search;
    var _theRequest = new Object();

    if (_url.indexOf("?") != -1) {
        var _str = _url.substr(1);
        strs = _str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            var _requestParamKey = strs[i].split("=")[0];
            var _requestParamValue = unescape(strs[i].split("=")[1]);
            _theRequest[_requestParamKey] = _requestParamValue;
        }
    }
    return _theRequest;
}
jQuery(document).ready(function(){
    var _requestParam  = getRequestParam();
    jQuery('#id').val(_requestParam.id);
});


jQuery('#previous').click(function(){
   //返回上一步
});
jQuery('#next').click(function(){
    var _id = jQuery('#id').val();
    var _content = jQuery('#contentText').val();
    jQuery.ajax({
       type: "POST",
       url: "/api/reward/saveconnect",
       data: {id:_id,content:_content},
       dataType: "json",
       success: function(data){
           if(data.desc == 'success'){
               //跳转到红包三
               document.location = '/courses/index.html?id='+id
           }else{
               alert(data.data)
           }
       },
       error: function (err) {
           console.log(err)
       }
   })
});