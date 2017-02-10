<%@page import="java.sql.Statement"%>

<%@ page language="java" import="java.util.*,java.sql.*,java.lang.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="selectall" scope="page" class="H_dao.UserDao"></jsp:useBean>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘</title>
<link rel="stylesheet" href="/schoolBag/css/ee.css" />
<link rel="stylesheet" href="/schoolBag/css/aa.css" />
</head>
<body>

	<div id="first">
		<div id="first-one">
			<img src="/schoolBag/img/1.png" />
		</div>
		<div id="first-two">
			<div style="color: red;font-size: 20px;float: left;">校帮</div>
			<span id="first-three">-更专业的二手交易平台</span> <b
				style="font-size: 15px;color: #DBDBDB;">二手全新升级，新品牌，新服务 
		</div>
		<div id="first-forth" />
		<img src="/schoolBag/img/2.png" />
	</div>
	<div id="first-fifth">
		<input type="text" placeholder="请输入类别名称或关键字" />
	</div>
	<div id="first-sixth">
		<input type="button" name="name" id="name" value="搜索" /></span>
	</div>
	<div id="first-seventh">
		<a href="first.html"
			style="color: #FFFAE8;padding-left: 10px;padding-top: 10px;padding-buttom: 10px;float: left;text-decoration: none;">免费发布信息</a>
	</div>

	<div id="second-first">
		<ol id="tttt">
			<li id="test1"><a href="index.html">首页</a></li>
			<li><a href="new_file.html">淘九块</a></li>
			<li><a href="gwc.jsp">跳蚤市场</a></li>
			<li><a href="index.jsp">兼职招聘</a></li>
		</ol>
	</div>
	</div>
	<table border="0" width="1200" height="205" style="margin-left: 30px">
		<tr>
			<td>类型:</td>
			<td><input type="radio" name="qz" value="全职" />全职</td>
			<td><input type="radio" name="qz" value="实习" />实习</td>
			<td><input type="radio" name="qz" value="兼职" />兼职</td>

		</tr>
		<tr>
			<td>学历:</td>
			<td>不限</td>
			<td class="daxue">初中</td>
			<td class="gongcheng">中专|中技</td>
			<td class="daxue">高中</td>
			<td class="gongcheng">大专</td>
			<td class="daxue">本科</td>
		</tr>
		<tr>
			<td>经验:</td>
			<td>不限</td>
			<td class="daxue">无经验</td>
			<td class="gongcheng">1-2年</td>
			<td class="gongcheng">3-5年</td>
		</tr>
		<tr>
			<td>薪酬:</td>
			<td>不限</td>
			<td>1000以下</td>
			<td class="daxue">1000-2999</td>
			<td class="gongcheng">3000-5999</td>
			<td class="gongcheng">6000</td>
		</tr>
		<tr>
			<td>来源:</td>
			<td>不限</td>
		</tr>
	</table>
	<div id="toufa">
		<div id="toufa-first">兼职信息</div>
		<div class="toufa-two">公司名称</div>
		<div class="toufa-two">地点</div>
		<div class="toufa-two">发布日期</div>
	</div>


	<%!int CountPage = 0;
	int CurrPage = 1;
	int PageSize = 5;
	int CountRow = 0;%>
	<%
		String StrPage = request.getParameter("Page");
		if (StrPage == null) { //判断当页面的值为空时
			CurrPage = 1; //赋值为1
		} else {
			CurrPage = Integer.parseInt(StrPage); //如果不为空则获取该值
		}
		String SQL = "Select * From zhaoping"; //定义查询语句
		ResultSet Rs = selectall.selectStatic(SQL); //执行查询语句
		Rs.last(); //获取查询结果集
		int i = 0; //定义数字变量
		CountRow = Rs.getRow(); //获取查询结果集的行数
		CountPage = (CountRow / PageSize); //计算将数据分成几页
		if (CountRow % PageSize > 0) //判断如果页数大于0
			CountPage++; //则增加该值
		Integer n = (CurrPage - 1) * 5 + 1; //定义变量上一页的结束值
		SQL = "select top 5 * from zhaoping where zid>=" + "("
				+ "Select Max(zid) From (Select top " + n.toString()
				+ " * From zhaoping) as Class" + ")";
		Rs = selectall.selectStatic(SQL); //执行查询语句
		while (Rs.next()) { //循环输出查询结果
	%>

	<table border="1"
		style="clear: both;margin-left: 30px;width:1135px;height:70px;">
		<tr>
			<td class="bcca"><%=Rs.getString("gname")%></td>


			<td class="bccc"><%=Rs.getString("mingCheng")%></td>


			<td class="bccc"><%=Rs.getString("place")%></td>


			<td class="bccc"><%=Rs.getString("publishTime")%></td>
		</tr>
	</table>
	<%
		}
		selectall.closeConnection(); //关闭数据库
	%>
	<table style="margin-top:20px;">
		<tr id="sel">
			<td width="251">[<%=CurrPage%>/<%=CountPage%>] 每页5条 共<%=CountRow%>条记录<%=(CurrPage - 1) * 5 + 1%>
			</td>
			<td width="260"><div align="right">
					<%
						if (CurrPage > 1) {
					%>
					<a href="index.jsp?Page=<%=CurrPage - 1%>">上一页</a>
					<%
						}
					%>
					<%
						if (CurrPage < CountPage) {
					%>
					<a href="index.jsp?Page=<%=CurrPage + 1%>">下一页</a>
					<%
						}
					%>
					<a href="index.jsp?Page=<%=CountPage%>">最后一页</a>
				</div></td>
		</tr>
	</table>
</body>
</html>