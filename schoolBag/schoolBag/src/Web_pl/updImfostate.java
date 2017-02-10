package Web_pl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.H_Bo;
import Bo.ImfoBo;
import Bo.UsersBo;
import Entity.Imformation;
@WebServlet("/updImfostate")
public class updImfostate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updImfostate() {
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
		//更新信息并发送回执信息给完成人(任务接收人)
		response.setCharacterEncoding("utf-8");
		String imfoid=request.getParameter("imfoId");
		if(imfoid==null||imfoid.length()<=0)
			return;
		Imformation im=new Imformation();
		im.setImfoId(Integer.parseInt(imfoid));
		im.setImfostate(1);
		boolean bl=new ImfoBo().UpImfoState(im);
		if(bl){
			Imformation Imforamtion=new ImfoBo().SelImfo(Integer.parseInt(imfoid));
			String imforec=new H_Bo().SelTask(" taskid='"+Imforamtion.getTaskId()+"'").get(0).getTaskRec();
			Imformation Imfo=new Imformation();
			Imfo.setContent("发布人确认了您的请求");
			Imfo.setImfoRec(imforec);//消息接收人=   task接收人
			//imforec积分增加
			new UsersBo().UpdUserInt(imforec, 5);
			Imfo.setImfostate(0);
			Imfo.setImfotime(new Date());
			Imfo.setImfouserid("系统通知");
			Imfo.setTaskId(Imforamtion.getTaskId());
			boolean b=new ImfoBo().send(Imfo);
			response.getWriter().print("1");
		}
		else
			response.getWriter().print("0");
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
