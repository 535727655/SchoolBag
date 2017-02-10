$(function(){
	
	
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "H+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	
	//未读消息   查看当前用户未读消息
	function weidu(){
		//status    1:已读  0:未读
		$.ajax({
			type:'post',
			url:'/schoolBag/SelImfo',
			data:{
				"id":1,
				"status":0,
			},
			success:function(data,status,xhr){
				if(data==0){
					//没有未读消息
					$(".lefe").html("没有未读消息");
				}else{
					$.each(eval(data),function(i,v){
						$(".lefe").append(
								'<table border="1"class="ww">'
								+'<tr>'
								+'<td width="12px" height="30px" colspan="2">服务消息:<span class="jj">'+v.Content+'</span>条</td>'	
								+'</tr>'
								+'<tr>'
								+'	<td colspan="2" width="300px" height="30px">任务标题:'+v.taskId+'</td>'
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
								+'	<td  height="40px"><a href="#">查看任务详情</a></td>'
								+'</tr>'
								+'<tr>'
								+'<td style="text-align:center" colspan="2"><a href="#" >查看提交</a></td>'
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
	
	
	
	
	
	//查看当前用户的已读信息
	function yidu(){
		//status    1:已读  0:未读
		$.ajax({
			type:'post',
			url:'/schoolBag/SelImfo',
			data:{
				"id":1,
				"status":1,
			},
			success:function(data,status,xhr){
				if(data==0){
					//没有已读消息
					$(".lefe").html("没有已读消息");
				}else{
					$.each(eval(data),function(i,v){
						$(".lefe").append(
								'<table border="1"class="ww">'
								+'<tr>'
								+'<td width="12px" height="30px" colspan="2">服务消息:<span class="jj">2</span>条</td>'	
								+'</tr>'
								+'<tr>'
								+'	<td colspan="2" width="300px" height="30px">标题</td>'
								+'</tr>'
								+'<tr>'
								+'	<td rowspan="4"  width="150px" height="70px"><img src="../img/1.jpg"width="140px"height="140px"/></td>'
								+'</tr>'
								+'<tr>'
								+'	<td  width="180px" height="40px">完成时间:</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px">接收人:</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px">去看看</td>'
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