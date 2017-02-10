<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ page language="java"  import="Entity.*,Dao.*,java.util.*"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<script type="text/javascript" src="js/jquery-3.0.0.js" ></script>
<link rel="stylesheet" href="/schoolBag/css/all.css" />
<link rel="stylesheet" href="/schoolBag/css/taskissue.css" />
<script type="text/javascript" src="/schoolBag/js/jquery-3.0.0.js" ></script>
<script type="text/javascript" src="/schoolBag/laydate/laydate.js" ></script>
<script src="/schoolBag/kindeditor-4.1.1/kindeditor-min.js"></script>
<link href="/schoolBag/kindeditor-4.1.1/themes/default/default.css"/>
<link href="/schoolBag/laydate/skins/default/laydate.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>发布任务的表单</title>

</head>
	<body>
		<div id="project">
			<div id="head">
				<span id="left1">&nbsp;&nbsp;&nbsp;<img src="img/c.png" ><a href="/schoolBag/homepage.html">大校帮首页</a></span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span id="left1"><a href="/schoolBag/login.html" id="loginmsg">你好，请登录</a></span><span class="shu">|</span>
				<span id="right1"><a href="/schoolBag/regist.html">免费注册</a></span><span class="shu">|</span>
				<span id="left1"><a href="/schoolBag/Feedback.html">投诉建议</a></span><span class="shu">|</span>
				<span id="left1"><a href="">企业联络我们</a></span><span class="shu">|</span>
				<span id="left1">关注校帮</span>
			</div>
			<div id="neck">
				<span class="kuai3"><img src="img/fff.png"><b>校袋帮</b></span>
				<span class="kuai2">大学生轻任务平台</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/schoolBag/homepage.html" class="kuai">首页</a>
				<a href="/schoolBag/center.jsp" class="kuai">任务中心</a>
				<a href="/schoolBag/MyTask.html" class="kuai">我的任务</a>
				<a href="/schoolBag/H_jsp/index.html" class="kuai">二手交易</a>
			</div>
			<div id="context">
				<div id="zuobian">
						<div id="zuobian-1">
							<table border="0" cellspacing="" cellpadding="">
								<tr>
								   <td ><img src="img1/c1.png" /></td>
								     <td>
									   <p>当前用户:${sessionScope.user.userId }</p>
									   <p>积分：${sessionScope.user.userInt }<a href=""></a></p>
								    </td>
							     </tr>
							  <tr><td colspan="2">我的收入明细</td></tr>
							  <tr><td colspan="2" class="kuai412"><hr style="border:1px dotted gray" /></td></tr>
							</table>
						</div>
						<table border="0" cellspacing="" cellpadding="">	
							<tr><td colspan="2" class="kuai41"><strong>任务分栏</strong></td></tr>
							<tr><td colspan="2" class="kuai4" name="n1"><img src="img/aa.png"> 全部任务</td></tr>
							<tr><td colspan="2" class="kuai4" name="n2"><img src="img/bb.png"> 线上任务</td></tr>
							<tr><td colspan="2" class="kuai4" name="n3"><img src="img/cc.png"> 线下任务</td></tr>
							<tr><td colspan="2" class="kuai4" name="n4"><img src="img/dd.png"> 调查收集</td></tr>
							<tr><td colspan="2" class="kuai4" name="n5"><img src="img/ee.png"> 实物奖励</td></tr>
						</table>
				</div>
				<div id="youbian">
					<div id="youbian-1">
						<div id="youbian-1-1">
							<span class="kuai5"><b>状态：</b></span>
							<span class="kuai5">发布</span>
							
						</div>
					<!-- 这里是填写任务表单 -->
					 <!--
          	作者：896240130@qq.com
          	时间：2016-08-05
          	描述：发布人：用会话传参得到
          		    接收人：单接收人查看并且点击接单就添加
          		   任务发布时间：自动获取当前时间
          -->
		<div id="frame">
		
		
		
		
		<form action="/schoolBag/taskAdd" method="post" id="frm" >
			<span>&nbsp;&nbsp;任务标题:<input type="text" name="TaskTitle" id="TaskTitle"/><br/>
			   
     
      	    <span>&nbsp;&nbsp;任务简介:</span><input type="text" name="rexq" id="rwjj1"/><br/>
			
			<span>&nbsp;&nbsp;任务步骤:</span><input type="text" name="rebz" id="rebz1"/><br/>
			
			<span>任务开始时间：</span><input type="text" name="TaskBeginTime" id="TaskBeginTime" placeholder="2016-08-08 06:06:06"/><br/>
			<span>任务结束时间：</span><input type="text" name="TaskEndTime" id="TaskEndTime" placeholder="2016-08-08 08:08:08"/><br/>
			<!--  <span>任务完成时间：</span><input type="text" name="TaskFinishTime" id="TaskFinishTime"/><br/>-->
			<span>任务奖励(元):</span> <input type="text" name="TaskMoney" id="TaskMoney"/><br/>
			<span>&nbsp;&nbsp;任务类型:</span><select name="TaskType" id="TaskType">
				         <option value="调查收集">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;调查收集</option>
				         <option value="线下执行">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;线下执行</option>
				         <option value="线上传播">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;线上传播</option>
				         <option value="其他">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;其他</option>
		    	     </select>
		         <div class="TaskContent"><span id="rwu">&nbsp;&nbsp;任务详情:</span><textArea name="TaskContent"cols="90"rows="10" id="TaskContent"></textArea></div><br/>
				<input id="form1-sub" type="submit" value="提交" style="display:none" />
			</form>
			
			
			
			
			<form id="fileupload" name='formFile' method="post" action="/schoolBag/TouXiangUploadServlet" target='frameFile'  enctype="multipart/form-data">
				 	<div  id="tupe"><span>&nbsp;&nbsp;选择图片:</span><input type="file" name="TaskImage"id="TaskImage"></div><br/>
			</form>
			<input type="button" value="确定" id="submit"/>
			
     
		</div>
			</div>
				</div>
				<div style="clear: both;display: block"></div>
	         </div>
			 <div id="end">
				<div class="end-1">
					<div class="end-1-1">
						<img src="img/x.png">
						<img src="img/y.png">
						<img src="img/z.png">
					</div>
					<div class="end-1-2">
						<a href="">关于我们</a>
						<a href="">首页</a>
						<a href="">企业注册</a>
						|客服热线  13621487901 | 客服QQ 505294505 | 客服邮箱 505294505@qq.com| 合作邮箱 505294505@qq.com
					</div>
					<div class="end-1-3">
           				 校袋帮  轻松任务 真交流 真友谊  | 京 ICP 备 15040963 号-2 ?Copyright 2015  呵呵科技有限公司  版权所有
					</div>
				</div>
			</div>
			</div>
			<iframe id='frameFile' name='frameFile' style='display: none;'></iframe>
			
	</body>
		<script type="text/javascript">
		$("#submit1").on('click',function(){
			 editor.sync();
			ss=$("#rexq").val()+"%%"+$("#rebz").val()+"&&"+$("#TaskContent").val();
			alert(ss);
		});
		//任务标题
		$("#TaskTitle").focus(function(){
			$("#TaskTitle").css("border-color","darkgreen");
		});
			$("#TaskTitle").blur(function(){
				if($("#TaskTitle").val()==""){
					$("#TaskTitle").css("border-color","red");
					$("#bandny").html("不能为空");	
				}else{
					$("#bandny").html("通过");
				}
			});
			
			//任务简介
			$("#rwjj1").focus(function(){
			$("#rwjj1").css("border-color","darkgreen");
		});
			$("#rwjj1").blur(function(){
				if($("#rwjj1").val()==""){
					$("#rwjj1").css("border-color","red");
					$("#bandny").html("不能为空");	
				}else{
					$("#bandny").html("通过");
				}
			});
				//任务步骤
			$("#rebz1").focus(function(){
			$("#rebz1").css("border-color","darkgreen");
		});
			$("#rebz1").blur(function(){
				if($("#rebz1").val()==""){
					$("#rebz1").css("border-color","red");
					$("#bandny").html("不能为空");	
				}else{
					$("#bandny").html("通过");
				}
			});
		//任务简介
			$("#rexq").focus(function(){
				$("#rexq").css("border-color","darkgreen");
			});
		//任务步骤
		$("#rebz").focus(function(){
				$("#rebz").css("border-color","darkgreen");
			});
			
		//任务开始时间
			$("#TaskBeginTime").focus(function(){
			$("#TaskBeginTime").css("border-color","darkgreen");
		});
			$("#TaskBeginTime").blur(function(){
				if($("#TaskBeginTime").val()==""){
					$("#TaskBeginTime").css("border-color","darkgreen");
					$("#panduan").html("不能为空");	
				}else{
					$("#panduan").html("通过");
				}
			});
			
		//任务结束时间
			$("#TaskEndTime").focus(function(){
			$("#TaskEndTime").css("border-color","darkgreen");
		});
			$("#TaskEndTime").blur(function(){
				if($("#TaskEndTime").val()==""){
					$("#TaskEndTime").css("border-color","darkgreen");
					$("#neyong").html("不能为空");	
				}else{
					$("#neyong").html("通过");
				}
			});
		//任务奖励(元)
		$("#TaskMoney").focus(function(){
			$("#TaskMoney").css("border-color","darkgreen");
		});
			$("#TaskMoney").blur(function(){
				if($("#TaskMoney").val()==""){
					$("#TaskMoney").css("border-color","red");
					$("#reminb").html("不能为空");	
				}else{
					$("#reminb").html("通过");
				}
			});
		
		</script>
			<script type="text/javascript">
