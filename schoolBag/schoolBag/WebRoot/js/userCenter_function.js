$(function(){
	//获取当前用户详细信息
	function getUsers(){
		$.ajax({
			type:'post',
			url:'/schoolBag/SelUsersServlet',
			success:function(data,status,xhr){
				if(data==0){
					//没有数据   !不可能
				}else{
					$.each(eval(data),function(i,v){
						//查出来的数据
					});
				}
			},
		});
	}
});