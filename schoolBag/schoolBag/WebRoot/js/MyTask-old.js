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
	
	
	function weiwancheng(){
		$.ajax({
			type:'post',
			url:'/schoolBag/getTaskListServlet',
			data:{"add":"TaskState!=2"},
			success:function(data,status,xhr){
				$("#youbian-1").html(
					'<div id="youbian-1-1">'
						+'<span class="kuai5"><b></b></span>'
						+'</div>'
				);
				if(data==0){
					$("#youbian-1").append("<h2>没有内容</h2>");
				}else{
					$.each(eval(data),function(i,v){
						$("#youbian-1").append(
								'<div class="youbian-1-2">	'
								+'<div class="youbian-1-2-1">'
								+'	<img src="'+v.taskImage+'">'
								+'</div>'
								+'<div class="youbian-1-2-2">'
								+'		<div class="wenzi1"><b><a href="">'+v.taskTitle+'</a></b></div>'
								+'		<div class="duan1">任务时间：'+new Date(v.taskBeginTime).Format("yyyy/MM/dd HH:mm:ss")+'-'+new Date(v.taskEndTime).Format("yyyy/MM/dd HH:mm:ss")+'</div>'
								+'		<div class="duan2">参与条件：</div>'
								+'		<div class="duan4">价格：<b style="color:red;font-size:20px">564</b style="color:red">'+v.taskMoney+'元</div>'
								+'		<div class="duan5"><a href="/schoolBag/TaskId2?taskId='+v.taskId+'">立即查看</a></div>'
								+'</div>'
								+'	</div>'
						);
					})
				}
			},
		});
	}
	
	
	//已完成
	function yiwancheng(){
		$.ajax({
			type:'post',
			url:'/schoolBag/getTaskListServlet',
			data:{"add":"TaskState=2"},
			success:function(data,status,xhr){
				$("#youbian-1").html(
					'<div id="youbian-1-1">'
						+'<span class="kuai5"><b></b></span>'
						+'</div>'
				);
				if(data==0){
					$("#youbian-1").append("<h2>没有内容</h2>");
				}else{
					$.each(eval(data),function(i,v){
						$("#youbian-1").append(
								'<div class="youbian-1-2">	'
								+'<div class="youbian-1-2-1">'
								+'	<img src="'+v.taskImage+'">'
								+'</div>'
								+'<div class="youbian-1-2-2">'
								+'		<div class="wenzi1"><b><a href="">'+v.taskTitle+'</a></b></div>'
								+'		<div class="duan1">任务时间：'+new Date(v.taskBeginTime).Format("yyyy/MM/dd HH:mm:ss")+'-'+new Date(v.taskEndTime).Format("yyyy/MM/dd HH:mm:ss")+'</div>'
								+'		<div class="duan2">参与条件：</div>'
								+'		<div class="duan4">价格：<b style="color:red;font-size:20px">564</b style="color:red">'+v.taskMoney+'元</div>'
								+'		<div class="duan5"><a href="/schoolBag/TaskId2?taskId='+v.taskId+'">立即查看</a></div>'
								+'</div>'
								+'	</div>'
						);
					})
				}
			},
		});
	}
	
	
	//全部
	function quanbu(){
		$.ajax({
			type:'post',
			url:'/schoolBag/getTaskListServlet',
			data:{"add":"1=1"},
			success:function(data,status,xhr){
				$("#youbian-1").html(
					'<div id="youbian-1-1">'
						+'<span class="kuai5"><b></b></span>'
						+'</div>'
				);
				if(data==0){
					$("#youbian-1").append("<h2>没有内容</h2>");
				}else{
					$.each(eval(data),function(i,v){
						$("#youbian-1").append(
								'<div class="youbian-1-2">	'
								+'<div class="youbian-1-2-1">'
								+'	<img src="'+v.taskImage+'">'
								+'</div>'
								+'<div class="youbian-1-2-2">'
								+'		<div class="wenzi1"><b><a href="">'+v.taskTitle+'</a></b></div>'
								+'		<div class="duan1">任务时间：'+new Date(v.taskBeginTime).Format("yyyy/MM/dd HH:mm:ss")+'-'+new Date(v.taskEndTime).Format("yyyy/MM/dd HH:mm:ss")+'</div>'
								+'		<div class="duan2">参与条件：</div>'
								+'		<div class="duan4">价格：<b style="color:red;font-size:20px">564</b style="color:red">'+v.taskMoney+'元</div>'
								+'		<div class="duan5"><a href="/schoolBag/TaskId2?taskId='+v.taskId+'">立即查看</a></div>'
								+'</div>'
								+'	</div>'
						);
					})
				}
			},
		});
	}
	
	
	$("#quanbu").click(function(){
		quanbu();
	})
	$("#yiwancheng").click(function(){
		yiwancheng();
	})
	$("#weiwancheng").click(function(){
		alert("1");
		weiwancheng();
	})
})