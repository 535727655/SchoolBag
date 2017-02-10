package Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.TaskBo;
import Entity.TaskEntity;
import Entity.UsersEntity;

/**
 * Servlet implementation class TaskID
 */
@WebServlet("/TaskId2")
public class TaskId2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskId2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String taskId = request.getParameter("taskId");
			List<TaskEntity> ls= new TaskBo().MytaskIdTask(taskId,"and 1=1");
			
			request.setAttribute("bl",ls);
			request.getRequestDispatcher("Taskissu.jsp").forward(request,response);	
		
	}

}
