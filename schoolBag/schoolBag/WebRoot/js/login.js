$(function(){
	$("input[name=sub]").click(function(){
		if(($("input[name=userId]").val())==""||$("input[name=userPwd]").val()==""){
			$("#msg").text("账号或密码不能为空");
		}
		else{
			$.ajax({
				type:"post",
				url:'/schoolBag/login.do',
				data:{"userId":$("input[name=userId]").val(),"userPwd":$("input[name=userPwd]").val()},
				success:function(data,status,xhr){
					if(data==1)
						location.href="/schoolBag/index.html";
					else
						$("#msg").text(data);
				}
			});
		}
			
	});

	
});
