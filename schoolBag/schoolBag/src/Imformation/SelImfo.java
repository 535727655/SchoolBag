package Imformation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Bo.ImfoBo;
import Entity.Imformation;
import Entity.UsersEntity;

@WebServlet("/SelImfo")
public class SelImfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelImfo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		//用户提交获取数据形式(数量或数据)  and 消息状态(是否查看)
		//返回需要的值   id=数据形式    status=消息状态
		 response.setCharacterEncoding("utf-8");
		 String id=request.getParameter("id");
		 String status=request.getParameter("status");
		 UsersEntity user=(UsersEntity)request.getSession().getAttribute("user");
		 List<Imformation> ls=new ImfoBo().SelImfo(user, Integer.parseInt(status)); //查看当前登录账号未读消息
		System.out.println("ls.size"+ls.size());
		 Gson gs=new Gson();
		 if(id!=null){
			 if(id.equals("1")){
				 if(ls.size()>0){
					 String list=gs.toJson(ls);
					 response.getWriter().print(list);
				 }else{
					 response.getWriter().print("0");
				 }
			 }else if(id.equals("0")){
				 response.getWriter().print(ls.size());
			 }
		 }
 }

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
