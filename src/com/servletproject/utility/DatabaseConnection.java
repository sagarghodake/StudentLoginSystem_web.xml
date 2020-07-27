package com.servletproject.utility;
import java.sql.*;
import static com.servletproject.utility.DatabaseConnection.establishConnection;
public class DatabaseConnection {
    private static Connection con=null;
   public static Connection establishConnection(){
        if(con==null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletproject","root","");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return con;
    }
    public static void main(String args[]){
        System.out.println("Connection established sucessfully.."+establishConnection());
    }
   
}
