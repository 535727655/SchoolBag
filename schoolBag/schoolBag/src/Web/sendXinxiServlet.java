package Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.send;

@WebServlet("/sendxinxi")
public class sendXinxiServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public sendXinxiServlet() {
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

			response.setCharacterEncoding("utf-8");
			if(request.getParameter("phone")==null){
				response.getWriter().print("手机号码不正确");
				return;
			}
			int i=(int) ((Math.random())*1000000);
			System.out.println(i+"=="+request.getParameter("phone"));
			request.getSession().setAttribute("yzm", i);
			request.getSession().setAttribute("phone", request.getParameter("phone"));
			try {
				//new sendXinxi().send(request.getParameter("phone"), i+"");
				String str=send.send(request.getParameter("phone"), (i+""));
				Gson gs=new Gson();
				msg m=gs.fromJson(str, msg.class);
				if(m.getSuccessCounts()==1){
					response.getWriter().print("1");
				}else{
					response.getWriter().print("请输入正确的手机号码");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

//{"returnstatus":"Success","message":"ok","remainpoint":"-3581135","taskID":"9456626","successCounts":"1"}

class msg{
	private String returnstatus;
	private String message;
	private String remainpoint;
	private int taskID;
	private int successCounts;
	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRemainpoint() {
		return remainpoint;
	}
	public void setRemainpoint(String remainpoint) {
		this.remainpoint = remainpoint;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public int getSuccessCounts() {
		return successCounts;
	}
	public void setSuccessCounts(int successCounts) {
		this.successCounts = successCounts;
	}
	
}