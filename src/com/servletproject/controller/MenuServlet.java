package com.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession ses=request.getSession();
		PrintWriter pw = response.getWriter();
		String userName=(String) ses.getAttribute("username");
		pw.println("<center>");
			
		if(userName != null){
			
			pw.println("<ul style='list-style-type: none' "
					+ " 'float: left padding: 10px 10px 10px 10px '>");
			pw.println("<li> <a href='menu'> Home </a></li>");
			pw.println("<li> <a href=viewServlet?op=view> View Profile </a></li>");
			pw.println("<li> <a href=viewServlet?op=edit> Edit Profile </a></li>");
			pw.println("<li> <a href='changePassword'> Change Password </a></li>");
			pw.println("<li> <a href='login'> Logout </a></li>");
			pw.println("</ul>");
			pw.println("<center><p style='color:green '> WELCOME "+userName+"</p></center>");
		}else{
			pw.println("<ul style='list-style: none'>");
			pw.println("<form><li> <a href='Login.html'> Login </a></li></form>");
			pw.println("<li> <a href='Register.html'> Register </a></li>");
			pw.println("</ul");
			
		}
		pw.println("</center>");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
