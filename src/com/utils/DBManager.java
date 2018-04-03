package com.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {

	private static String user;
	private static String password;
	private static String url;

	static{

		Properties properties = new Properties();
		try {
			properties.load(DBManager.class.getClassLoader().getResourceAsStream("DBConfig.properties"));

			String driverName = (String) properties.get("DriverName");
			user = (String) properties.get("user");
			password = (String) properties.get("password");
			url = (String) properties.get("url");

			Class.forName(driverName);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}



	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
		}
		return null;
	}

	public static void close(Connection conn,Statement statement,ResultSet resultSet){
		
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
