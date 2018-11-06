package com.ruicaiedu.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {
	private static Connection connection;
	final static String CLASSNAME="com.mysql.jdbc.Driver";
	final static String URL="jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf8";
	final static String USER="root";
	final static String PASSWORD="1234";
	public static Connection getConnection() {
	try {
			Class.forName(CLASSNAME);
			connection=DriverManager.getConnection(URL, USER,PASSWORD );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(){
		try {
			if(!connection.isClosed()){
			connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	
	
}
