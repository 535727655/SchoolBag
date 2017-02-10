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
@WebServlet("/getTaskServlet")
public class getTaskServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getTaskServlet() {
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
		
		
		
		//返回任务详细信息    否则返回0
		response.setCharacterEncoding("utf-8");
		String taskId=request.getParameter("taskId");
		String add=null;
		if(taskId==null||taskId.length()<=0)
			return;
		else{
			add="taskId="+taskId;
			 List<TaskEntity> ls=new H_Bo().SelTask(add);
			 if(ls.size()>0){
				 Gson gs=new Gson();
				 String msg=gs.toJson(ls);
				 response.getWriter().print(msg);
			 }else{
				 response.getWriter().print(0);
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
