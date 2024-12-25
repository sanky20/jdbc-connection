package com.ibm.jdbc_statement_crud_operation.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUserController {
	
    public static void main(String[] args) {
    	
    	Connection connection= null;
    	
		// step 1 : load\register driver class from driver software
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step2 : create connection with url, username, password
			String url= "jdbc:mysql://localhost:3306/jdbc-a5";
			String username="root";
			String password= "mypets@3";
			
			connection= DriverManager.getConnection(url,username,password);	
			System.out.println(connection);
			
			// step3: create Statement
			
			Statement statement= connection.createStatement();
			System.out.println(statement);
			
			// step 4: execute query
			
			String deleteUserQuery=  "delete from user where id=103";
			
			int a= statement.executeUpdate(deleteUserQuery);  // method returns no of rows affected !!!
			
			System.out.println(a);
			
			if(a>0)
			{
				System.out.println("Data deleted...");
			}
			else
			{
				System.out.println("Data not deleted...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
    	finally {
    		// step5: close the connection
    		try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
	}

}
