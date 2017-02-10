
$(function(){
	
	$.ajax({
		type:'post',
		url:'/schoolBag/AllAddress',
		datatype:'json',
		success:function(data,status,xhr){
			$("select[name=address]").html("");
			$.each(eval(data),function(i,v){
				$("select[name=address]").append("<option value="+v.addressid+">"+v.addressname+"</option>");
			});
		}
	});
	$("input[name=userId]").change(function(){
		if($("input[name=userId]").val()!=""){
			$.ajax({
				type:'post',
				url:'/schoolBag/existsUser',
				data:{"userId":$("input[name=userId]").val()},
				success:function(data,status,xhr){
					if(data==0){
						//该用户名未被占用
						$(".login-2-2").text("");
					}else{
						//该用户名已被占用
						$(".login-2-2").text("该账号已被注册");
					}
					
				},
			});
		}else{
			$(".login-2-2").text("账号不能为空");
		}
		an();
			
	});

		
	$("input[name=userPwd]").change(function(){
		if($("input[name=userPwd]").val()=="")
			$("#mm").text("密码不能为空");
		else
			$("#mm").text("");
		jc();
		an();	
	});
	
	$("input[name=qrPwd]").change(function(){
		if($("input[name=qrPwd]").val()=="")
			$("#qrmm").text("确认密码不能为空");
		else
			$("#qrmm").text("");
		jc();
		an();	
	});
		
	$("input[name=userName]").change(function(){
		if($("input[name=userName]").val()=="")
			$("#xm").text("姓名不能为空");
		else
			$("#xm").text("");
		an();	
	});
		
	$("input[name=phone]").change(function(){
		if($("input[name=phone]").val()=="")
			$("#ph").text("手机号码不能为空");
		else
			$("#ph").text("");
		an();	
	});
	
	
	$("input[name=yzm]").change(function(){
		$.ajax({
			type:'post',
			url:"/schoolBag/yanzheng.do",
			data:{"yzm":$("input[name=yzm]").val()},
			success:function(data,status,xhr){
				$("#yzm").val(data);
			}
		});
		an();	
	});
	
	var jc=function (){
		if($("input[name=userPwd]").val()==$("input[name=qrPwd]").val()){
			$("#mm").val("");
			$("#qrmm").val("");
		}else{
			$("#qrmm").text("两次密码输入不相同");
		}
	};
	
	var an=function(){
		if($("input[name=userId]").val()==""||$("input[name=userPwd]").val()==""||$("input[name=qrPwd]").val()==""||$("input[name=userName]").val()==""||$("input[name=phone]").val()==""){
		
			$("input[name=sub]").attr({disabled:true});
			return false;
		}
		else
			$("input[name=sub]").attr({disabled:false});
	};
	
	$("input[name=sub]").click(function(){
		an();
//		$.ajax({
//			type:"post",
//			url:"/schoolBag/regist.do",
//			async:true,
//			data:{
//				"userId":$("input[name=userId]").val(),
//				"userPwd":$("input[name=userPwd]").val(),
//				"userName":$("input[name=userName]").val(),
//				"phone":$("input[name=phone]").val(),
//				"address":$("select[name=address]").val(),
//			},
//			success:function(data,status,xhr){
//				if(data==1)
//					location.href="/schoolBag/login.html";
//				else
//					alert(data);
//			}
//		});
	});
	
	  
 
	
	
});