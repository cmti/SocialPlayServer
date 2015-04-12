package com.peets.socialplay.server.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilities {
	private static Connection conn = null;

	public static Connection getConnection(String dbUrl, String dbName,
			String userName, String password) {

		if (conn == null) {
			try {
				String connString = "jdbc:mysql://" + dbUrl + "/" + dbName
						+ " ?user=" + userName + "&password=" + password;
				conn = DriverManager.getConnection(connString);
			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return conn;
	}
}