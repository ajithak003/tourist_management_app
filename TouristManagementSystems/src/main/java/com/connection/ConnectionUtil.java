package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getDBConnect()
	{
Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"system","oracle");
			}
		catch (ClassNotFoundException e) 
		{
			
			e.getMessage();
			System.out.println("Driver Jar doesn't there");
			
		} catch (SQLException e) {
			
			e.getMessage();
			System.out.println("url or uasername or password may wrong");
		}
		return con;
	}

}
