package com.api.connection;

import java.sql.DriverManager;

public abstract class Connection {

	private final static String URL = "jdbc:mysql://localhost:3306/simple_schema";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static java.sql.Connection instance;
	
	private Connection() {}
	
	public static java.sql.Connection getConnection() {
		try {
			Class.forName(DRIVER);
			instance = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}
	
}
