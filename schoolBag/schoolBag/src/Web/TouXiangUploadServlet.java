package Web;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class TouXiangUploadServlet
 */
@WebServlet("/TouXiangUploadServlet")
public class TouXiangUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TouXiangUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SmartUpload sm = new SmartUpload();
		sm.initialize(getServletConfig(), request, response);
		//文件夹路径
		String path=getServletContext().getRealPath("/")+"Touxiang";
		System.out.println("path:"+path);
		try {
			sm.upload();
			java.io.File file = new java.io.File(path);
			if(!file.exists()){
				file.mkdirs();
				System.out.println("123");
			}
			Files fls=sm.getFiles();
			for(int i=0;i<fls.getCount();i++){
				File fl=fls.getFile(i);
				if(fl.getSize()<1)
					return ;
				//保存的文件路径和文件名
				String str=new Date().getTime()+fl.getFileName();
				String savepath=path+"/"+str;
				String realpath="/schoolBag/Touxiang/"+str;
				System.out.println(savepath);
				fl.saveAs(savepath);
				HttpSession session = request.getSession();//会话
				session.setAttribute("realPath",realpath);
				response.getWriter().println("212312312312");
			}
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
