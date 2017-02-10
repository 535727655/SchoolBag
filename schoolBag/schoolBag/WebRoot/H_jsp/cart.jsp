<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	//装载MySQL5.5的JDBC驱动
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//建立数据库连接
String url="jdbc:sqlserver://localhost:1433;databaseName=xiaobang";
Connection conn=DriverManager.getConnection( url,"sa","123123");
//建立一个Statement对象，用于执行SQL语句
Statement stat=conn.createStatement();
//执行查询并得到查询结果
String sql="select * from cart";
ResultSet rs=stat.executeQuery(sql);
%>
</head>
<body>
<h2>我的购物车</h2>
<hr>
<table  border="1" width="600" >
	<tr bgcolor="#dddddd">
			<td align="center" width="80">商品名称</td>
			<td align="center">商品单价</td>
			<td align="center" width="100">购买数量</td>
			<td align="center" width="100">金额</td>
			<td align="center" width="100">编辑</td>
		</tr>
		<%
			String id,name,price,num,count;
			//将查询结果集中的记录输出到页面上
			while(rs.next()){
				//从当前记录中读取各字段的值
				id=rs.getString("ID").trim();
				name=rs.getString("SP_NAME").trim();
				price=rs.getString("SP_PRICE").trim();
				num=rs.getString("BUY_NUM").trim();
				count=rs.getString("COUNT").trim();
				out.println("<tr>");
				out.println("<td>"+name+"</td>");
				out.println("<td>"+price+"</td>");
				out.println("<td><input type=text value="+num+" onChange=\"updateNum('"+id+"',this.value,'"+price+"')\"></td>");
				out.println("<td>"+count+"</td>");
				out.println("<td><a href='buy.jsp?op=del&id="+id+"'>退回商品架</a></td>");
				out.println("</tr>");
				
			}
		%>
		</table>
		<br>
		<a href="gwc.jsp">继续购物</a>
		<a href="buy.jsp?op=clear">清空购物车</a>
</body>
<script>
	function updateNum(id,num,price){
		var url="buy.jsp?op=update&id="+id+"&num="+num+"&price="+price;
		window.location=url;	
	}
</script>
</html>