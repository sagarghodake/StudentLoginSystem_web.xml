package com.servletproject.dao;

import com.servletproject.pojo.User;

public interface UserDao {
	 public boolean register(User user);
	   public boolean login(String username,String password);
	   public boolean updateProfile(User user);
	   public boolean changePassword(String username,String password);
	   public User viewProfile(String username);
}	
	