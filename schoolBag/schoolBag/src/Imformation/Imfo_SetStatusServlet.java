package Imformation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.ImfoBo;
import Entity.Imformation;


@WebServlet("/Imfo_SetStatusServlet")
public class Imfo_SetStatusServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Imfo_SetStatusServlet() {
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
		//修改imformation状态status 的servlet
		String imfoId= request.getParameter("imfoId");
		String state=request.getParameter("state");
		if(imfoId==null||state==null){
			return;
		}else{
			Imformation im=new Imformation();
			im.setImfoId(Integer.parseInt(imfoId));
			im.setImfostate(Integer.parseInt(state));
			boolean bl=	new ImfoBo().UpImfoState(im);
			if(bl){
				response.getWriter().print("1"); //成功
			}else{
				response.getWriter().print("0"); //失败
			}
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
