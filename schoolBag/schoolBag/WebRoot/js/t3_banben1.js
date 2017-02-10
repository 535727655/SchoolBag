var max=0;
$(function(){
	$.ajax({
		type:'post',
		url:'/schoolBag/getUsersCountServlet',
		success:function(data,status,xhr){
			if(data!=0){
				max=parseInt(data);
				for(var i=0;i<parseInt(data);i++){
					$("#anniu").append("<a class='an' href='#'>"+(i+1)+"</a>");
				}
			}
		},
	});
	
	//可选上传4个参数 i row userId userName
	
	var i=1,row=10,userId=null,userName=null;
	
	function tijiao(){
			$.ajax({
				type:'post',
				url:'/schoolBag/SelUsersForLikeServlet',
				data:{
					"i":i,
					"row":row,
					"userId":userId,
					"userName":userName,
				},
				success:function(data,status,xhr){
					if(data!=0){
						$("#table").html(
								'<tr class="td">'
								+'<td width="50px" height="40px">编号</td>'
								+'<td width="150px" height="40px">用户昵称</td>'
								+'<td width="150px" height="40px">用户账号</td>'
								+'<td width="150px" height="40px">手机号码</td>'
								+'<td width="150px" height="40px">所获积分</td>'
								+'<td width="150px" height="40px">注册时间</td>'
								+'<td colspan="2" width="200px" height="40px">操作</td>'
								+'</tr>'
						);
						$.each(eval(data),function(index,v){
							$("#table").append(
									'<tr class="td">'
									+'<td width="50px" height="40px">'+index+'</td>'
									+'<td width="150px" height="40px">'+v.userName+'</td>'
									+'<td width="150px" height="40px">'+v.userId+'</td>'
									+'<td width="150px" height="40px">'+v.phone+'</td>'
									+'<td width="150px" height="40px">'+v.userInt+'</td>'
									+'<td width="150px" height="40px">'+v.time+'</td>'
									+'<td colspan="2" width="200px" height="40px">操作</td>'
									+'</tr>'	
							);
						})
					}
				},
			});
	
	};
	
	tijiao();
	
	
	//like模糊查询
	$("#sub").click(function(){
		userId=$("#userId").val();
		userName=$("#userName").val();
		tijiao();
	});
	
	
	
	$("#top").click(function(){
		i-=1;
		if(i<=0)
			return false;
		tijiao();
		return false;
	})
	//下一页
	$("#down").click(function(){
		i+=1;
		if(i>max)
			return false;
		tijiao();
		return false;
	})
	
	//Go
	$("#go").click(function(){
		i=$("#yemian").val();
		if(i>max||i<=0)
			return false;
		tijiao();
		return false;
	})
})