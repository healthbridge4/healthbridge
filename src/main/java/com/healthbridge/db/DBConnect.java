package com.healthbridge.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con;
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/health_bridge","root","manager");
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}

}
