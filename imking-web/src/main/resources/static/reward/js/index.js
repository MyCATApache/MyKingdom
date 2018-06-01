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
jQuery("#stepTwo").click(function () {
    var _title = jQuery('#rwTitle').val();
    if (_title){
        jQuery.ajax({
            type: "POST",
            url: "/api/reward/add",
            data: {title: _title},
            dataType: "json",
            success: function (data) {
                if (data.status == 200){
                    document.location = './reward-next-two.html?id='+data.data;
                }else{
                    alert(data.data);
                }
            }
        });
    }else{
        alert("请输入标题!");
    }
});
jQuery("#rwSearchBtn").click(function () {
    var _title = jQuery('#rwTitle').val();
    if (_title){
        jQuery.ajax({
            type: "GET",
            url: "/api/reward/list",
            data: {title: _title},
            dataType: "json",
            success: function (data) {
                if (data.status == 200){
                    console.log(data.data);
                    var rwItemList = jQuery("#rwItemList");
                    rwItemList.html('');
                    var rwList = data.data.list || [];
                    var html = '';
                    for (var index in  rwList){
                        console.log(rwList[index]);
                        var rwItem = rwList[index];
                        html+='<html><head></head><body><div class="item"><div class="user-infor"><div class="row"><div class="col-sm-3 col-md-3 col-lg-3"><div class="avatar"><img class="img-responsive center-block" src="../../assets/images/reward/user.png" alt="" /></div></div><div class="col-sm-9 col-md-9 col-lg-9"><div class="top"><span class="name">'+rwItem.nickname+'</span><span class="rank">'+rwItem.level+'</span></div><div class="center"><div class="red-packet"><img src="../../assets/images/reward/packet.png" alt="" /></div><div class="text"><p class="money">'+rwItem.taskAmount+'元</p><p class="question">'+rwItem.title+'</p></div></div><div class="bottom">       红包发放中 发布时间：'+timestampToTime(rwItem.createTime)+'</div></div></div></div><div class="answer"><ul><li>回答（'+rwItem.answerCount+'）</li><li>提问（'+rwItem.questionCount+'）</li><li>评论（'+rwItem.commentCount+'）</li></ul></div></div></body></html>';
                    }
                    rwItemList.html(html);
                }else{
                    alert(data.data);
                }
            }
        });
    }else{
        alert("请输入标题!");
    }
});

function timestampToTime(timestamp) {
    var date = new Date(timestamp);
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y+M+D+h+m+s;
}
