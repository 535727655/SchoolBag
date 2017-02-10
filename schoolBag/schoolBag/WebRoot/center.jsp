<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ page language="java"  import="Entity.*,Dao.*,java.util.*"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/schoolBag/css/all.css" />
<script type="text/javascript" src="/schoolBag/js/jquery-3.0.0.js" ></script>
<script type="text/javascript" src="/schoolBag/js/jquery-ui.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务首页</title>
<script type="text/javascript">
	$(function(){
		$("#youbian").tabs();
	   });
</script>
<style type="text/css">
	.kuai5:hover{
		color:red;
	}
	.kuai5:click{
		color:red;
	}
</style>
</head>
	<body>
		<div id="project">
			<div id="head">
				<span id="left1">&nbsp;&nbsp;&nbsp;<img src="img/c.png" ><a href="/schoolBag/homepage.html">大校帮首页</a></span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span id="left1"><a href="/schoolBag/login.html" id="loginmsg"></a></span><span class="shu">|</span>
				<span id="right1"><a href="/schoolBag/regist.html"></a></span><span class="shu">|</span>
				<span id="left1"><a href="/schoolBag/Feedback.html">投诉建议</a></span><span class="shu">|</span>
				<span id="left1"><a href="#">企业联络我们</a></span><span class="shu">|</span>
				<span id="left1">关注校帮</span>
			</div>
			<div id="neck">
				<span class="kuai3"><img src="img/fff.png"><b>校袋帮</b></span>
				<span class="kuai2">大学生轻任务平台</span>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="kuai" href="/schoolBag/homepage.html">首页</a>
				<a class="kuai" href="/schoolBag/center.jsp">任务中心</a>
				<a class="kuai" href="/schoolBag/MyTask.html">我的任务</a>
				<a class="kuai" href="/schoolBag/H_jsp/index.html">二手交易</a>
			</div>
			<div id="context">
				<div id="zuobian">
						<div id="zuobian-1">
							<div class="context-1-1-1-1" style="float:left;margin-right:10px">
								<img id="touxiang" src="img1/c1.png">
							</div>
							<div class="context-1-1-1-2">
								<h3 style="font-family: '微软雅黑';margin: 0;color: #808080;padding-bottom: 5px;"> <a id="userId"></a></h3>
								<div class="context-1-1-1-2-1">
									<div class="context-1-1-1-2-1-2">
										<p style="color: #808080;font-size: 5px;font-family: '微软雅黑';margin: 0;">我的消息:<a id="myImfoSize" style="text-decoration:none;color:red" href="/schoolBag/Imformation.html"> </a></p>
										<p style="color: #808080;font-size: 5px;font-family: '微软雅黑';margin: 0;"><a href="/schoolBag/UserCenter.html">编辑资料</a></p>
									</div>
								</div>
							</div>
						</div>
						<table border="0" cellspacing="" cellpadding="">	
							<tr><td colspan="2" class="kuai41"><strong>任务分栏</strong></td></tr>
							<tr><td colspan="2" class="kuai4" name="n1"><img src="img/aa.png"> <a href="/schoolBag/TaskWeb?fenlei=0" id="quanbu">全部任务</a></td></tr>
							<tr><td colspan="2" class="kuai4" name="n2"><img src="img/bb.png">  <a href="/schoolBag/TaskWeb?fenlei=1" id="xianshang">调查收集</a></td></tr>
							<tr><td colspan="2" class="kuai4" name="n3"><img src="img/cc.png"> <a href="/schoolBag/TaskWeb?fenlei=2" id="xianxia"> 线下任务</a></td></tr>
							<tr><td colspan="2" class="kuai4" name="n4"><img src="img/dd.png">  <a href="/schoolBag/TaskWeb?fenlei=3" id="diaocha">线上任务</a></td></tr>
							<tr><td colspan="2" class="kuai4" name="n5"><img src="img/ee.png">  <a href="/schoolBag/TaskWeb?fenlei=4" id="shiwu">其他任务</a></td></tr>
						</table>
				</div>
				<div id="youbian">
					<div id="youbian-1">
						<div id="youbian-1-1">
							<ul>
							 <span class="kuai5"><b>状态：</b></span>
							  <li class="kuai5" class="kuai51"><a href="#tabs-1" style="color:#0000EE">待领取</a></li>
							   <li class="kuai5"  class="kuai51"><a href="#tabs-3"  style="color:#0000EE">处理中</a></li>
							  <li class="kuai5"  class="kuai51"><a href="#tabs-6"  style="color:#0000EE">待确认</a></li>
							  <li class="kuai5"  class="kuai51"><a href="#tabs-4"  style="color:#0000EE">处理完成</a></li>
							  <li class="kuai5"  class="kuai51"><a href="#tabs-5"  style="color:#0000EE">取消</a></li>
							</ul>
						</div>
						<!-- 全部 -->
						<div id="tabs-1">
						<c:if test="${frenAll==null}">
							<c:redirect url="/TaskWeb"/>
						</c:if>
						<c:forEach var="s1" items="${requestScope.frenAll }">						
						   <div class=  "youbian-1-2" id="alltask">
								<div class="youbian-1-2-1">
									<img src="${s1.taskImage}" width="400px" height="260px">
							
								</div>
								<div class="youbian-1-2-2">
										<div class="touxiang1"><img src="/schoolBag/img/d.png"></div>
										<div class="wenzi1"><b><a href="TaskId2?taskId=${s1.taskId}" class="mou">${s1.taskTitle}</a></b></div>
										<div class="duan1">任务时间:${s1.taskBeginTime}</div>
										
							
									<c:set var="s" value="${s1.taskContent}"  />
									
										<div class="duan3">按照要求:<a href="TaskId2?taskId=${s1.taskId}" class="gray">${fn:split(s,"$")[0]}</a></div>
										<div class="duan4">价格：<b style="color:red;font-size:20px">${s1.taskMoney }</b style="color:red">&nbsp;元</div>
										<div class="duan5"><span ><a href="TaskId2?taskId=${s1.taskId}">立即查看</a></span></div>
								</div>
						    </div>	
					    </c:forEach>
					  </div>
					  
					  
	
					  <!-- 处理中 -->
					  <div id="tabs-3">
					  		  	<c:if test="${frenInprocess==null}">
							<c:redirect url="/TaskWeb"/>
						</c:if>
						<c:forEach var="s3" items="${requestScope.frenInprocess}">						
						   <div class="youbian-1-2" id="intask">
								<div class="youbian-1-2-1">
									<img src="${s3.taskImage }" width="400px" height="260px">
							
								</div>
								<div class="youbian-1-2-2">
										<div class="touxiang1"><img id="ing" src="/schoolBag/img/clz2.jpg"></div>
										<div class="wenzi1"><b><a href="InTaskRec?TaskId2=${s3.taskId}" class="mou">${s3.taskTitle}</a></b></div>
										<div class="duan1">任务时间${s3.taskBeginTime}</div>
										
										<c:set var="ss" value="${s3.taskContent}"/>
											
										
										<div class="duan3">按照要求:<a href="InTaskRec?TaskId2=${s3.taskId}" class="gray">${fn:split("ss","$")[0]}</a></div>
										<div class="duan4">价格：<b style="color:red;font-size:20px">${s3.taskMoney }</b style="color:red">&nbsp;元</div>
										<div class="duan5"><span ><a href="InTaskRec?TaskId2=${s3.taskId}">立即查看</a></span></div>
								</div>
						    </div>	
					    </c:forEach>
					  </div>
					  
					  
					  <!-- 待确认 -->
					  <div id="tabs-6">
						<c:if test="${daiquerenprocess==null}">
							<c:redirect url="/TaskWeb"/>
						</c:if>
						<c:forEach var="s1" items="${requestScope.daiquerenprocess }">						
						   <div class=  "youbian-1-2" id="alltask">
								<div class="youbian-1-2-1">
									<img src="${s1.taskImage}" width="400px" height="260px">
							
								</div>
								<div class="youbian-1-2-2">
										<div class="touxiang1"><img src="/schoolBag/img/d.png"></div>
										<div class="wenzi1"><b><a href="TaskId2?taskId=${s1.taskId}" class="mou">${s1.taskTitle}</a></b></div>
										<div class="duan1">任务时间:${s1.taskBeginTime}</div>
										
							
									<c:set var="s" value="${s1.taskContent}"  />
									
										<div class="duan3">按照要求:<a href="TaskId2?taskId=${s1.taskId}" class="gray">${fn:split(s,"$")[0]}</a></div>
										<div class="duan4">价格：<b style="color:red;font-size:20px">${s1.taskMoney }</b style="color:red">&nbsp;元</div>
										<div class="duan5"><span ><a href="TaskId2?taskId=${s1.taskId}">立即查看</a></span></div>
								</div>
						    </div>	
					    </c:forEach>
					  </div>
					  
					   <!-- 已完成 -->
					   <div id="tabs-4">
					  		 <c:if test="${frenComplete==null}">
							<c:redirect url="/TaskWeb"/>
						</c:if>
						<c:forEach var="s4" items="${requestScope.frenComplete }">						
						   <div class="youbian-1-2"  id="wantask">
								<div class="youbian-1-2-1">
									<img src="${s4.taskImage }" width="400px" height="260px">
							
								</div>
								<div class="youbian-1-2-2">
										<div class="touxiang1"><img src="img/ywc.png"></div>
										<div class="wenzi1"><b><a href="YiqueRen?taskId=${s4.taskId}" class="mou">${s4.taskTitle}</a></b></div>
										<div class="duan1">任务时间:${s4.taskBeginTime}</div>
										
										<c:set var="sss" value="${s4.taskContent}"/>
										<div class="duan3">按照要求:<a href="YiqueRen?taskId=${s4.taskId}" class="gray">${fn:split("sss","$")[0]}</a></div>
										<div class="duan4">价格：<b style="color:red;font-size:20px">${s4.taskMoney }</b style="color:red">&nbsp;元</div>
										<div class="duan5"><span ><a href="YiqueRen?taskId=${s4.taskId}">立即查看</a></span></div>
								</div>
						    </div>	
					      </c:forEach>
					  </div>
					  <!-- 已取消 -->
					  <div id="tabs-5">
					  		  	<c:if test="${frenCanceled==null}">
							<c:redirect url="/TaskWeb"/>
						</c:if>
						<c:forEach var="s5" items="${requestScope.frenCanceled }">						
						   <div class="youbian-1-2" id="quxiaotask">
								<div class="youbian-1-2-1">
									<img src="${s5.taskImage }" width="400px" height="260px">
							
								</div>
								<div class="youbian-1-2-2">
										<div class="touxiang1"><img src="img/fq.png"></div>
										<div class="wenzi1"><b><a href="TaskID?taskId=${s5.taskId}" class="mou">${s5.taskTitle}</a></b></div>
										<div class="duan1">任务时间:${s5.taskBeginTime}</div>
										<!--  <div class="duan2">参与条件:</div>-->
										<c:set var= "ssss" value="${s5.taskContent}"/>
										<div class="duan3">按照要求:<a href="TaskID?taskId=${s5.taskId}" class="gray">${fn:split("ssss","$")[0]}</a></div>
										<div class="duan4">价格：<b style="color:red;font-size:20px">${s5.taskMoney }</b style="color:red">&nbsp;元</div>
										<div class="duan5"><span ><a href="TaskID?taskId=${s5.taskId}">立即查看</a></span></div>
								</div>
						    </div>	
					  </c:forEach>
					 </div>
					</div>
				</div>
				<div style="clear: both;display: block"> </div>
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
			
	</body>
			<script src="/schoolBag/js/selImfoSize.js"></script>
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
					
					$("#quanbu").click(function(){
						//全部  不筛选
					});
					
					$("#xianshang").click(function(){
						//线上
					});
					
					$("#xianxia").click(function(){
						//线下
					});
					
					$("#diaocha").click(function(){
						//调查
					});
					
					$("#shiwu").click(function(){
						//实物
					});
				})
			</script>
</html>