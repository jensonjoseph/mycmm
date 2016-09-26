package com.jensonjo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectManager {
	private static Connection con = null;

	private ConnectManager() {
		// to defeat instantiation
	}

	public static Connection getConnection() {
		if (con == null) {
			try {
				String DB_server = "localhost", DB_port = "3306", DB_name = "oakland_is", DB_user = "root", DB_password = "root";
				String url = "jdbc:mysql://" + DB_server + ":" + DB_port + "/" + DB_name;
				String userId = DB_user;
				String password = DB_password;
				//String url = "jdbc:mysql://localhost:3306/";
				//String dbName = "oakland_is?autoReconnect=true&useSSL=false";
				//String driver = "com.mysql.jdbc.Driver";
				//String userName = "root";
				//String password = "root";

				System.out.println("Establishing database connection..");
				String className = "com.mysql.jdbc.Driver";// "com.mysql.jdbc.Driver"
				Class.forName(className);
				con = DriverManager.getConnection(url, userId, password);
				System.out.println("Connection established");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

}
