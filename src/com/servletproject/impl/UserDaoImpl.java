package com.servletproject.impl;


import static com.servletproject.utility.DatabaseConnection.establishConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servletproject.dao.UserDao;
import com.servletproject.pojo.User;

public class UserDaoImpl implements UserDao{

	  Connection con=null;
	    PreparedStatement pst=null;
	    ResultSet rs=null;
	@Override
	public boolean register(User user) {
		 con=establishConnection();
	        String query="insert into user(username,password,name,dob) values(?,?,?,?)";
	        try {
	            pst=con.prepareStatement(query);
	            pst.setString(1, user.getUsername());
	            pst.setString(2, user.getPassword());
	            pst.setString(3, user.getName());
	            pst.setString(4, user.getDate());
	            
	            int rowsAffected=pst.executeUpdate();
	            if(rowsAffected>0){
	                return true;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean login(String username, String password) {
		   con=establishConnection();
	        String query="select * from user where username=? and password=?";
	            
	        try {
	            pst=con.prepareStatement(query);
	            pst.setString(1, username);
	            pst.setString(2, password);
	            rs=pst.executeQuery();
	            if(rs.next()){
	                return true;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean updateProfile(User user) {
		con=establishConnection();
		 String query="update user set name=?,dob=? where username=?";
         
	        try {
	        pst=con.prepareStatement(query);
	            pst.setString(1, user.getName());
	            pst.setString(2, user.getDate());
	            pst.setString(3, user.getUsername());
	            
	            int rowsAffected=pst.executeUpdate();
	            if(rowsAffected>0){
	                return true;
	            }
	        } 
	        catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean changePassword(String username, String password) {
		 con=establishConnection();
			String query="update user set password=? where username=?";
			try {
				pst=con.prepareStatement(query);
				pst.setString(1, password);
				pst.setString(2, username);
				int rowsAffected=pst.executeUpdate();
				if(rowsAffected>0){
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return false;
	}

	@Override
	public User viewProfile(String username) {
		User user=null;
		con=establishConnection();
		String query="select * from user where username=?";
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, username);
			rs=pst.executeQuery();
			if(rs.next()){
				user=new User();
				user.setUsername(rs.getString(1));
				user.setName(rs.getString(3));
				user.setDate(rs.getString(4));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

}
