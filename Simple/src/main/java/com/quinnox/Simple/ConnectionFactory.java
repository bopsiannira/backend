package com.quinnox.Simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		String url = "jdbc:mysql://localhost:3306/demo1";
		String user = "root";
		String password = "Password@1";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	con = DriverManager.getConnection(url, user, password);
	
		return con;
	}

}
