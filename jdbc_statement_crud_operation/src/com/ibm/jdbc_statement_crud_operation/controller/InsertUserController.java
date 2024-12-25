package com.ibm.jdbc_statement_crud_operation.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUserController {
	
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
			
			String insertUserQuery=  "insert into user(id,name,dob,phone,email) values(104,'Animesh','2001-05-15',6907595654,'ani@gmail.com')";
			
			int a= statement.executeUpdate(insertUserQuery);  // method returns no of rows affected !!!
			
			System.out.println(a);
			
			if(a>0)
			{
				System.out.println("Data stored...");
			}
			else
			{
				System.out.println("Data not stored");
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
