$(function(){
	
	
	$.ajax({
		type:'post',
		url:'/schoolBag/SelUsersServlet',
		success:function(data,status,xhr){
			$.each(eval(data),function(i,v){
				$("#userId").text(v.userId);
				$("#userName").val(v.userName);
				$("#address").val(v.AddressId);
				$("#phone").val(v.phone);
				$("#touxiang")[0].src="'"+v.touxiang+"'";
			})
			
		}
	})
	
//	$.ajax({
//		type:'post',
//		url:'/schoolBag/toAddressServlet',
//		data:{"addressid":$("#address").val()},
//		success:function(data,status,xhr){
//			$("#address").val(data);
//		}
//	})
})