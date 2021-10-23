package com.zensar.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
private static String url="jdbc:mysql://localhost:3306/dbase";
private static String username="root";
private static String password="shah";
public static Connection getConnect()
{
	Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, username, password);
		//System.out.println(con);
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}

}
