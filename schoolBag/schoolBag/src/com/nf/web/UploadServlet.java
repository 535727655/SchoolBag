package com.nf.web;


import java.io.IOException;
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

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	public UploadServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SmartUpload sm = new SmartUpload();
		sm.initialize(getServletConfig(), request, response);
		//文件夹路径
		String filename=getServletContext().getRealPath("/")+"Touxiang";
		System.out.println("filename:"+path);
		try {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			sm.upload();
			Request rs=sm.getRequest();
			String des=rs.getParameter("description");
			
			
			
			
			
			java.io.File file = new java.io.File("filename");
			if (!file.exists())
				file.mkdir();
			Files fls=sm.getFiles();
			for(int i=0;i<fls.getCount();i++){
				File fl=fls.getFile(i);
				if(fl.getSize()<1)
					return ;
				//保存的文件路径和文件名
				String str=new Date().getTime()+fl.getFileName();
				String savepath=filename+"/"+str;
				String realpath="/SchoolBang/Touxiang/"+str;
				System.out.println(savepath);
				fl.saveAs(savepath);
				HttpSession session = request.getSession();//会话
				session.setAttribute("realPath",realpath);
				response.getWriter().println("212312312312");
			}
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
