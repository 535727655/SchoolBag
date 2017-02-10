<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线购物</title>
</head>
<%
	//装载MySQL5.5的JDBC驱动
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//建立数据库连接
String url="jdbc:sqlserver://localhost:1433;databaseName=xiaobang";
Connection conn=DriverManager.getConnection( url,"sa","123123");
//建立一个Statement对象，用于执行SQL语句
Statement stat=conn.createStatement();
//执行查询并得到查询结果
String sql="select * from show";
ResultSet rs=stat.executeQuery(sql);
%>
<body>
<a href="index.html" style="font-size:25px">回首页</a>
	<h2>在线购物</h2>
	<hr>
	<table border="1" width="600">
		<tr bgcolor="#dddddd">
			<td align="center" width="80">商品缩图</td>
			<td align="center">商品摘要</td>
			<td align="center" width="100">在线购买</td>
		</tr>
		<%
			String bm,name,price,info,im;
		//将查询结果集中的记录输出到页面上
		while(rs.next()){
			//从当前记录中读取各字段的值
			im=rs.getString("SP_PIC").trim();
			bm=rs.getString("SP_NO").trim();
			name=rs.getString("SP_NAME").trim();
			price=rs.getString("SP_PRICE").trim();
			info=rs.getString("SP_INFO").trim();
			out.println("<tr>");
			
				out.println("<td><img src='/schoolBag/im/"+im+"' border=0 height=60 width=60></td>");
				
			
			
			out.println("<td>");
			out.println("商品编号:"+bm+"<br>");
			out.println("商品名称:"+name+"<br>");
			out.println("商品价格:"+price+"元<br>");
			out.println("商品简介"+info+"<br>");
			out.println("</td>");
			out.println("<td><a href='buy.jsp?op=add&bm="+bm+"'>放入购物车</a></td>");
			out.println("</tr>");
		}
		%>
	</table>
	<br>
	<a href="cart.jsp">查看购物车</a>
	<a href="buy.jsp?op=clear">清空购物车</a>
</body>
</html>