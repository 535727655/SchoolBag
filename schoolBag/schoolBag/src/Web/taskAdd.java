package Web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dao.Taskdao2;
import Entity.TaskEntity;
import Entity.UsersEntity;

/**
 * Servlet implementation class taskAdd
 */
@WebServlet("/taskAdd")
public class taskAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public taskAdd() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String html="";
		PrintWriter out= response.getWriter();
		String rexq=request.getParameter("rexq");//������
		String rebz=request.getParameter("rebz");//������
		String rwxq= request.getParameter("TaskContent");//��������
		//System.out.println("renwu xiangqing:"+rwxq);
		String TaskContent =rexq+"$"+rebz+"$"+rwxq;
		
		String TaskTitle = request.getParameter("TaskTitle");
		
		HttpSession session=request.getSession();
		String TaskImage=(String) session.getAttribute("realPath");
		System.out.println(TaskImage);
		//String TaskImage = request.getParameter("TaskImage");
		String TaskType=request.getParameter("TaskType");
		//int TaskType =Integer.parseInt(request.getParameter("TaskType"));
		//int TaskType=Integer.parseInt(TaskType);
		
		
		// String TaskUserid= request.getParameter("TaskUserid");
		String TaskUserid=((UsersEntity)(request.getSession().getAttribute("user"))).getUserId();//�����Ƿ����˵�����
		 //���ڸ�ʽ
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//���û���������ڸ�ʽ
		  
		 String TaskBeginTime= request.getParameter("TaskBeginTime");
		 String TaskEndTime =request.getParameter("TaskEndTime");
		 Date TaskEndTime2=null;
		 Date TaskBeginTime2 = null;
		try{
			TaskBeginTime2 = (Date) sdf.parse(TaskBeginTime);
			TaskEndTime2 =(Date) sdf.parse(TaskEndTime);//��ת��������
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//��ת��������
		 int TaskState =0;
		 String TaskMoney= request.getParameter("TaskMoney");
		 
		 TaskEntity us=new TaskEntity();
		 us.setTaskTitle(TaskTitle);
		 us.setTaskImage(TaskImage);
		 us.setTaskType(TaskType);
		 us.setTaskContent(TaskContent);
		 us.setTaskUserid(TaskUserid);
		 us.setTaskBeginTime(TaskBeginTime2);
		 us.setTaskEndTime(TaskEndTime2);
		 us.setTaskState(TaskState);
		 us.setTaskMoney(TaskMoney);
		 boolean bl= new Taskdao2().addTask(us);
		 if(bl){
				html+="<script>alert('�����ɹ�');location.href='center.jsp'</script>";			
			}else{
				html+="<script>alert('����ʧ��');location.href='center.jsp'</script>";							
				}
			out.println(html);
			out.flush();
			out.close();

	}
}
