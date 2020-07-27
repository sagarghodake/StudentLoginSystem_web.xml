package com.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

import com.servletproject.dao.UserDao;
import com.servletproject.impl.UserDaoImpl;
import com.servletproject.pojo.User;

public class MyServlet extends HttpServlet{
	
	UserDaoImpl userImpl = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get data from request object as parameter
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		
		PrintWriter pw = resp.getWriter();
			
		// put all deata into user object that is required to call register function
		User user = new User();

		user.setUsername(req.getParameter("username"));
		user.setPassword((req.getParameter("password")));
		user.setName(req.getParameter("name"));
		user.setDate(req.getParameter("dob"));

		boolean registerUserStatus = userImpl.register(user);
		resp.setContentType("text/html");
			RequestDispatcher dis1=req.getRequestDispatcher("menu");

		if (registerUserStatus) {

			RequestDispatcher dis = req.getRequestDispatcher("Login.html");
			
			dis1.include(req, resp);
			pw.println("<center><p style='color:green'>User Registerd sucessfully</p></center>" );
			dis.include(req, resp);
			

		} else {
			RequestDispatcher dis = req.getRequestDispatcher("Register.html");

			dis1.include(req, resp);
			pw.println("<center><p style='color:red'>User Registerd Failed</p></center>" );
			dis.include(req, resp);

		}
		 
//		req.getRequestDispatcher("Login.html").include(req, resp);

	
		
		
	}
}
