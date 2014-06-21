package com.company.database;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.Principal;
import java.util.Locale;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.company.util.IpUtil;

public class DatabaseServlet extends HttpServlet {

	public static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
		'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	public static Random random = new Random();
	
	public static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	
	public static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
	
	public static Color getReverseColor(Color c) {
		return new Color (255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}
	/**
	* Constructor of the object.
	*/
	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.getLastModified(req);
	}

	/**
	 * Constructor of the object.
	 */
	public DatabaseServlet() {
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
		this.Sample_TextBox(request, response);
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
		this.Sample_TextBox(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	private void Sample_TextBox(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">");
		out.println("<meta http-equiv=\"description\" content=\"this is my page\">");
		out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("	<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">");
		out.println("	<meta http-equiv=\"description\" content=\"this is my page\">");
		out.println("	<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.println("	<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"./styles.css\">-->");
		out.println("</HEAD>");
		out.println("  <BODY>");
		
		String requestURI = request.getRequestURI();
		out.println("<form action='" + requestURI + "' method='post'>");
		out.println("请输入您的名字: <input type='text' name='param' value='wallace.guo'/>");
		out.println("<input type='submit' />");
		out.println("</form>");
		out.println("");
		
		String param = request.getParameter("param");
		
		if (param != null && param.trim().length() > 0){
			out.println("您好， <b>" + param + "</b>. 欢迎来到Java Web 世界。<br/>");
		}
		
		String method = request.getMethod();
		
		param = request.getParameter("param");
		
		out.println(" 以" + method + " 方式访问 该页面。 取到的param参数为：" + param + "<br/>");
		
		out.println("	<form action='" + requestURI + "' method='get'><input type='text' name='param' value='param string'><input type='submit' value='以GET方式查询页面  " + requestURI + "'></form>");
		out.println("	<form action='" + requestURI + "' method='post'><input type='text' name='param' value='param string'><input type='submit' value='以POST方式查询页面  " + requestURI + "'></form>");
		out.println("	<script>document.write('本页面最后更新时间：' + document.lastModified); </script>");
		out.println("<br/>");

		String authType = request.getAuthType();
		String localAddr = request.getLocalAddr();
		String localName = request.getLocalName();
		int localPort = request.getLocalPort();
		
		Locale locale = request.getLocale();
		String contextPath = request.getContextPath();
		String pathInfo = request.getPathInfo();
		String pathTranslated = request.getPathTranslated();
		String protocol = request.getProtocol();
		String queryString = request.getQueryString();
		String remoteAddr = request.getRemoteAddr();
		int port = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String requestedSessionId = request.getRequestedSessionId();
		StringBuffer requestURL = request.getRequestURL();
		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String servletPath = request.getServletPath();
		Principal userPrincipal = request.getUserPrincipal();
		String accept = request.getHeader("accept");
		String referer = request.getHeader("referer");
		String userAgent = request.getHeader("user-agent");
		String serverInfo = this.getServletContext().getServerInfo();
		
		out.println("<b>您的IP为</b>" + remoteAddr + "<b>, 位于</b> " + getAddress(remoteAddr) + "<b>: 您使用</b>" + getOS(userAgent) + "<b>操作系统</b>, " + getNavigator(userAgent) + "<b>。 您使用</b> " + getLocale(locale) + "。</br>");
		out.println("<b>服务器IP为</b>" + localAddr + "<b>, 位于</b> " + getAddress(localAddr) + "<b>:服务器使用</b>" + serverPort + "<b>端口，您的浏览器使用了</b>, " + port + "<b>端口访问本网页。</b></br>");
		out.println("<b>服务器软件为</b>" + serverInfo + "<b>. 服务器名称为</b> " + localName + "</br>");
		out.println("<b>您的浏览器接受</b>" + getAccept(accept) + ".</br>");
		out.println("<b>您从</b>" + referer + "<b>访问到该页面。</b></br>");
		out.println("<b>使用的协议为</b>" + protocol + ".<b>URL 协议头</b>" + scheme + ",<b>服务器名称</b>" + serverName + ", <b>您访问的URI为</b>" + requestURI + ". </br>");
		out.println("<b>该 Servlet路径为</b>" + servletPath + ", <b>该 Servlet类名为</b>" + this.getClass().getName() + ". </br>");
		out.println("<b>本应用程序在硬盘的根目录为</b>" + this.getServletContext().getRealPath("") + ", <b>网络相对路径为</b>" + contextPath + ". </br>");
		out.println("<br/>");
		out.println("<br/><br/> <a href=" + requestURI + "> 单机刷新本页面</a>");
		
		out.println("    <script>" 
					+ "function reloadImage() {"
					+ "document.getElementById('btn').disabled = true;"
					+ "document.getElementById('identity').src='servlet/OutputPicture?ts=' + new Date().getTime();"
    				+ "}</script>");
		out.println("	<img src=\"servlet/OutputPicture\" id=\"identity\" onload=\"btn.disabled=false;\" />");
		out.println("	<input type=button value=\" 换个图片 \" onclick=\"reloadImage()\" id=\"btn\">");

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	private String getAccept(String accept) {
		StringBuffer buffer = new StringBuffer();
		if (accept.contains("image/gif"))	buffer.append("GIF文件, ");
		if (accept.contains("image/x-xbitmap"))	buffer.append("BMP文件, ");
		if (accept.contains("image/jpeg"))	buffer.append("JPG文件, ");
		if (accept.contains("application/vnd.ms-excel"))	buffer.append("Excel 文件, ");
		if (accept.contains("application/vnd.ms-powerpoint"))	buffer.append("PPT 文件, ");
		if (accept.contains("application/msword"))	buffer.append("Word 文件, ");
		return buffer.toString().replace(", $", "");
	}
	
	private String getLocale(Locale locale) {
		if (Locale.SIMPLIFIED_CHINESE.equals(locale))  return "简体中文";
		if (Locale.TRADITIONAL_CHINESE.equals(locale))  return "繁体中文";
		if (Locale.ENGLISH.equals(locale))  return "英文";
		if (Locale.JAPANESE.equals(locale))  return "日文";
		return "未知语言环境";
	}
	
	private String getAddress(String ip) {
		return IpUtil.getIpAddress(ip);
	}
	
	private String getNavigator(String userAgent) {
		if (userAgent.indexOf("TencentTraveler") > 0) return "腾讯浏览器";
		if (userAgent.indexOf("Maxthon") > 0) return "遨游浏览器";
		if (userAgent.indexOf("MyIE2") > 0) return "MyIE浏览器";
		if (userAgent.indexOf("Firefox") > 0) return "火狐浏览器";
		if (userAgent.indexOf("MSIE") > 0) return "IE浏览器";
		if (userAgent.indexOf("Chrome") > 0) return "Google浏览器";
		return "未知浏览器";
	}
	
	private String getOS(String userAgent) {
		if (userAgent.indexOf("Windows NT 5.1") > 0) return "Windows XP";
		if (userAgent.indexOf("Windows 98") > 0) return "Windows 98";
		if (userAgent.indexOf("Windows NT 5.0") > 0) return "Windows 2000";
		if (userAgent.indexOf("Windows NT 6.1") > 0) return "Windows 7";
		if (userAgent.indexOf("Linux") > 0) return "Linux";
		if (userAgent.indexOf("Unix") > 0) return "Unix";
		return "未知";
	}
}
