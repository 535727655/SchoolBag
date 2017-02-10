package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.TaskBo;
import Dao.Taskdao2;
import Entity.TaskEntity;
import Entity.UsersEntity;

/**
 * Servlet implementation class InTaskRec
 */
@WebServlet("/InTaskRec")
public class InTaskRec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InTaskRec() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String html="";
		HttpSession session = request.getSession();
		String TaskId=request.getParameter("TaskId2");
	
		PrintWriter out=response.getWriter();
		//int TaskId=11;//编号
		session.setAttribute("TaskId", TaskId);
		String TaskRec=((UsersEntity)request.getSession().getAttribute("user")).getUserId();//接收人
		boolean bl=new Taskdao2().InTaskRec(TaskRec,TaskId);
		if(bl){
			html+="<script>";
			html+="alert('领取成功')";
			html+="</script>";

			out.println(html);
			//int taskId = Integer.parseInt(request.getParameter("TaskId"));
			List<TaskEntity> bl2= new TaskBo().MytaskIdTask(TaskId,"and 1=1");
		
			request.setAttribute("bl2",bl2);
			request.getRequestDispatcher("Studentss.jsp").forward(request,response);	
		
		}else{
			html+="失败";
		}
		out.println(html);
		out.flush();
		out.close();
		//request.setAttribute("bl",bl);
		//request.getRequestDispatcher("Studentss.jsp").forward(request,response);
		
	}

}
