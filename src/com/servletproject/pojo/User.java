package com.servletproject.pojo;

public class User {
	
		private String username;
		private String password;
		private String name;
		private String date;
		
		public User(){
			
		}
		
		public User(String username, String password, String name, String date) {
			super();
			this.username = username;
			this.password = password;
			this.name = name;
			this.date = date;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		
		@Override
		public String toString() {
			return "User [username=" + username + ", password=" + password + ", name=" + name + ", date=" + date + "]";
		}
	
}
