package com.peets.socialplay.server.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.db.SocialPlayDB;

public class SocialPlayDBImpl implements SocialPlayDB {

	private Connection conn;

	public SocialPlayDBImpl(String dbUrl, String dbName, String userName,
			String password) {
		this.conn = DBUtilities
				.getConnection(dbUrl, dbName, userName, password);
	}

	@Override
	public Long getCurrentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAccountIdFromHash(String accountCode) {
		PreparedStatement selectUser = null;

		String selectString = "select user_id from users where user_hash = ?";

		try {
			selectUser = conn.prepareStatement(selectString);

			selectUser.setString(1, accountCode);
			ResultSet rs = selectUser.executeQuery();
			while (rs.next()) {
				return rs.getLong("user_id");
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (selectUser != null) {
					selectUser.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return null;
	}

	@Override
	public ActivationRecord getActivationRecord(long accountId) {
		PreparedStatement selectUser = null;

		String selectString = "select user_id, user_hash, user_status, user_type from users where user_id = ?";

		try {
			selectUser = conn.prepareStatement(selectString);

			selectUser.setLong(1, accountId);
			ResultSet rs = selectUser.executeQuery();
			while (rs.next()) {
				ActivationRecord ar = new ActivationRecord();
				ar.setAccount(rs.getLong("user_id"));
				String verification = rs.getString("user_hash");
				ar.setVerification(verification);
				String regType = rs.getString("user_type");
				ar.setRegType(DBUtilities.toIdentityType(regType.charAt(0)));
				String status = rs.getString("user_status");
				ar.setActivated(DBUtilities.toBoolean(status.charAt(0)));
				return ar;
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (selectUser != null) {
					selectUser.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return null;
	}

	@Override
	public boolean updateActivationRecord(long accountId,
			ActivationRecord activationRecord) {
		PreparedStatement updateUser = null;

		String updateString = "update users set user_hash=?, user_status=? where user_id = ?";

		try {
			conn.setAutoCommit(false);
			updateUser = conn.prepareStatement(updateString);

			updateUser.setString(1, activationRecord.getVerification());
			updateUser.setString(2, activationRecord.isActivated() ? "y" : "n");
			updateUser.setLong(3, accountId);
			updateUser.executeUpdate();
			conn.commit();

			return true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (updateUser != null) {
					updateUser.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return false;
	}

}
