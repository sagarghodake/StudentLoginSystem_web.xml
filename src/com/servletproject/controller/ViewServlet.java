package com.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.servletproject.impl.UserDaoImpl;
import com.servletproject.pojo.User;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl userDao=new UserDaoImpl();
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		
		//String username=request.getParameter("username");
		System.out.println(username);
		
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher ds=request.getRequestDispatcher("menu");
		ds.include(request, response);
		User userInfo=userDao.viewProfile(username);		
		String operation=request.getParameter("op");
		
		
		if(operation.equalsIgnoreCase("view")){
		if(userDao.viewProfile(username) != null){
			System.out.println("In view Servlet");
			pw.println("<center> <h5>");
			pw.println("<h1> User Information</h1>");
			pw.println("<b>UserName:</b> "+userInfo.getUsername());
			pw.println("<br>");
			pw.println("<b>Name:</b> "+userInfo.getName());
			pw.println("<br>");
			pw.println("<b>Birthdate:</b> "+userInfo.getDate());
			pw.println("</h5></center>");
			}
		}else{
			pw.println("<h1>Edit Profile</h1>");
			pw.println("<form action='editServlet' method='post'>");
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<td align='center'>Name:</td>");
			pw.println("<td><input value='"+userInfo.getName()+"'name='name'></td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td align='center'>DOB:</td>");
			pw.println("<td><input value='"+userInfo.getDate()+"'name='dob'></td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td><input type='submit' name='' value='EDIT PROFILE'> </td>");
			pw.println("</tr>");
		
			
			pw.println("</table>");
			pw.println("</form>");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
