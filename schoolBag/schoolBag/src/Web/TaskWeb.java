package Web;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.TaskBo;
import Entity.TaskEntity;
import Entity.UsersEntity;

@WebServlet("/TaskWeb")
public class TaskWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//ȫ������
		String add="and 1=1";
		String rs=request.getParameter("fenlei");
		System.out.println(rs);
		if(rs!=null){
			if(rs.equals("0")){
				add="and 1=1";
			}
			if(rs.equals("1")){
				add="and taskType='�����ռ�'";
			}
			if(rs.equals("2")){
				add="and taskType='����ִ��'";
			}
			if(rs.equals("3")){
				add="and taskType='���ϴ���'";
			}
			if(rs.equals("4")){
				add="and taskType='����'";
			}
		}
			List<TaskEntity> frenAll=new TaskBo().AllTask(add);
			request.setAttribute("frenAll",frenAll);
			System.out.println(frenAll.size());
		
		//��ѯ����ȡ������
		String TaskRec=((UsersEntity)request.getSession().getAttribute("user")).getUserId();
		
//		
//		HttpSession session=request.getSession();
//		String TaskRec=(String) session.getAttribute("user");
//		
		
//		List<TaskEntity> frenUnclaimed=new TaskBo().UnclaimedTask(TaskRec);
//		request.setAttribute("frenUnclaimed",frenUnclaimed);
		//�����е�����
		
		List<TaskEntity> frenInprocess=new TaskBo().InprocessTask(TaskRec,add);
		request.setAttribute("frenInprocess",frenInprocess);
		
		
		//��ȷ�ϵ�����
		List<TaskEntity> daiquerenprocess=new TaskBo().daiqueren(TaskRec,add);
		request.setAttribute("daiquerenprocess",daiquerenprocess);
		//�����
		List<TaskEntity> frenComplete=new TaskBo().CompleteTask(TaskRec,add);
		request.setAttribute("frenComplete",frenComplete);
		
		//ȡ��Canceled
		List<TaskEntity> frenCanceled=new TaskBo().CanceledTask(TaskRec,add);
		request.setAttribute("frenCanceled",frenCanceled);
		
		request.getRequestDispatcher("center.jsp").forward(request,response);	
	}

}
