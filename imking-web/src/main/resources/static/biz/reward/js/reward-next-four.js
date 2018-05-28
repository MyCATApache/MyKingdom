
var id;
var rwAskTagIdList = new Array();
$(function(){
	id = getQueryString("id");
	//消息提示不显示
	$('#message').css({'display':'none'});
	
	getAllRwAskTagList();
	
	//根据红包获取标签
	queryRwAskRelationshipListByRwAskId();
	
	$("#saveRwAskTag").on("click",function(){
		var tag_name = $("#tag_name").val()
		if(tag_name.length==0){
			$('#message').css({'display':'block'});
			$('#message span').text('请输入标签名称')
		}
		$.post({
			url:"/api/rwAskTag/saveRwAskTag",
			data:{tagName:tag_name},
			dataType:"json",
			success:function(data){
				if(data.status==200){
					$('#message').css({'display':'block'});
					$('#message span').text(data.data);
					getAllRwAskTagList();
					$("#tag_name").val("");
				}
			}
		})
	});
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

//下一步跳转
function reWardFive(){
	var rwAskTagId = new Array();
	$('input:checkbox:checked').each(function(){
		rwAskTagId.push($(this).val())
	})
	if(rwAskTagId.length==0){
		$('#message').css({'display':'block'});
		$('#message span').text('请输入选择红包标签')
		return false;
	}
	if(rwAskTagId.length>5){
		$('#message').css({'display':'block'});
		$('#message span').text('红包标签不超过5个')
		return false;
	}
	$.post({
		url:'/api/rwAskTagRelationship/saveRwAskTagRelationship',
		data: {rwAskTagIds: rwAskTagId.join(','),rwAskId : id},
		dataType:"JSON",
		success:function(data){
			if(data.status==200){
				$('#message').css({'display':'block'});
				$('#message span').text(data.data)
				location.href="/biz/reward/reward-next-six.html"
			}
		}
	})
 	
}

//获取所有的标签并填充DIV
function getAllRwAskTagList(){
	$('#rwAskTag').empty();
	$.get({
		url:'/api/rwAskTag/queryRwAskTagList',
		dataType:'JSON',
		success:function(data){
			if(data.status==200){
				$.each(data.data,function(item){
					var html ='<input type="checkbox"  name="rwAskTag" style="margin:15px;" id="rwAskTagChk'+data.data[item].id+'"  value="'+data.data[item].id+'"/>'+data.data[item].tagName;
					$('#rwAskTag').append(html);
				})
			}
		},
	})
}


//获取红包标签关系
function queryRwAskRelationshipListByRwAskId(){
	$.get({
		url:'/api/rwAskTagRelationship/queryRwAskTagRelationshipList',
		data:{rwAskId:id},
		dataType:'JSON',
		success:function(data){
			$.each(data.data,function(item){
				$("#rwAskTagChk"+data.data[item].tagId).prop('checked','checked');
			})
		}
	})
}
