package com.company.main;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextParamServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ContextParamServlet() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>��ȡ�����Ĳ���</TITLE></HEAD>");
		out.println("  <link rel='stylesheet' type='text/css' href='../css/style.css'>");
		out.println("  <BODY>");
		out.println("<div align=center><br/>");
		out.println("<fieldset style='width:90%'><legend>���е������Ĳ���</legend><br/>");
		ServletContext servletContext = getServletConfig().getServletContext();
		String uploadFolder = servletContext.getInitParameter("upload folder");
		String allowedFileType = servletContext.getInitParameter("allowed file type");
		out.println("<div class='line'>");
		out.println("	<div align='left' class='leftDiv'>�ϴ��ļ���</div>");
		out.println("	<div align='left' class='rightDiv'>" + uploadFolder + "</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("	<div align='left' class='leftDiv'>ʵ�ʴ���·��</div>");
		out.println("	<div align='left' class='rightDiv'>" + servletContext.getRealPath(uploadFolder) + "</div>");
		out.println("</div>");
		out.println("<div class='line'>");
		out.println("	<div align='left' class='leftDiv'>�����ϴ���������</div>");
		out.println("	<div align='left' class='rightDiv'>" + allowedFileType + "</div>");
		out.println("</div>");
		out.println("</fieldset></div>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
