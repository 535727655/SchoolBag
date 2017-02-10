package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.nf.dao.Feedbackdao;
import com.nf.entity.FeedbackBean;


/**
 * Servlet implementation class Feedbackweb
 */
@WebServlet("/Feedbackweb")
public class Feedbackweb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedbackweb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String html="";
		PrintWriter out= response.getWriter();
    	
    	
		SmartUpload sm = new SmartUpload();
		sm.initialize(getServletConfig(), request, response);
		//文件夹路径
		String path=getServletContext().getRealPath("/")+"Tijiao";
		System.out.println("path:"+path);
		String TaskId=null;
		try {
			sm.upload();
		} catch (SmartUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Request rs=sm.getRequest();
		try {
			TaskId=rs.getParameter("TaskId");
			
			
			java.io.File file = new java.io.File(path);
			if (!file.exists())
				file.mkdir();
			Files fls=sm.getFiles();
			for(int i=0;i<fls.getCount();i++){
				File fl=fls.getFile(i);
				if(fl.getSize()<1)
					return ;
				//保存的文件路径和文件名
				String str=new Date().getTime()+fl.getFileName();
				String savepath=path+"/"+str;
				String fbImages="/SchoolBang/Tijiao/"+str;
				System.out.println(savepath);
				fl.saveAs(savepath);
				HttpSession session = request.getSession();//会话
				session.setAttribute("fbImages",fbImages);
				//response.getWriter().println("212312312312");
			}
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();//会话
		
	
		String usId="2";
		String fbContent = rs.getParameter("description");//意见内容
		String fbImages=(String)session.getAttribute("fbImages");//图片
		String fblianxi=rs.getParameter("email");
		
		
		FeedbackBean us= new FeedbackBean();
		
		us.setUsId(usId);
		us.setFbContent(fbContent);
		us.setFbImages(fbImages);
	    us.setFblianxi(fblianxi);		
		Feedbackdao uss=new Feedbackdao();		
		boolean bl=uss.addFeedback(us);
		if(bl){
			html+="<script>alert('发布成功o');</script>";			
		}else{
			html+="<script>alert('发布失败o');</script>";							
			}
		out.println(html);
		out.flush();
		out.close();

		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	}

