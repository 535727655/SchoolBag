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
 *默认查询出所有的任务
 *可筛选  根据类型   线上  线下  调查  其他  TaskType
 *根据发布人 TaskUserid-状态:TaskState:处理中  已完成  取消
 *根据接收人 TaskRec-状态:TaskState:处理中 已完成 取消
 *
 *必要参数 i row
 *
 *类型筛选条件  TaskType   一个
 *状态筛选条件 TaskState	     一个
 *发布人筛选 TaskUserId  一个
 *接收人筛选TaskRec 一个
 *
 *
 *有数据则返回数据 没有则返回0
 * */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//页面传入最多4个参数 left:类型条件 right:状态条件  taskUserid:发布人 TaskRec:接收人
		//String left=request.getParameter("left");
		//接收人TaskRec 发布人TaskUserId
		//选择接收人或发布人时  后面select[9|10]+ "'发布人Id'"
		String[] select={
				"1=1","TaskType='调查收集'","TaskType='线下执行'","TaskType='线上传播'","TaskType='其他'",
				"TaskState=1","TaskState=2","TaskState=3","TaskState=0",
				"TaskUserid like","TaskRec like"
		};
		//TaskType,TaskState,TaskUserId,taskRec; 设置初始值
		String TaskType=select[0];//类型筛选条件
		String TaskState=select[0];//状态筛选条件
		String TaskUserId=select[0];//发布人筛选条件
		String TaskRec=select[0];//接收人筛选条件
		HttpSession session=request.getSession();

		
		//System.out.println("TaskState:"+request.getParameter("TaskState"));
		
		//类型筛选 传入servlet 的值为1|2|3|4
		if(request.getParameter("TaskType")!=null&&request.getParameter("TaskType").length()!=0){
			TaskType=select[Integer.parseInt(request.getParameter("TaskType"))]; //获取select字符串数组对应的String
		}
		//状态筛选 传入值为 5|6|7|8
		if(request.getParameter("TaskState")!=null&&request.getParameter("TaskState").length()!=0){
			TaskState=select[Integer.parseInt(request.getParameter("TaskState"))]; //获取select字符串数组对应的String
		}
		//发布人筛选     传入值为字符串=发布人ID
		if(request.getParameter("TaskUserId")!=null&&request.getParameter("TaskUserId").length()!=0){
			TaskUserId=select[9]+"'%"+request.getParameter("TaskUserId")+"%'"; //获取select字符串数组对应的String
		}
		//接收人筛选	传入值为字符串=接收人ID
		if(request.getParameter("TaskRec")!=null&&request.getParameter("TaskRec").length()!=0){
			TaskRec=select[10]+"'%"+request.getParameter("TaskRec")+"%'"; //获取select字符串数组对应的String
		}
		
		String add=TaskType+" and "+TaskState+" and "+TaskUserId+" and "+TaskRec;//条件
		
		//查询数据   保存到ls
		int i=Integer.parseInt(request.getParameter("i"));
		int row=Integer.parseInt(request.getParameter("row"));
		
		
		//System.out.println("TaskUserId:"+TaskUserId+"///TaskRec:"+TaskRec);
		
		List<TaskEntity> ls=new H_Bo().SelTask(i,row,add);
		//System.out.println("ls.size="+ls.size());
		//将ls转为json格式并返回
		Gson gs=new Gson();
		String ms=null;//返回的消息值
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
