/**
 * �鿴��ǰ�˺ŵ�imformation��Ϣ
 */
$(function(){
	//��ȡ�û�δ��������
	$.ajax({
		type:"post",
		url:"/schoolBag/SelImfo",
		data:{'id':0,'status':0},
		success:function(data,status,xhr){
			$("#myImfoSize").text(data);
		},
	});
	
});
