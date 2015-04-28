package com.peets.socialplay.server.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.peets.socialplay.server.EventType;
import com.peets.socialplay.server.IdentityType;

public class DBUtilities {
	private static Connection conn = null;
	private static int port = 3306;		// default port for mysql

	/**
	 * create a DB connection to mysql
	 * @param dbUrl
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return
	 */
	public static Connection getConnection(String dbUrl, String dbName,
			String userName, String password) {

		if (conn == null) {
			try {
				String connString = "jdbc:mysql://" + dbUrl + ":" + port + "/" + dbName + "?autoReconnect=true";
				conn = DriverManager.getConnection(connString, userName, password);
			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return conn;
	}
	
	/**
	 * utility to convert from DB column 'user_type' to IdentityType
	 * @param regType
	 * @return
	 */
	public static IdentityType toIdentityType(char regType)
	{
		switch (regType) {
		case 'p':
			return IdentityType.PHONE;
		case 'f':
			return IdentityType.FB;
		case 'e':
			return IdentityType.EMAIL;
		default:
			return IdentityType.$UNKNOWN;
		}
	}
	
	/**
	 * utility to convert from IdentityType to the corresponding value for the DB column 'user_type'
	 * @param iType
	 * @return
	 */
	public static String identityTypeToString(IdentityType iType)
	{
		switch (iType) {
		case PHONE:
			return "p";
		case FB:
			return "f";
		case EMAIL:
			return "e";
		default:
			return "u";
		}
	}
	
	/**
	 * utility to convert an EventType enum to a 2-letter string to be saved in DB
	 * @param eType
	 * @return
	 */
	public static String eventTypeToString(EventType eType)
	{
		switch(eType) {
		case LOGIN:
			return "LN";
		case REGISTRATION:
			return "RG";
		case LOGOUT:
			return "LO";
		case READING:
			return "RD";
		case REMOTEPLAY:
			return "RP";
		case PHYSICAL:
			return "PH";
		case TABLET:
			return "TB";
			default:
				return "UN";
		}
	}
	/**
	 * convert 'y', or 'n' to boolean
	 * @param c
	 * @return
	 */
	public static Boolean toBoolean(char c) {
		switch (c) {
		case 'y':
			return true;
		case 'n':
			return false;
		default:
			return null;
		}
	}
}