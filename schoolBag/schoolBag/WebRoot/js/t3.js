
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
	var max=0;//按钮数

	//可选上传4个参数 i row userId userName
	var i=1,row=20,userId=null,userName=null;
	
	
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

	//获取按钮
	function huoqu(){
			$.ajax({
				type:'post',
				url:'/schoolBag/getUsersCountServlet',
				data:{"row":row},
				success:function(data,status,xhr){
					$("#anniu").html('<a href="#" style="display:block;float:left;border:1px solid #c0c0c0;padding:5px;" id="top">上一页</a>'
                 	   		+'<a href="#"  style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;" id="dowm">下一页</a>'
                 	   	+'<a href="#" Style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;margin-right:10px" id="go">Go</a>'
                 	   +'<input type="text" id="yemian" style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;height:18px"/>'
                 	   	);
					if(data!=0){
						max=parseInt(data);
						for(var k=0;k<parseInt(data);k++){
							$("#anniu").append("<a class='an' href='#'>"+(k+1)+"</a>");
						};
						select();
					};
				},
		});
	}
	
	//按钮居中事件
//	function cet(j){
//		$("#anniu").html('<a href="#" style="display:block;float:left;border:1px solid #c0c0c0;padding:5px;" id="top">上一页</a>'
//     	   		+'<a href="#"  style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;" id="dowm">下一页</a>'     	   		
//     	   	+'<a href="#" Style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;margin-right:10px" id="go">Go</a>'
//     	   +'<input type="text" id="yemian" style="display:block;float:right;border:1px solid #c0c0c0;padding:5px;height:18px"/>');
//		if(max<=7){
//			for(var k=0;k<max;k++)
//				$("#anniu").append("<a class='an' href='#'>"+(k+1)+"</a>");
//		}else{
//			if((j-3)<=0)
//				for(var k=0;k<7;k++)
//					$("#anniu").append("<a class='an' href='#'>"+(k+1)+"</a>");
//			else if((j+3)>=max)
//				$("#anniu").append("<a class='an' href='#'>"+(max-j+k)+"</a>");
//				j++;
//		};
//	}
	
	
	
	function tijiao(){
	
		
		//获取数据
			$.ajax({
				type:'post',
				url:'/schoolBag/SelUsersForLikeServlet',
				data:{
					"i":i,
					"row":row,
					"userId":userId,
					"userName":userName,
				},
				success:function(data,status,xhr){
					if(data!=0){
						$("#table").html(
								'<tr class="td">'
								+'<td width="50px" height="40px">编号</td>'
								+'<td width="150px" height="40px">用户昵称</td>'
								+'<td width="150px" height="40px">用户账号</td>'
								+'<td width="150px" height="40px">用户密码</td>'
								+'<td width="150px" height="40px">手机号码</td>'
								+'<td width="150px" height="40px">所获积分</td>'
								+'<td width="150px" height="40px">注册时间</td>'
								+'<td  width="50px" height="40px">操作</td>'
								+'</tr>'
						);
						$.each(eval(data),function(index,v){
							$("#table").append(
									'<tr class="td">'
									+'<td width="50px" height="40px"><input  readonly type="text" style="text-align:center;width:50px;height:40px;outLine:none;border:none" value="'+(index+1)+'"/></td>'
									+'<td width="150px" height="40px"><input userid="'+v.userId+'"  class="c1"  readonly  type="text" style="text-align:center;width:150px;height:40px;outLine:none;border:none" name="userName" value="'+v.userName+'"/></td>'
									+'<td width="150px" height="40px"><input userid="'+v.userId+'"  class="c1"   readonly type="text" style="text-align:center;width:150px;height:40px;outLine:none;border:none" name="userId" value="'+v.userId+'"/></td>'
									+'<td width="150px" height="40px"><input userid="'+v.userId+'"  class="c1"  readonly  type="text" style="text-align:center;width:150px;height:40px;outLine:none;border:none" name="userPwd" value="'+v.userPwd+'"/></td>'
									+'<td width="150px" height="40px"><input userid="'+v.userId+'"  class="c1"  readonly  type="text" style="text-align:center;width:150px;height:40px;outLine:none;border:none" name="phone" value="'+v.phone+'"/></td>'
									+'<td width="80px" height="40px"><input userid="'+v.userId+'"  class="c1"   readonly type="text" style="text-align:center;width:80px;height:40px;outLine:none;border:none" name="userInt" value="'+v.userInt+'"/></td>'
									+'<td width="150px" height="40px"><input userid="'+v.userId+'"   class="c1"  readonly type="text" style="text-align:center;width:150px;height:40px;outLine:none;border:none" name="time" value="'+(new Date(v.time)).Format("yyyy/MM/dd HH:mm:ss")+'"/></td>'
									+'<td  width="50px" height="40px"><a userid="'+v.userId+'" href="#" class="shanchu" >删除</a></td>'
									+'</tr>'	
							);
						})
					}else{
						$("#table").html("没有内容");
					}
				},
			});
	
	};

	huoqu();
	tijiao();
	
	//input双击取消disabled   可修改
	$("body").on("dblclick",".c1",function(){
		$(this).removeAttr("readonly");
		$(this).focus();
	});
	//失去焦点提交
	$("body").on("blur",".c1",function(){
		$(this).attr("readonly","true");
		$.ajax({
			type:'post',
			url:'/schoolBag/UpdateUsers',
			data:{
				"userid":this.getAttribute("userid"),
				"add":this.name,
				"value":this.value,
				},
			success:function(data,status,xhr){
				if(data==0)
					alert("保存失败");
			}
		})
	});
	
	
	
	//删除操作
	$("body").on("click",".shanchu",function(){
		var s=$(this);
		$.ajax({
			type:'post',
			url:'/schoolBag/DeleteUserServlet',
			data:{
				"userId":this.getAttribute("userid"),
				},
			success:function(data,status,xhr){
				if(data==0)
					alert("删除失败");
				else{
					//$(this).parent().parent().hide();
					s.parent().parent().hide('explode');//
				}
			}
		})
	})
	
	//like模糊查询
	$("body").on("click","#sub",function(){
		
		userId=$("#userId").val();
		userName=$("#userName").val();
		huoqu();
		tijiao();
	});
	
	
	
	$("#anniu").on("click","#top",function(){
		if((i-1)<=0)
			return false;
		i-=1;
		select();
		tijiao();
		return false;
	});
	//下一页
	$("#anniu").on("click","#dowm",function(){
		if((i+1)>max)
			return false;
		i+=1;
		select();
		tijiao();
		return false;
	});
	
	//Go
	$("#anniu").on("click","#go",function(){
		if($("#yemian").val()>max||$("#yemian").val()<=0)
			return false;
		i=$("#yemian").val();
		select();
		tijiao();
		return false;
	});
	
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