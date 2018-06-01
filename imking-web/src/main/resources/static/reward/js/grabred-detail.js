var responseTableRwAsks;
$(function(){
	init();
});

/**
 * 初始化table切换数据
 * @returns
 */
function init(){
	var thef=this;
	$.ajax({
	       type: "GET",
	       url: "/api/reward/tableRwAsks",
	       dataType: "json",
	       success: function(data){
	           if(data.status == 200){
	        	   responseTableRwAsks=data.data;
	               tableRwAsks('');
	           }else{
	               alert(data.desc)
	           }
	       },
	       error: function (err) {
	           console.log(err)
	       }
	   })
}

/**
 * table切换
 * @returns
 */
function tableRwAsks(queryName){
	$('.media-list').empty();
	var rwAsks=[];
	if(queryName=='')
	{
		rwAsks=responseTableRwAsks['all'];
	}
	else{
		rwAsks=responseTableRwAsks[queryName+''];
	}
	var mediaList='';
	for(var i=0;i<rwAsks.length;i++)
	{
		mediaList+=
				'<li class="media">'+
				        '<div class="media-left">'+
				        '<a href="#">'+
				            '<img class="media-object" src="../../assets/images/reward/user.png" alt="...">'+
				        '</a>'+
				    '</div>'+
				    '<div class="media-body">'+
				        '<span class="nickname">呆呆虎</span>'+
				        '<button class="btn rank">lv4</button>'+
				        '<p class="time">'+timestampToTime(rwAsks[i].updateTime)+'</p>'+
				        '<div class="jumbotron">'+
				        rwAsks[i].content+
				       '</div>'+
				       '<div class="operate-group">'+
				            '<img src="../../assets/images/reward/good.png" alt="">'+
				            '<img src="../../assets/images/reward/bad.png" alt="">'+
				            '<button class="btn">举报</button>'+
				        '</div>'+
				    '</div>'+
				'</li>';
	}
	$('.media-list').append(mediaList);
 }

/**
 * 时间戳格式化
 * @param timestamp
 * @returns
 */
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


 
