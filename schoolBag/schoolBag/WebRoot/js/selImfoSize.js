/**
 * 查看当前账号的imformation消息
 */
$(function(){
	//获取用户未读的数量
	$.ajax({
		type:"post",
		url:"/schoolBag/SelImfo",
		data:{'id':0,'status':0},
		success:function(data,status,xhr){
			$("#myImfoSize").text(data);
		},
	});
	
});
