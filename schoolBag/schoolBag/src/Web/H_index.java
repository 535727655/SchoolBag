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

import com.google.gson.Gson;

import Bo.H_Bo;
import Entity.TaskEntity;


@WebServlet("/H_index")
public class H_index extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public H_index() {
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
/**
 *Ĭ�ϲ�ѯ�����е�����
 *��ɸѡ  ��������   ����  ����  ����  ����  TaskType
 *���ݷ����� TaskUserid-״̬:TaskState:������  �����  ȡ��
 *���ݽ����� TaskRec-״̬:TaskState:������ ����� ȡ��
 *
 *��Ҫ���� i row
 *
 *����ɸѡ����  TaskType   һ��
 *״̬ɸѡ���� TaskState	     һ��
 *������ɸѡ TaskUserId  һ��
 *������ɸѡTaskRec һ��
 *
 *
 *�������򷵻����� û���򷵻�0
 * */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//ҳ�洫�����4������ left:�������� right:״̬����  taskUserid:������ TaskRec:������
		//String left=request.getParameter("left");
		//������TaskRec ������TaskUserId
		//ѡ������˻򷢲���ʱ  ����select[9|10]+ "'������Id'"
		String[] select={
				"1=1","TaskType='�����ռ�'","TaskType='����ִ��'","TaskType='���ϴ���'","TaskType='����'",
				"TaskState=1","TaskState=2","TaskState=3","TaskState=0",
				"TaskUserid like","TaskRec like"
		};
		//TaskType,TaskState,TaskUserId,taskRec; ���ó�ʼֵ
		String TaskType=select[0];//����ɸѡ����
		String TaskState=select[0];//״̬ɸѡ����
		String TaskUserId=select[0];//������ɸѡ����
		String TaskRec=select[0];//������ɸѡ����
		HttpSession session=request.getSession();

		
		//System.out.println("TaskState:"+request.getParameter("TaskState"));
		
		//����ɸѡ ����servlet ��ֵΪ1|2|3|4
		if(request.getParameter("TaskType")!=null&&request.getParameter("TaskType").length()!=0){
			TaskType=select[Integer.parseInt(request.getParameter("TaskType"))]; //��ȡselect�ַ��������Ӧ��String
		}
		//״̬ɸѡ ����ֵΪ 5|6|7|8
		if(request.getParameter("TaskState")!=null&&request.getParameter("TaskState").length()!=0){
			TaskState=select[Integer.parseInt(request.getParameter("TaskState"))]; //��ȡselect�ַ��������Ӧ��String
		}
		//������ɸѡ     ����ֵΪ�ַ���=������ID
		if(request.getParameter("TaskUserId")!=null&&request.getParameter("TaskUserId").length()!=0){
			TaskUserId=select[9]+"'%"+request.getParameter("TaskUserId")+"%'"; //��ȡselect�ַ��������Ӧ��String
		}
		//������ɸѡ	����ֵΪ�ַ���=������ID
		if(request.getParameter("TaskRec")!=null&&request.getParameter("TaskRec").length()!=0){
			TaskRec=select[10]+"'%"+request.getParameter("TaskRec")+"%'"; //��ȡselect�ַ��������Ӧ��String
		}
		
		String add=TaskType+" and "+TaskState+" and "+TaskUserId+" and "+TaskRec;//����
		
		//��ѯ����   ���浽ls
		int i=Integer.parseInt(request.getParameter("i"));
		int row=Integer.parseInt(request.getParameter("row"));
		
		
		//System.out.println("TaskUserId:"+TaskUserId+"///TaskRec:"+TaskRec);
		
		List<TaskEntity> ls=new H_Bo().SelTask(i,row,add);
		//System.out.println("ls.size="+ls.size());
		//��lsתΪjson��ʽ������
		Gson gs=new Gson();
		String ms=null;//���ص���Ϣֵ
		if(ls.size()>0){
			ms=gs.toJson(ls);
		}else{
			ms="0";
		}
		response.getWriter().print(ms);
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
