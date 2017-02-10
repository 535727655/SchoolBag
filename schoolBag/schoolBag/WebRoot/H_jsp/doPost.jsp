<%@ page language="java" import="java.util.*,H_biz.*,H_entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
    request.setCharacterEncoding("utf-8");  
    String author=request.getParameter("text");  
    String message=request.getParameter("textarea");  
      
    Message messages=new Message();  
    messages.setAuthor(author);  
    messages.setMessage(message);  
    MessageBiz messageBiz=new MessageBiz();  
    messageBiz.saveMessage(messages);  
    response.sendRedirect("lyb.jsp");  
 %>  
	 
</body>
</html>