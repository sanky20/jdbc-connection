package com.ibm.jdbc_statement_crud_operation.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DisplaySingleUserController {
	
	public static void main(String[] args) {
		
		Connection connection= null;
		
		// step1: register the driver
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			
			// step2: create connection
			String url="jdbc:mysql://localhost:3306/jdbc-a5";
			String username="root";
			String password= "mypets@3";
			
			connection= DriverManager.getConnection(url, username, password);
			
			// step3: create statement
			
			Statement statement= connection.createStatement();
			
			// step4: execute query
			
			String displaySingleData= "select * from user where id=102";
			
			ResultSet set= statement.executeQuery(displaySingleData);
			
			boolean b= set.next();
			
			if(b) {
				int id= set.getInt("id");
				String name= set.getString("name");
				Date dob= set.getDate("dob");
				long phone= set.getLong("phone");
				String email= set.getString("email");
				System.out.print(id+" "+name+" "+dob+" "+phone+" "+email+" \n");
				
			}else {
				
				System.out.println("given id is wrong ");
				
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		
		
		
		
		
		
	}

}
