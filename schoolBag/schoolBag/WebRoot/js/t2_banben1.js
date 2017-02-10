var max=0;

$(function(){
	$.ajax({
		type:'post',
		url:'/schoolBag/H_Count',
		success:function(data,status,xhr){
			if(data!=0){
				max=parseInt(data);
				for(var i=0;i<parseInt(data);i++){
					$("#anniu").append("<a class='an' href='#'>"+(i+1)+"</a>");
				}
			}
			
		},
	});
	var i=1,row=10,TaskType=null,TaskState=null,TaskUserId=null,TaskRec=null;
	
	
	
	
//	*必要参数 i=当前页数    row=每页多少行
//	 *
//	 *类型筛选条件  TaskType   一个1234
//	 *状态筛选条件 TaskState	     一个5678
//	 *发布人筛选 TaskUserId  一个
//	 *接收人筛选TaskRec 一个
	
	
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
				$("#youbian-1").html("");
				$.each(eval(data),function(index,v){
					$("#youbian-1").append(
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
							+'<div style=" width:1010px;float: left;margin-left: -24px; padding-left: 10px;;">'
                     		+'<div class="mubiao"style="background-color: #EAF8FF">'
                     		+'<input type="checkbox"/>'
                     		+'<img src="/schoolBag/img/shanchu.png" width="20px";height="20px"align="right"style="margin-top:10px;margin-right: 20px;"title="删除"/>'
                     		+'<img src="/schoolBag/img/bianji.png" width="20px";height="20px"align="right"style="margin-top:10px;margin-right: 30px;"title="编辑"/>'
                     		+'</div>'
                     		+'<div class="muviao1"><img src="'+v.taskImage+'" width="150px" /></div>'
                     		+'<div class="muviao2" style="text-align:center;vertical-align:center;line-height:80px">'+v.taskTitle+'</div>'
                     		+'<div class="muviao3">'+v.taskType+'</div>'
                     		+'<div class="muviao4">'+v.taskBeginTime+'</div>'
                     		+'<div class="muviao7">'+v.taskEndTime+'</div>'
                     		+'<div class="muviao5">'+v.taskState+'</div>'
                     		+'<div class="muviao6">'+v.taskMoney+'</div>'
                     		+'<div class="muviao8">'+v.taskUserid+'</div>'
                     		+'<div class="muviao9">'+v.taskRec+'</div> '		
                     		+'</div>'
                     );
				});
			}else{
				$("#youbian-1").html("没有内容");
			}
		},
	})
	}
	tijiao();
	
	//window.parent.forms["form1"].控件ID.value
	//window.parent.$(“div”)
	window.parent.$("#dailingqu").click(function(){
		TaskState=8;
		tijiao();
		return false;
	});
	window.parent.$("#chulizhong").click(function(){
		TaskState=5;
		tijiao();
		return false;
	});
	window.parent.$("#yiwancheng").click(function(){
		TaskState=6;
		tijiao();
		return false;
	});
	window.parent.$("#yiquxiao").click(function(){
		TaskState=7;
		tijiao();
		return false;
	});
	
	
	
	
	//类型筛选
	window.parent.$("#diaocha").click(function(){
		TaskType=1;
		tijiao();
		return false;
	});
	window.parent.$("#xianxia").click(function(){
		TaskType=2;
		tijiao();
		return false;
	});
	window.parent.$("#xianshang").click(function(){
		TaskType=3;
		tijiao();
		return false;
	});
	window.parent.$("#qita").click(function(){
		TaskType=4;
		tijiao();
		return false;
	});
	
	
	
	
	//模糊查询
	$("#sub").click(function(){
		TaskUserId=$("#TaskUserId").val();
		TaskRec=$("#TaskRec").val();
		tijiao();
	});
	
	
	//上一页
	$("#top").click(function(){
		i-=1;
		if(i<=0)
			return false;
		tijiao();
		return false;
	})
	//下一页
	$("#down").click(function(){
		i+=1;
		if(i>max)
			return false;
		tijiao();
		return false;
	})
	
	//Go
	$("#go").click(function(){
		i=$("#yemian").val();
		if(i>max||i<=0)
			return false;
		tijiao();
		return false;
	})
	
});