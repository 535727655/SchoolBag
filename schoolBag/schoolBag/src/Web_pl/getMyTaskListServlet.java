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

import Bo.H_Bo;
import Entity.TaskEntity;
import Entity.UsersEntity;

@WebServlet("/getTaskListServlet")
public class getMyTaskListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getMyTaskListServlet() {
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
		
		//查询我发布的 分页的 task add由用户输入
		response.setCharacterEncoding("utf-8");
		String add=" 1=1";
		if(request.getParameter("add")==null||request.getParameter("add").length()>0){
			add=request.getParameter("add");
			
			add+=" and TaskUserid='"+((UsersEntity)request.getSession().getAttribute("user")).getUserId()+"'";
			System.out.println(add);
			List<TaskEntity> ls=new H_Bo().SelTask(1, 10, add);
			System.out.println("ls.size():"+ls.size());
			Gson gs=new Gson();
			String str=gs.toJson(ls);
			response.getWriter().print(str);
		}else{
			response.getWriter().print("0");
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
