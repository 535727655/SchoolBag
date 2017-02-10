package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.TaskBo;
import Entity.TaskEntity;
import Entity.UsersEntity;

@WebServlet("/TaskFenlei")
public class TaskFenlei extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TaskFenlei() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String add=null;
//		//全部任务
			List<TaskEntity> frenAll=new TaskBo().AllTask(add);
			request.setAttribute("frenAll",frenAll);
		
		//查询待领取的任务
		String TaskRec=((UsersEntity)request.getSession().getAttribute("user")).getUserId();
		
//		
//		HttpSession session=request.getSession();
//		String TaskRec=(String) session.getAttribute("user");
//		
		
//		List<TaskEntity> frenUnclaimed=new TaskBo().UnclaimedTask(TaskRec);
//		request.setAttribute("frenUnclaimed",frenUnclaimed);
		//处理中的任务
		
		List<TaskEntity> frenInprocess=new TaskBo().InprocessTask(TaskRec,add);
		request.setAttribute("frenInprocess",frenInprocess);
		//已完成
		List<TaskEntity> frenComplete=new TaskBo().CompleteTask(TaskRec,add);
		request.setAttribute("frenComplete",frenComplete);
		
		//取消Canceled
		List<TaskEntity> frenCanceled=new TaskBo().CanceledTask(TaskRec,add);
		request.setAttribute("frenCanceled",frenCanceled);
		
		request.getRequestDispatcher("center.jsp").forward(request,response);	
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
