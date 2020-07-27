package com.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servletproject.impl.UserDaoImpl;
import com.servletproject.pojo.User;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		

		RequestDispatcher dis1=request.getRequestDispatcher("menu");
		
		RequestDispatcher dis=request.getRequestDispatcher("ChangePassword.html");
		
		dis1.include(request, response);
		dis.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher dis2=request.getRequestDispatcher("menu");
		dis2.include(request, response);
		HttpSession session=request.getSession();
		User user=new User();
		String username=(String) session.getAttribute("username");
				
		String oldPassword=request.getParameter("oldpassword");
		String newPassword=request.getParameter("newpassword");
		System.out.println(oldPassword);
		System.out.println(newPassword);
		System.out.println("user="+username);
		
		PrintWriter pw=response.getWriter();
		UserDaoImpl userDao=new UserDaoImpl();
		
		 if(userDao.login(username, oldPassword)){
			 user.setPassword(newPassword);
			 System.out.println("in login");
		if(userDao.changePassword(username, newPassword)){
			System.out.println("in change");
			System.out.println(newPassword);
			
			pw.println("Password changed sucessfully");
		}else{
			pw.println("Password changed failed");
			}
		 }	
	}

}
