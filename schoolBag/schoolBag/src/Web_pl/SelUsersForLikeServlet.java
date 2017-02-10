package Web_pl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Bo.UsersBo;
import Entity.UsersEntity;

@WebServlet("/SelUsersForLikeServlet")
public class SelUsersForLikeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelUsersForLikeServlet() {
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
		
		//��ѡ�ϴ�4������ i row userId userName
		//���ó�ʼֵ  Ĭ�� ��һҳ ÿҳʮ�� ��ʼ����Ϊ'1=1'
		int i=1;
		int row=10;
		String add="1=1";
		
		//�ж��û�ѡ���i �� row ��ֵ�Ƿ�Ϊ��
		if(request.getParameter("i")!=null&&request.getParameter("i").length()>0)
			i=Integer.parseInt(request.getParameter("i"));
		if(request.getParameter("row")!=null&&request.getParameter("row").length()>0)
			row=Integer.parseInt(request.getParameter("row"));
		
		//�ж��ύ��ֵ(��ѯ����)�Ƿ�Ϊ��   
		if(request.getParameter("userId")!=null&&request.getParameter("userId").length()>0)
			add+=" and userid like '%"+request.getParameter("userId")+"%'";
		if(request.getParameter("userName")!=null&&request.getParameter("userName").length()>0)
			add+=" and userName like '%"+request.getParameter("userName")+"%'";
		
		//��ȡ��ѯ�Ľ�� ls
		List<UsersEntity> ls=null;
		try {
			System.out.println("����:"+add);
			ls=new UsersBo().SelUsers(i, row, add);
			System.out.println("�������鳤��:"+ls.size());
			//�ж�ls�Ƿ�Ϊ�ռ���
			if(ls.size()>0){
				//��Ϊ��  ����json��ʽ��ls����
				Gson gs=new Gson();
				String str=gs.toJson(ls);//���ص�json��ʽ�ַ���
				
				response.getWriter().print(str);
				
			}else{
				//���ls����Ϊ��   ����0
				response.getWriter().print("0");
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
