package com.servletproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.Http11AprProtocol;

import com.servletproject.impl.UserDaoImpl;
import com.servletproject.pojo.User;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User editUser=new User();
		PrintWriter pw=response.getWriter();
		UserDaoImpl userDao=new UserDaoImpl();
		HttpSession session=request.getSession();		
		String username=(String) session.getAttribute("username");
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		editUser.setUsername(username);
		editUser.setName(name);
		editUser.setDate(dob);
		if(userDao.updateProfile(editUser)){
			pw.println("Edit Profile Sucessful");
		}else{
			pw.println("Edit profile unsucessful");
		}
		RequestDispatcher dis = request.getRequestDispatcher("viewServlet?op=view");

		dis.include(request, response);

		
	}

}
