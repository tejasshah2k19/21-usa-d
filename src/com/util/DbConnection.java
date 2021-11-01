package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {
		Connection con = null; 
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/javalearn";
		String userName = "root";
		String password = "root";

		try {
			// load driver
			Class.forName(driver); // type 4 driver --> skip

			con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("Db not connected");
			} else {
				System.out.println("Db Connected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con; 
	}

	public static void main(String[] args) {

	}
}
