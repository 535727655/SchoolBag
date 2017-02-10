package Web_pl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Bo.UsersBo;
import Entity.UsersEntity;

@WebServlet("/SelUsersForLikeServlet")
public class SelUsersForLikeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelUsersForLikeServlet() {
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
		response.setCharacterEncoding("utf-8");
		
		//可选上传4个参数 i row userId userName
		//设置初始值  默认 第一页 每页十行 初始条件为'1=1'
		int i=1;
		int row=10;
		String add="1=1";
		
		//判断用户选择的i 和 row 的值是否为空
		if(request.getParameter("i")!=null&&request.getParameter("i").length()>0)
			i=Integer.parseInt(request.getParameter("i"));
		if(request.getParameter("row")!=null&&request.getParameter("row").length()>0)
			row=Integer.parseInt(request.getParameter("row"));
		
		//判断提交的值(查询条件)是否为空   
		if(request.getParameter("userId")!=null&&request.getParameter("userId").length()>0)
			add+=" and userid like '%"+request.getParameter("userId")+"%'";
		if(request.getParameter("userName")!=null&&request.getParameter("userName").length()>0)
			add+=" and userName like '%"+request.getParameter("userName")+"%'";
		
		//获取查询的结果 ls
		List<UsersEntity> ls=null;
		try {
			System.out.println("条件:"+add);
			ls=new UsersBo().SelUsers(i, row, add);
			System.out.println("返回数组长度:"+ls.size());
			//判断ls是否为空集合
			if(ls.size()>0){
				//不为空  返回json格式的ls数据
				Gson gs=new Gson();
				String str=gs.toJson(ls);//返回的json格式字符串
				
				response.getWriter().print(str);
				
			}else{
				//如果ls集合为空   返回0
				response.getWriter().print("0");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
