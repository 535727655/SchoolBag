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

import Bo.ImfoBo;
import Bo.TaskBo;
import Dao.Taskdao2;
import Entity.Imformation;
import Entity.TaskEntity;

/**
 * Servlet implementation class UploadTijiao
 */
@WebServlet("/UploadTijiao")
public class UploadTijiao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadTijiao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	
    		throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		/**
		 * 提交图片 更新task表TaskShancImage列
		 * 并发送消息给发布人  请求确认完成
		 * */
		String html="";
		PrintWriter out= response.getWriter();
    	
    	
		SmartUpload sm = new SmartUpload();
		sm.initialize(getServletConfig(), request, response);
		//文件夹路径
		String path=getServletContext().getRealPath("/")+"Tijiao";
		System.out.println("path:"+path);
		String TaskId=null;
		String realpath=" ";
		try {
			sm.upload();
			Request rs=sm.getRequest();
			TaskId=rs.getParameter("TaskId");
			java.io.File file = new java.io.File(path);
			System.out.println(file.isDirectory());
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
				realpath+="/schoolBag/Tijiao/"+str+"$";
				System.out.println(savepath);
				fl.saveAs(savepath);
				//response.getWriter().println("212312312312");
			}
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();//会话
	//String taskShancImage=(String)session.getAttribute("realpath2");
		//String TaskId2 =(String) session.getAttribute("TaskId");
		
		Taskdao2 task= new Taskdao2();
		
		TaskEntity ts=new TaskEntity();
		ts.setTaskShancImage(realpath);
		System.out.println(ts.getTaskShancImage());
		ts.setTaskId(TaskId);
		System.out.println("realpath:"+realpath+"taskId:"+TaskId);
		boolean bl= task.addRw(ts);//更新task提交图片列
		
		//提交成功==修改数据库成功==发送消息给发布人,发布人确认完毕则任务完成
		if(bl){
			Imformation im=new Imformation();
			String Taskuserid=new TaskBo().MytaskIdTask(TaskId," and 1=1").get(0).getTaskUserid();
			im.setContent("您的任务被完成!快去看看吧");
			im.setImfoRec(Taskuserid);
			im.setImfostate(0);
			im.setImfotime(new Date());
			im.setImfouserid("系统通知");
			im.setTaskId(Integer.parseInt(TaskId));
			boolean b=new ImfoBo().send(im);
			new TaskBo().updState(Integer.parseInt(TaskId), 4);//提交成功则将任务状态改为待确认
			System.out.println("消息发送状态:"+b);
			html+="<script>alert('提交成功');location.href='center.jsp'</script>";			
		}else{
			html+="<script>alert('提交失败');location.href='center.jsp'</script>";							
		}
		out.println(html);
		out.flush();
		out.close();

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
