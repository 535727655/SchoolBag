package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Taskdao2;

/**
 * Servlet implementation class Abolishweb
 */
@WebServlet("/Abolishweb")
public class Abolishweb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Abolishweb() {
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
		PrintWriter out= response.getWriter();
		int TaskId=Integer.parseInt(request.getParameter("TaskId"));
		Taskdao2 td=new Taskdao2();
		boolean bl=td.Abolish(TaskId);
		if(bl){
			html+="<script>";
			html+="alert('取消成功');location.href='/schoolBag/center.jsp'";
			html+="</script>";
		}else{
			html+="<script>";
			html+="alert('取消失败');location.href='/schoolBag/center.jsp'";
			html+="</script>";
		}
		out.print(html);
		out.flush();
		out.close();
	}

}
