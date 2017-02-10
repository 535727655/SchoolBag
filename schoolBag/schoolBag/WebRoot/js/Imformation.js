
	var s=0;
	var title=0;
	var wac="0";
	var taskrec=0;
	var kid=10000;
	var userid=0;
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
	
	//获取task任务详情  (任务标题图片   以及  完成   提交图片)
	

	function getTask(taskid){
		$.ajax({
			type:'post',
			url:'/schoolBag/getTaskServlet',
			async:false,
			data:{'taskId':taskid,},
			success:function(data,status,xhr){
				if(data==0)
					s=0;
				else{
					s=(eval(data)[0].taskImage);
					title=(eval(data)[0].taskTitle);
					wac=(eval(data)[0].TaskShancImage);
					taskrec=(eval(data)[0].taskRec);
				}
			},
		});
		return s;
	}
	
	//获取当前登录账号ID
	function getUser(){
		$.ajax({
			type:'post',
			url:'/schoolBag/getSessionUsersServlet',
			async:false,
			success:function(data,status,xhr){
				userid=data;
			}
		})
	}
	
	//.chakan  查看提交   点击事件   查看task表完成任务时提交的图片
	$("body").on("click",".chakan",function(){
		var str=this.getAttribute("taskId");
		getTask(str);
		var ls=new Array();
		ls=wac.split("$");
		var s="#s"+str;
		$(s).css("display","none");
		$(".img-i").remove();
		for(var k=0;k<ls.length;k++){
			kid++;
			if(ls[k]!=""||ls[k].length>0)
			$(s).append("<img class='img-i'  src='"+ls[k]+"' style='display:block;float:left;width:100px;height:60px;'>");
		}
		$(s).css("display","block");
		return false;
	})
	
	
	//当前账号是发布人   就
	
	
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
			success :function(data,status,xhr){
				if(data==0){
					//没有未读消息
					$(".lefe").html("没有未读消息");
				}else{
					$(".lefe").html("");
					$.each(eval(data),function(i,v){
						getTask(v.taskId);
						$(".lefe").append(
								'<div>'
								+'<table border="1"class="ww" cellspacing=0 cellpadding=0 >'
								+'<tr>'
								+'<td width="12px" height="30px" colspan="2">系统消息:<span class="jj">'+v.Content+'</span></td>'	
								+'</tr>'
								+'<tr>'
								+'	<td colspan="2" width="300px" height="30px">任务标题:'+title+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td rowspan="4"  width="150px" height="70px"><img class="taskImage" taskId="'+v.taskId+'" src="'+s+'"width="140px"height="140px"/></td>'
								+'</tr>'
								+'<tr>'
								+'	<td  width="180px" height="40px">'+new Date(v.Imfotime).Format("yyyy/MM/dd HH:mm:ss")+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px">任务接收人:'+taskrec+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px"><a href="/schoolBag/TaskId2?taskId='+v.taskId+'">查看任务详情</a></td>'
								+'</tr>'
								+'<tr>'
								+'<td style="text-align:center" colspan="2"><a class="chakan" taskId="'+v.taskId+'" href="#" >查看提交</a></td>'
								+'</tr>'
								+'</table>'
								+'<div class="image" id="s'+v.taskId+'" style="border:1px solid #c0c0c0;height:100px;margin-left:500px;display:none">'
								+'<div style="width:100%;border:1px solid black;height:30px">'
								+'<a href="#" class="queren hid" imfoId="'+v.ImfoId+'" taskRec="'+taskrec+'" style="display:block;width:70px;height:26px;border:1px solid #c0c0c0;float:left;margin-left:100px;text-align:center;text-decoration:none;">确认</a>'
								+'<a href="#" class="quxiao hid" imfoId="'+v.ImfoId+'" taskRec="'+taskrec+'" style="display:block;width:70px;height:26px;border:1px solid #c0c0c0;float:left;margin-left:100px;text-align:center;text-decoration:none;">取消</a>'
								+'</div>'
								+'</div>'
								+'</div>'
						);
					});
				}
			},
		});
	};
	
	
	
	
	// 确认    imfo状态改成已读   并隐藏该条信息    servlet回执一条信息给接收人   接收人积分增加   updImfostate servlet执行
	$("body").on("click",".queren",function(){
		var s=$(this);
		$.ajax({
			type:'post',
			url:'/schoolBag/updImfostate',
			data:{"imfoId":this.getAttribute("imfoId")},
			success:function(data,status,xhr){
				if(data==0)
					alert("确认失败");
				else{
					s.parent().parent().parent().hide();
				}
			},
		})
		return false;
	});
	
	//取消  不操作
	$("body").on("click",".quxiao",function(){
		var s=$(this);
		s.parent().parent().css("display","none");
		return false;
	});
	
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
					$(".lefe").html("");
					$.each(eval(data),function(i,v){
						$(".lefe").append(
								'<table border="1"class="ww" cellspacing=0 cellpadding=0 >'
								+'<tr>'
								+'<td width="12px" height="30px" colspan="2">系统消息:<span class="jj">'+v.Content+'</span></td>'	
								+'</tr>'
								+'<tr>'
								+'	<td colspan="2" width="300px" height="30px">任务标题:'+title+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td rowspan="4"  width="150px" height="70px"><img class="taskImage" taskId="'+v.taskId+'" src="'+s+'"width="140px"height="140px"/></td>'
								+'</tr>'
								+'<tr>'
								+'	<td  width="180px" height="40px">'+new Date(v.Imfotime).Format("yyyy/MM/dd HH:mm:ss")+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px">任务接收人:'+taskrec+'</td>'
								+'</tr>'
								+'<tr>'
								+'	<td  height="40px"><a href="/schoolBag/TaskId2?taskId='+v.taskId+'">查看任务详情</a></td>'
								+'</tr>'
								+'<tr>'
								+'<td style="text-align:center" colspan="2"><a class="chakan" taskId="'+v.taskId+'" href="#" >查看提交</a></td>'
								+'</tr>'
								+'</table>'
								+'<div class="image" id="s'+v.taskId+'" style="border:1px solid #c0c0c0;height:100px;margin-left:500px;display:none">'
								+'</div>'
						);
					});
				}
			},
		})
	};
	//默认未读 
	weidu();
	
	//已读点击事件
	$("body").on("click","#yidu",function(){
		yidu();
		false;
	});
	//未读点击事件
	$("body").on("click","#weidu",function(){
		weidu();
		false;
	});
	
	
	//隐藏不需要的按钮   
	$(".hid").each(function(){
		getUser();
		if(this.getAttribute("taskRec")==userid)
			$(this).css("display","none");
	})
	
	
})