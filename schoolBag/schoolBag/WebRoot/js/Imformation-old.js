$(function(){
	
	
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //�·� 
	        "d+": this.getDate(), //�� 
	        "H+": this.getHours(), //Сʱ 
	        "m+": this.getMinutes(), //�� 
	        "s+": this.getSeconds(), //�� 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //���� 
	        "S": this.getMilliseconds() //���� 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	
	//δ����Ϣ   �鿴��ǰ�û�δ����Ϣ
	function weidu(){
		//status    1:�Ѷ�  0:δ��
		$.ajax({
			type:'post',
			url:'/schoolBag/SelImfo',
			data:{
				"id":1,
				"status":0,
			},
			success:function(data,status,xhr){
				if(data==0){
					//û��δ����Ϣ
					$(".lefe").html("û��δ����Ϣ");
				}else{
					$.each(eval(data),function(i,v){
						$(".lefe").append(
								'<table border="1"class="ww">'
								+'<tr>'
								+'<td width="12px" height="30px" colspan="2">������Ϣ:<span class="jj">'+v.Content+'</span>��</td>'	
								+'</tr>'
								+'<tr>'
								+'	<td colspan="2" width="300px" height="30px">�������:'+v.taskId+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td rowspan="4"  width="150px" height="70px"><img src="'+v.taskId+'"width="140px"height="140px"/></td>'
								+'</tr>'
								+'<tr>'
								+'	<td  width="180px" height="40px">'+v.Imfotime+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px">'+v.ImfoRec+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px"><a href="#">�鿴��������</a></td>'
								+'</tr>'
								+'<tr>'
								+'<td style="text-align:center" colspan="2"><a href="#" >�鿴�ύ</a></td>'
								+'</tr>'
								+'</table>'
								+'<div class="image" id="" style="border:1px solid #c0c0c0;height:100px;margin-left:500px;display:none">'
								
								+'</div>'
						);
					});
				}
			},
		})
	};
	
	
	
	
	
	//�鿴��ǰ�û����Ѷ���Ϣ
	function yidu(){
		//status    1:�Ѷ�  0:δ��
		$.ajax({
			type:'post',
			url:'/schoolBag/SelImfo',
			data:{
				"id":1,
				"status":1,
			},
			success:function(data,status,xhr){
				if(data==0){
					//û���Ѷ���Ϣ
					$(".lefe").html("û���Ѷ���Ϣ");
				}else{
					$.each(eval(data),function(i,v){
						$(".lefe").append(
								'<table border="1"class="ww">'
								+'<tr>'
								+'<td width="12px" height="30px" colspan="2">������Ϣ:<span class="jj">2</span>��</td>'	
								+'</tr>'
								+'<tr>'
								+'	<td colspan="2" width="300px" height="30px">����</td>'
								+'</tr>'
								+'<tr>'
								+'	<td rowspan="4"  width="150px" height="70px"><img src="../img/1.jpg"width="140px"height="140px"/></td>'
								+'</tr>'
								+'<tr>'
								+'	<td  width="180px" height="40px">���ʱ��:</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px">������:</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px">ȥ����</td>'
								+'</tr>'
								+'</table>'
						);
					});
				}
			},
		})
	};
	weidu();
	
	
	
	
	
})