laydate({
    elem: '#TaskBeginTime',//需显示日期的元素选择器
    event: 'click', //触发事件
    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
    istime: true, //是否开启时间选择
    isclear: true, //是否显示清空
    istoday: true, //是否显示今天
    issure: true, //是否显示确认
    festival: true //是否显示节日
    }
   )
   laydate({
    elem: '#TaskEndTime',//需显示日期的元素选择器
    event: 'click', //触发事件
    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
    istime: true, //是否开启时间选择
    isclear: true, //是否显示清空
    istoday: true, //是否显示今天
    issure: true, //是否显示确认
    festival: true //是否显示节日
    }
   )
</script>
<script>
KindEditor.ready(function(k){
	  window.editor=k.create('#TaskContent',{
		  	width:'500px',
			height:'400px',
			cssPath:'/schoolBag/kindeditor-4.1.1/plugins/code/prettify.css',
			uploadJson:'/schoolBag/fileupload',
			allowImageUpload:true
	   });
});
</script>
<script>
	$(function(){
		
		$("#submit").on("click",function(){
			 editor.sync();
			  $("#form1-sub")[0].click();
		})
		$("#TaskImage").on("change",function(){
			 $("#fileupload").submit();
		});
	})
</script>
			<script>
				$(function(){
					$.ajax({
						type:'post',
						url:'/schoolBag/isLoginServlet',
						success:function(data,status,xhr){
							if(data!=0){
								$("#loginmsg").html("欢迎回来:"+data);	
								$("#userId").text(data);
								$("#loginmsg").attr("href","#");
								$("#right1").html("<a href='#' id='logout'>注销</a>");
							}else{
								$("#loginmsg").html("登录");
								$("#loginmsg").attr("href","/schoolBag/login.html");
								$("#right1").html("<a href='/schoolBag/regist.html'>免费注册</a>");
							}
						}
					})
					$("#right1").on("click","#logout",function(){
						$.ajax({
							type:'post',
							url:'/schoolBag/LogoutServlet',
							success:function(data,status,xhr){
								$("#loginmsg").html("登录");
								$("#loginmsg").attr("href","/schoolBag/login.html");
								$("#right1").html("<a href='/schoolBag/regist.html'>免费注册</a>");
							}
						});
						return false;
					});
				})
			</script>
</html>