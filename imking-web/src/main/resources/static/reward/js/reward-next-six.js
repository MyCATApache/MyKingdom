
var id;
$(function(){
	id = getQueryString("id");
    $("#days").slider({
        ticks: [0, 1, 2, 3, 4, 5],
        ticks_labels: ['0', '10元(1天)', '20元(2天)', '30元(3天)', '40元(4天)', '50元(5天)'],
        ticks_snap_bounds: 30
    });

    $("#days").slider('setValue', 0);
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


//更新红包置顶信息和状态
function updateRwAsk(){

var isTop = 0;
var topExpirationDate;
var days = $("#days").slider('getValue');
if(days > 0){
    isTop = 1;
    topExpirationDate = new Date();
    topExpirationDate.setDate(topExpirationDate.getDate() + days);
}


var type = $("input[name='type']:checked").val();

$.ajax({
    type: "POST",
    url: "/api/reward/updateRwAsk",
    data: {id: id, isTop: isTop,type: type,topAmount: days * 10,topExpirationDate: topExpirationDate},
    success: function (data) {
        //to do
        console.log(data);
    }
});
}
