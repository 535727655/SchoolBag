$(function(){
	//��ȡ��ǰ�û���ϸ��Ϣ
	function getUsers(){
		$.ajax({
			type:'post',
			url:'/schoolBag/SelUsersServlet',
			success:function(data,status,xhr){
				if(data==0){
					//û������   !������
				}else{
					$.each(eval(data),function(i,v){
						//�����������
					});
				}
			},
		});
	}
});