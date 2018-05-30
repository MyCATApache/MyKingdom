//截取URL参数
function getQueryString(name) {
  var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
  var r = window.location.search.substr(1).match(reg);
  if (r != null) {
    return decodeURI(r[2]);
  }
  return null;
}

// $("#opt_type").bind("click", function (event) {
//   $(this).attr("")
//   console.log(event)
//
// });

var _optType;

$(".opt-type").click(function () {
  _optType = $(this).attr("value")
});

$("#submit-replay").bind("click", function (event) {

  if (_optType === undefined) {
    alert("请选择发言类型.")
  } else if (_optType === "reply") {
    $.ajax({
      type: "post",
      url: '/api/reward/rwAskQuestionReply',
      async: false,
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      data: JSON.stringify({
        rwAskQuestionId: getQueryString("id"),
        replyContent: $("#rating").val()
      }),
      success: function (data) {
        var status = data.status;
        if (status === 200) {
          alert("提交成功!")
        } else {
          alert(data.desc)
        }
      }
    });
  } else if (_optType === "ask") {
    $.ajax({
      type: "post",
      url: '/api/reward/rwAskQuestion',
      async: false,
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      data: JSON.stringify({
        rwAskId: getQueryString("id"),
        questionContent: $("#rating").val()
      }),
      success: function (data) {
        var status = data.status;
        if (status === 200) {
          alert("提交成功!")
        } else {
          alert(data.desc)
        }
      }
    });
  }

});