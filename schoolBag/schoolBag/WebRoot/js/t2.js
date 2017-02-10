

$(function(){
	var max=0;
	
	
//	*必要参数 i=当前页数    row=每页多少行
//	 *
//	 *类型筛选条件  TaskType   一个1234
//	 *状态筛选条件 TaskState	     一个5678
//	 *发布人筛选 TaskUserId  一个
//	 *接收人筛选TaskRec 一个
	var i=1,row=10,TaskType=null,TaskState=null,TaskUserId=null,TaskRec=null;
	
	
	//当前选中的按钮变色
	function select(){
		var s=$(".an");
		for(var k=0;k<s.length;k++){
			if(s[k].innerText==i){
				s[k].style.color="red";
			}else
				s[k].style.color="#4B177A";
		}
	};
	function huoqu(){
		$.ajax({
			type:'post',
			url:'/schoolBag/H_Count',
			data:{"row":row},
			success:function(data,status,xhr){
				$("#anniu").html('<a href="#" style="display:block;float:left;border:1px solid #c0c0c0;padding:5px;" id="top">上一页</a>'
             	   		+'<a href="#"  style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;" id="dowm">下一页</a>'
             	   	+'<a href="#" Style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;margin-right:10px" id="go">Go</a>'
             	   +'<input type="text" id="yemian" style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;height:18px"/>'
             	   	);
				if(data!=0){
					max=parseInt(data);
					for(var i=0;i<parseInt(data);i++){
						$("#anniu").append("<a class='an' href='#'>"+(i+1)+"</a>");
					}
				}
				
			},
		});
	}
	
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


	
	
	function tijiao(){
		$.ajax({
		type:'post',
		url:'/schoolBag//H_index',
		data:{
			"i":i,
			"row":row,
			"TaskType":TaskType,
			"TaskState":TaskState,
			"TaskUserId":TaskUserId,
			"TaskRec":TaskRec
		},
		success:function(data,status,xhr){
			if(data!=0){
				$("#youbian-1").html(
						'<div id="fudong" style="float:left;background-color: #F5F5F5;">'
                     	+'<div id="fudong2"><input type="checkbox"/></div>'
                     	+'<div id="fudong4">图片</div>'
                     	+'<div id="fudong9">标题</div>'
                     	+'<div id="fudong5">任务类型</div>'
                     	+'<div id="fudong6">开始时间</div>'
                     	+'<div id="fudong10">结束时间</div>'
                     	+'<div id="fudong7">状态</div>'
                     	+'<div id="fudong8">酬劳</div>'
                     	+'<div id="fudong11">发布人</div>'
                     	+'<div id="fudong12">接收人</div>'
                     	+'</div>'
						);
				$.each(eval(data),function(index,v){
					var rec="无";
					if(v.taskRec!=null)
						rec=v.taskRec;
						
					$("#youbian-1").append(
							'<div id="q" style=" width:1010px;float: left;margin-left: -24px; padding-left: 10px;background-color:#F5F5F5;">'
                     		+'<div class="mubiao"style="background-color: #EAF8FF;margin-top:30px">'
                     		+'<input type="checkbox"/>'
                     		+'<img	id="shanchu" taskid="'+v.taskId+'"  src="/schoolBag/img/shanchu.png" width="20px";height="20px"align="right"style="margin-top:10px;margin-right: 20px;"title="删除"/>'
                     		+'</div>'
                     		+'<div class="muviao1"><img src="'+v.taskImage+'" width="150px" height="150px" /></div>'
                     		+'<input readonly class="muviao2 c1" taskid="'+v.taskId+'" name="taskTitle" style="text-align:center;vertical-align:center;line-height:80px" value="'+v.taskTitle+'"/>'
                     		+'<input readonly class="muviao3 c1" taskid="'+v.taskId+'" name="taskType" value="'+v.taskType+'"/>'
                     		+'<input readonly class="muviao4 c1" taskid="'+v.taskId+'" name="taskBeginTime" value="'+new Date(v.taskBeginTime).Format("yyyy/MM/dd HH:mm:ss")+'"/>'
                     		+'<input readonly class="muviao7 c1" taskid="'+v.taskId+'" name="taskEndTime" value="'+(new Date(v.taskEndTime)).Format("yyyy/MM/dd HH:mm:ss")+'"/>'
                     		+'<input readonly class="muviao5 c1" taskid="'+v.taskId+'" name="taskState" value="'+v.taskState+'"/>'
                     		+'<input readonly class="muviao6 c1" taskid="'+v.taskId+'" name="taskMoney" value="'+v.taskMoney+'"/>'
                     		+'<input readonly class="muviao8 c1" taskid="'+v.taskId+'" name="taskUserid" value="'+v.taskUserid+'"/>'
                     		+'<input readonly class="muviao9 c1" taskid="'+v.taskId+'" name="rec" value="'+rec+'"/>'	
                     		+'</div>'
                     		//(new Date(v.taskEndTime)).toLocaleDateString() + " " + (new Date()).toLocaleTimeString()
                     );
				});
			}else{
				$("#youbian-1").html("没有内容");
			}
		},
	})
	}
	
	
	//执行获取和提交
	huoqu();
	tijiao();
	
	//input双击取消disabled   可修改
	$("#youbian-1").on("dblclick",".c1",function(){
		$(this).removeAttr("readonly");
		$(this).focus();
	});
	//失去焦点提交
	$("#youbian-1").on("blur",".c1",function(){
		$(this).attr("readonly","true");
		$.ajax({
			type:'post',
			url:'/schoolBag/updateTaskServlet',
			data:{
				"taskid":this.getAttribute("taskid"),
				"add":this.name,
				"value":this.value,
				},
			success:function(data,status,xhr){
				if(data==0)
					alert("保存失败");
			}
		})
	});
	
	
	//删除
	$("#youbian-1").on("click","#shanchu",function(){
		var s=$(this);
		$.ajax({
			type:'post',
			url:'/schoolBag/DeleteTaskServlet',
			data:{
				"taskid":this.getAttribute("taskid"),
				},
			success:function(data,status,xhr){
				if(data==0)
					alert("删除失败");
				else{
					//$(this).parent().parent().hide();
					s.parent().parent().hide("drop");
				}
			}
		})
	})

	

	
	//window.parent.forms["form1"].控件ID.value
	//window.parent.$(“div”)
	window.parent.$("#dailingqu").click(function(){
		TaskState=8;
		huoqu();
		tijiao();
		return false;
	});
	window.parent.$("#chulizhong").click(function(){
		TaskState=5;
		huoqu();
		tijiao();
		return false;
	});
	window.parent.$("#yiwancheng").click(function(){
		TaskState=6;
		huoqu();
		tijiao();
		return false;
	});
	window.parent.$("#yiquxiao").click(function(){
		TaskState=7;
		huoqu();
		tijiao();
		return false;
	});
	
	
	
	
	//类型筛选
	window.parent.$("#diaocha").click(function(){
		TaskType=1;
		huoqu();
		tijiao();
		return false;
	});
	window.parent.$("#xianxia").click(function(){
		TaskType=2;
		huoqu();
		tijiao();
		return false;
	});
	window.parent.$("#xianshang").click(function(){
		TaskType=3;
		huoqu();
		tijiao();
		return false;
	});
	window.parent.$("#qita").click(function(){
		TaskType=4;
		huoqu();
		tijiao();
		return false;
	});
	
	
	
	
	//模糊查询
	$("#sub").click(function(){
		TaskUserId=$("#TaskUserId").val();
		TaskRec=$("#TaskRec").val();
		huoqu();
		tijiao();
	});
	
	
	//上一页
	$("#anniu").on("click","#top",function(){
		if((i-1)<=0)
			return false;
		i-=1;
		select();
		tijiao();
		return false;
	})
	//下一页
	$("#anniu").on("click","#down",function(){
		if((i+1)>max)
			return false;
		i+=1;
		select();
		tijiao();
		return false;
	})
	
	//Go
	$("#anniu").on("click","#go",function(){
		if($("#yemian").val()>max||$("#yemian").val()<=0)
			return false;
		i=$("#yemian").val();
		select();
		tijiao();
		return false;
	})
	
	
	//绑定按钮事件
	$("#anniu").on("click",".an",function(e){
		i=$(this).text();
		if(i>max||i<=0)
			return false;
		select();
		tijiao();
		return false;
	});
	
	
});