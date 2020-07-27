package com.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servletproject.dao.UserDao;
import com.servletproject.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		session.invalidate();
		PrintWriter pw=response.getWriter();

		RequestDispatcher dis=request.getRequestDispatcher("menu");
		RequestDispatcher dis1=request.getRequestDispatcher("login");

		dis.include(request, response);
		pw.println("<center><p style='color:green'>User Logged out sucessfully</p></center>" );
		dis1.include(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDaoImpl userDaoImpl=new UserDaoImpl();
	
		RequestDispatcher ds1=request.getRequestDispatcher("menu");
		ds1.include(request, response);
	
		if(userDaoImpl.login(username, password)){
			
		HttpSession session=request.getSession();
		session.setAttribute("username", username);	
		
		pw.println("<center><p style='color:green'>User Logged sucessfully</p></center>" );

		} else {
		pw.println("<center><p style='color:red'>User Logged in Failed</p></center>" );

			RequestDispatcher dis = request.getRequestDispatcher("Login.html");

			dis.include(request, response);
		}

	}

}
