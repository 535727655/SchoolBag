<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/Studentss.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script type="text/javascript"src="/schoolBag/js/jquery-3.0.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参与任务页面</title>
</head>
		<script type="text/javascript">
			//下面用于图片上传预览功能
			function setImagePreview(doc,preview) {
				var docObj = document.getElementById(doc);

				var imgObjPreview = document.getElementById(preview);
				if(docObj.files && docObj.files[0]) {
					//火狐下，直接设img属性
					imgObjPreview.style.display = 'block';
					imgObjPreview.style.width = '150px';
					imgObjPreview.style.height = '180px';
					//imgObjPreview.src = docObj.files[0].getAsDataURL();

					//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
					imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
				} else {
					//IE下，使用滤镜
					docObj.select();
					var imgSrc = document.selection.createRange().text;
					var localImagId = document.getElementById("localImag");
					//必须设置初始大小
					localImagId.style.width = "150px";
					localImagId.style.height = "180px";
					//图片异常的捕捉，防止用户修改后缀来伪造图片
					try {
						localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
						localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
					} catch(e) {
						alert("您上传的图片格式不正确，请重新选择!");
						return false;
					}
					imgObjPreview.style.display = 'none';
					document.selection.empty();
				}
				return true;
			}
		</script>
<style>
	body{
			background-color: #f1f1f1;
			margin: 0;
			padding: 0;
			min-width: 1215px;
		}
		
		#head{
			height: 30px;
			width: 100%;
			
		}
		#left1{
			font-size: 12px;
			color: #6f6f6f;
			font-family: "宋体";
			line-height: 15px;
		}
		#left1 a:link{
			color: #6F6F6F;
			text-decoration: none;
			
		}
		#left1 a:visited{
			color: #6f6f6f;
			text-decoration: underline;
			
		}
		#left1 a:hover{
			color: red;
			text-decoration: underline;
			
		}
		#right1 a:link{
			color: #c94c49;
			text-decoration: underline;
			
		}
		#right1 a:visited{
			color: #c94c49;
			text-decoration: underline;
			
		}
		.shu{
			color: #dddddd;
		}
		#right1{
			
			
			font-size: 10px;
			color: #6f6f6f;
			font-family: "宋体";
			line-height: 25px;
		}
		
		
		
		
		#neck{
			height:55px;
			background-color: white;
			width: 100%;
			padding: 30px 30px 0px 30px;
			
		}
		.kuai{
			vertical-align: middle;
			width:90px ;
			height: 40px;
			background-color: #059cd4;
			font-size: 20px;
			padding: 10px;
			
		}
		.kuai2{
			vertical-align: middle;
			width:90px ;
			height: 40px;
			color:#808080 ;
			font-family: "楷体";
			font-size: 21px;
		}
		.kuai3{
			vertical-align: middle;
			width:90px ;
			height: 40px;
			color:#059cd4 ;
			font-family: "黑体";
			font-size: 40px;
			
		}
		.context{
			width: 1215px;
			background-color:#f1f1f1;
			margin: 10px auto;
			
			
		}
		.context-1{
			padding: 20px 0;
			width:1215px;
			background-color: #FFFFFF;
			height:2000px;
			
		}
		.context-1-1{
				
			    padding-left: 17px;
    			font-size: 14px;
    			color: #666;
    			margin-bottom: 14px;
			
		}
		.context-1-2{
				height: 260px;
				margin:0 auto 34px ;
		}
		.context-1-2-1{
				width: 40%;
				height: 260px;
				float: left;
				padding-left: 80px;
				
				
		}
		.context-1-2-2{
				width: 50%;
				float:left;
		}
		.context-1-2-2-1{
			width: 598px;
			height: 208px;
			
		}
		.p1{
			font-family: "微软雅黑";
			color: black;
			font-size: 15px;
			
		}
		.p2{
			width: 100px;
			height: 30px;
			background-color: #F03746;
			color: white;
			padding: 10px;
			margin-right: 20px;
		}
		.p2 a{
				text-decoration:none;
				color: white;
		}
		.context-1-5{
				width: 1215px;
				height: 40px;
				display: none;
		}
		.context-1-5-1{
			margin: 0 80px;
			height: 25px;
			background: url(img/o.png)left center ;
			
			text-align: center;
			
		}
		.context-1-5-1-1{
			
			height: 100%;
			background-color: #FFFFFF;
			padding: 0 28px;
			font-family: "微软雅黑";
			font-size:22px;
			
		}
		.context-1-6{
				width: 1215px;
				min-height: 60px;
				display: none;
		}
		.context-1-6-1{
			height: 200px;
			margin:0 80px ;
			padding: 10px 20px 10px 20px;
			color: #666666;
			font-family: "微软雅黑";
			font-size: 15px;
		}
		.context-1-6-1-1{
			
			margin-right: 20px;
			width: 100px;
			height: 100px;
			background: url(img/q.png) no-repeat center;
			background-size: 40px auto;
			border: 5px solid #cccccc;
			border-radius: 5px;
			float: left;
			
			
		}
		.context-1-6-1-2{
			
			width: 100px;
			height: 100px;
			background: url(img/r.png) no-repeat center;
			background-size: 40px auto;
			border: 5px solid #cccccc;
			border-radius: 5px;
			float: left;
		}
		.context-1-6-1-3{
			
			border-radius: 3px;
			background-color:#F03746 ;
			color: white;
			font-size: 20px;
			padding:5px;
			position: relative;
			
		}
		
		
		.context-1-3{
				width: 1215px;
				height: 25px;
		}
		.context-1-3-1{
			margin: 0 80px;
			height: 25px;
			background: url(img/o.png)left center ;
			
			text-align: center;
			
		}
		.context-1-3-1-1{
			
			height: 100%;
			background-color: #FFFFFF;
			padding: 0 28px;
			font-family: "微软雅黑";
			font-size:22px;
			
		}
		.context-1-4{
				width: 1215px;
				min-height: 60px;
		}
		.context-1-4-1{
			min-height: 60px;
			margin:0 80px ;
			padding: 10px 20px 10px 20px;
			color: #666666;
			font-family: "微软雅黑";
			font-size: 15px;
		}
		
		
		
		
		
		#end{
			border: 1px solid darkgray;
			border-bottom-color:#f1f1f1 ;
			border-left-color:#f1f1f1 ;
			border-right-color:#f1f1f1 ;
			width: 1215px;
			
			margin: 0 auto;
			
			
		}
		.end-1{
			padding: 30px 0;
		}
		.end-1-1{
			text-align: center;
		}
		.end-1-2{
			margin-top: 10px;
			font-size: 5px;
			text-align: center;
			font-family: "微软雅黑";
		}
		.end-1-3{
			margin-top: 10px;
			font-size: 5px;
			text-align: center;
			font-family: "微软雅黑";
		}
		
			#fn3 img{
			width:60%;
			height:60%;
		}
	 .fileInputContainer{
      
       
        position:relative;
       
    }
    .fileInput{
       
        overflow: hidden;
        font-size: 300px;
        position:absolute;
        right:0;
        top:0;
        opacity: 0;
        filter:alpha(opacity=0);
        cursor:pointer;
    }
    #tupzs{
    	border:1px solid red;
    	width:300px;
    	height:300px;
    	margin-left:300px;
    	margin-top:-200px;
    }
    .kuai{
    	text-decoration:none;
    }
	</style>
	<body>
		<div id="head">
				<span id="left1">&nbsp;&nbsp;&nbsp;<img src="img/c.png" ><a href="">大校帮首页</a></span>
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
			<div class="context">
				<div class="context-1">
						<div class="context-1-1">
						
					<c:if test="${bl2==null}">
						<c:redirect url="/InTaskRec"/>
					</c:if>
					<c:forEach var="s" items="${requestScope.bl2}">
						
					
							<a href="">任务中心></a>  <b style="font-family: '微软雅黑';">${s.taskTitle}</b>
       					</div>
       					<div class="context-1-2">
       						<div class="context-1-2-1">
       							<img src="${s.taskImage }" width="400px" height="260px">
       						</div>
       						<div class="context-1-2-2">
       							<h1><b>${s.taskTitle}</b></h1>
       							<div class="context-1-2-2-1">
       								<p class="p1"><b>类型:${s.taskType}</b></p>
       								<p class="p1"><b>任务时间:${s.taskBeginTime }</b></p>
       								<p class="p1"><b>参与条件:不限</b></p>
       								<p class="p1" style="color: red;font-size:15px">${s.taskMoney }元</p>
       								<p ><span class="p2" id="tijiaorenwu"><b>提交任务</b></span ><span class="p2"><b><a href="Abolishweb?TaskId=${s.taskId}">放弃任务</a></b></span></p>
       							</div>    
       						</div>
       					</div>
       					
       					<div class="context-1-5">
       						<div class="context-1-5-1">
       							<span class="context-1-5-1-1">提交信息</span>
       						</div>
       					</div>
       					<form id="ImageTijiao" enctype="multipart/form-data" action="UploadTijiao" method="post">
       					<input type="hidden" value="${s.taskId}" name="TaskId">
       					   <div class="context-1-6">
       						   <div class="context-1-6-1">
		       						<div class="fileInputContainer">
		       							<p class="context-1-6-1-1" name="addImg"></p>
		       							<div id="localImag"></div>
		       							<div id="s"></div>
		       						</div>
		       						
	       							<div style="clear: both;"></div>
	       							<font class="context-1-6-1-3" style="margin-top:50px;">确认提交</font>
       						  </div>
       					</form>
       					
       					</div>
       					<div style="clear: both;display: block"> </div>
       					<div class="context-1-3">
       						<div class="context-1-3-1">
       							<span class="context-1-3-1-1">任务简介</span>
       					   
       						</div>
       						<c:set var="s" value="${s.taskContent}"  />
       							<div id="fn">${fn:split(s,"$")[0]}</div>
       					</div>
       					<div class="context-1-4">
       						<div class="context-1-4-1">
       							
       						</div>
       						
       						
       					</div>
       					
       					<div class="context-1-3">
       						<div class="context-1-3-1">
       							<span class="context-1-3-1-1">任务步骤</span>
       							
       						
       						</div>
       							<div id="fn2">${fn:split(s,"$")[1]}</div>
       					</div>
       					<div class="context-1-4">
       						<div class="context-1-4-1">
       							
       						</div>
       					</div>
       					
       					<div class="context-1-3">
       						<div class="context-1-3-1">
       							<span class="context-1-3-1-1">任务详情</span>
       						
       						 
       						</div>
       							<div id="fn3">${fn:split(s,"$")[2]}</div>
       					</div>
       					<div class="context-1-4">
       						<div class="context-1-4-1">
       							
       						</div>
       					</div>
       					
				</div>
			</div>
			</c:forEach>
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
						
						
           				 校袋帮  轻松任务 真交流 真友谊  | 京 ICP 备 15040963 号-2 ©Copyright 2015  呵呵科技有限公司  版权所有
        
						
					</div>
				</div>
			</div>
			<script>
				$(function(){
					$("#tijiaorenwu").click(function(){
						$(".context-1-5").toggle();
						$(".context-1-6").toggle();
					});
				});
	
			</script>
				<script>
			$(function() {
				var s="s";
				var count=1;
				$("p[name=addImg]").click(function() {
					count++;
					var t=s+""+count;
					count++;
					var b=s+""+count;
					$("#s").append("<input name='img' type='file' style='display: none;'  id="+t+" onchange=\"javascript:setImagePreview(this.id,'"+b+"');\"/>");
					$("#localImag").append("<img id="+b+"  style='display: none; width: 150px; height: 180px;float:left' />");
					$("#"+t+"").click();
				});
				
			})
		</script>
		<script>
			$(function(){
				$(".context-1-6-1-3").click(function(){
					$("#ImageTijiao")[0].submit();
				});
			});
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
	</body>
</html>
