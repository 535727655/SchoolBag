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

/**
 * Servlet implementation class YiqueRen
 */
@WebServlet("/YiqueRen")
public class YiqueRen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YiqueRen() {
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
			String taskId =request.getParameter("taskId");
			
			List<TaskEntity> bl= new TaskBo().MytaskIdTask(taskId,"and 1=1");
		
			request.setAttribute("bl",bl);
			request.getRequestDispatcher("Yiqueren.jsp").forward(request,response);	
		
	}

}
