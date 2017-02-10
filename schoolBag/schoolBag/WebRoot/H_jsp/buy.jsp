<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
	//装载MySQL5.5的JDBC驱动
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//建立数据库连接
String url="jdbc:sqlserver://localhost:1433;databaseName=xiaobang";
Connection conn=DriverManager.getConnection( url,"sa","123123");
//建立一个Statement对象，用于执行SQL语句
PreparedStatement pstat=null;
//执行查询并得到查询结果
String sql=null;
ResultSet rs=null;
String op=request.getParameter("op");
//将商品放入购物车
if(op.equals("add")){
	//从商品库中取出所选购商品的数据
	String bm=request.getParameter("bm");
	String name=null,price=null;
	sql="select * from show where SP_NO=?";
	pstat=conn.prepareStatement(sql);
	pstat.setString(1,bm);
	rs=pstat.executeQuery();
	if(rs.next()){
		name=rs.getString("SP_NAME").trim();
		price=rs.getString("SP_PRICE").trim();
	}
	rs.close();
	pstat.close();
	//将所选购商品加入到购物车中
	sql="insert into cart(SP_NAME,SP_PRICE,BUY_NUM,COUNT) values(?,?,?,?)";
	pstat=conn.prepareStatement(sql);
	pstat.setString(1,name);
	pstat.setString(2,price);
	pstat.setInt(3,1);
	pstat.setString(4,price);
	pstat.executeUpdate();
	pstat.close();
	//关闭数据库连接
	conn.close();
	//重定向到购物车页面
	response.sendRedirect("cart.jsp");
}
//更改商品的数量
if(op.equals("update")){
	int id=Integer.parseInt(request.getParameter("id"));
	int num=Integer.parseInt(request.getParameter("num"));
	double price=Double.parseDouble(request.getParameter("price"));
	sql="update cart set BUY_NUM=?,COUNT=? where ID=?";
	pstat=conn.prepareStatement(sql);
	pstat.setInt(1,num);
	pstat.setString(2,new Double(price*num).toString());
	pstat.setInt(3, id);
	pstat.executeUpdate();
	pstat.close();
	//关闭数据库连接
	conn.close();
	//重定向到购物车页面
	response.sendRedirect("cart.jsp");
}
//将商品退回到商品架(将商品从购物车中删除)
if(op.equals("del")){
	int id=Integer.parseInt(request.getParameter("id"));
	sql="delete from cart where ID=?";
	pstat=conn.prepareStatement(sql);
	pstat.setInt(1,id);
	pstat.executeUpdate();
	pstat.close();
	//关闭数据库连接
	conn.close();
	//重定向到购物车页面
	response.sendRedirect("cart.jsp");
}
//清空购物车
if(op.equals("clear")){
	sql="delete from cart";
	pstat=conn.prepareStatement(sql);
	pstat.executeUpdate();
	pstat.close();
	//关闭数据库及连接
	conn.close();
	//重定向到购物车页面
	response.sendRedirect("cart.jsp");
}
%>
</body>
</html>