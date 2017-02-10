<%@ page language="java" import="java.util.*,H_biz.*,H_entity.Message" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板系统</title>
<script>
	function check(){
		var name=document.form.text.value;
		var pass=document.form.textarea.value;
		if(name.length==0){
			alert("用户名不能为空!");
			return false;
		}
		if(pass.length==0){
			alert("留言信息不能为空!");
			return false;
		}
		return true;
	}
</script>
</head>
<body style="margin-left:130px;">  
<a href="index.html">回首页</a>
    <h1 >留言板</h1>  
    <div style="width:800px; border:#CCCCCC solid 1px;">  
        <%  
            String p=request.getParameter("p");  
            int pageNum=1;          //定义页数  
            int pageSize=10;        //定义每一页显示的个数  
            if(p!=null){            //判断传入的输入值是否为空，并且进行强制类型转换  
                pageNum=Integer.parseInt(p);  
            }  
              
            MessageBiz messageBiz=new MessageBiz();  
            List<Message> list=messageBiz.listByPage(pageSize,pageNum); //根据传入的两个参数，返回一个list集合  
      
            for(int i=list.size()-1;i>=0;i--){  
                Message message=new Message();  
                message=(Message)list.get(i);  
        %>  
          
        <div style="width:800px;">  
            <div style="background-color:#CCCCCC; text-align:left;">买家：<%=message.getAuthor() %>  
                       <%=message.getPostTime() %>  
            </div>  
            <div style="text-align:right;"><%=i+1+(pageNum-1)*pageSize %>#</div>  
            <div><%=message.getMessage() %>  
            </div>  
        </div>  
        <%  
            }  
            //获得最大页码  
            int maxPage;  
            int reCount=messageBiz.getAllUserCount();  
            if(reCount%pageSize==0)  
                maxPage=reCount/pageSize;  
            else  
                maxPage=(reCount/pageSize)+1;  
                  
            int backPage=(pageNum==1) ? 1 :pageNum-1;  
            int nextPage=(pageNum==maxPage) ? maxPage : pageNum+1;  
        %>  
    </div>  
      
      
    <div style="width:800px; height:30px; border:#000033 solid 0px; margin-top:12px; text-align:right;">  
        <div style="width:50px; height:15px; border:#CCCCCC solid 1px; display:inline; cursor:pointer;">  
            <a href="lyb.jsp?p=<%=backPage %>">上一页</a>  
        </div>  
        <div style="width:50px; height:15px; border:#CCCCCC solid 1px; display:inline; margin-left:12px; margin-right:20px; cursor:pointer;">  
            <a href="lyb.jsp?p=<%=nextPage %>">下一页</a>  
        </div>  
    </div>  
    <div style=" width:800px; height:300px; border:#333333 solid 0px;">  
        <form name="form" action="doPost.jsp" method="post" onSubmit="return check()">  
            <table>  
                    <tr>  
                        <td>用户名：</td>  
                        <td><input type="text" name="text"/></td>  
                    </tr>  
                    <tr>  
                        <td>留言信息：</td>  
                        <td><textarea name="textarea" style="width:400px; height:200px;"></textarea></td>  
                    </tr>  
                    <tr><td><input type="submit" value="提交"/></td></tr>  
                </table>  
        </form>  
    </div>  
</body>
</html>