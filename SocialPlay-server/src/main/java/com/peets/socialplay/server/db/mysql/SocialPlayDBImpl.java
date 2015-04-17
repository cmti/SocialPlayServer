package com.peets.socialplay.server.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.IdentityType;
import com.peets.socialplay.server.db.SocialPlayDB;

public class SocialPlayDBImpl implements SocialPlayDB {

	private Connection conn;

	public SocialPlayDBImpl(String dbUrl, String dbName, String userName,
			String password) {
		this.conn = DBUtilities
				.getConnection(dbUrl, dbName, userName, password);
	}

	/**
	 * retrieve the current value from sequence
	 */
	@Override
	public Long getCurrentId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * from a verification hash string to retrieve the associated accountId
	 */
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

	/**
	 * retrieve the activation record by specifying an accountId
	 */
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

	/**
	 * insert a new account record to DB
	 */
	@Override
	public Long insertAccountRecord(IdentityType iType, String userName,
			String identity, boolean activated) {
		PreparedStatement updateUser = null;

		String updateString = "insert into users (user_hash, user_type, user_status, user_name, identity, lastaccesstime) values (?, ?, ?, ?, ?, NOW())";

		try {
			conn.setAutoCommit(false);
			updateUser = conn.prepareStatement(updateString);

			String verification = null;
			try {
				verification = SymmetricEncryptionUtility.encrypt(userName
						+ ":" + iType + ":" + identity);
			} catch (Exception e) {
				System.out.println("SymmetricEncryptionUtility exception: "
						+ e.getMessage());
				return null;
			}
			updateUser.setString(1, verification);
			updateUser.setString(2, DBUtilities.identityTypeToString(iType));
			updateUser.setString(3, activated ? "y" : "n");
			updateUser.setString(4, userName);
			updateUser.setString(5, identity);
			updateUser.executeUpdate();
			conn.commit();

			return getAccountIdFromHash(verification);
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

		return null;
	}

	/**
	 * update an activation record
	 */
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

	/**
	 * add a new friend
	 */
	@Override
	public boolean invite(long invitorAccount, long inviteeAccount) {
		PreparedStatement insertFriend = null;

		String insertString = "insert into friends (invitor_id, invitee_id) values (?, ?)";

		try {
			conn.setAutoCommit(false);
			insertFriend = conn.prepareStatement(insertString);

			insertFriend.setLong(1, invitorAccount);
			insertFriend.setLong(2, inviteeAccount);
			insertFriend.executeUpdate();
			conn.commit();

			return true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (insertFriend != null) {
					insertFriend.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return false;
	}

	/**
	 * update timestamp for user to keep live from client
	 */
	@Override
	public boolean keepLive(long accountId) {
		PreparedStatement updateUser = null;

		String updateString = "update users set lastaccesstime=NOW() where user_id = ?";

		try {
			conn.setAutoCommit(false);
			updateUser = conn.prepareStatement(updateString);

			updateUser.setLong(1, accountId);
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

	/**
	 * one user invites another user to join a video chat room, specified by
	 * roomId
	 */
	@Override
	public boolean inviteToChat(long invitorAccount, long inviteeAccount,
			String roomId) {
		PreparedStatement insertFriend = null;

		String insertString = "insert into chat_invitation (invitor_id, invitee_id, room_id, started, invite_time) values (?, ?, ?, ?, NOW())";
		String updateString = "update chat_invitation set room_id = ?, started = ?, invite_time = NOW() where invitor_id = ? and invitee_id = ?)";
		try {
			conn.setAutoCommit(false);
			if (!hasPreviousInviteToChatRecord(invitorAccount, inviteeAccount)) {
				insertFriend = conn.prepareStatement(insertString);

				insertFriend.setLong(1, invitorAccount);
				insertFriend.setLong(2, inviteeAccount);
				insertFriend.setString(3, roomId);
				insertFriend.setString(4, "n");
			} else {
				insertFriend = conn.prepareStatement(updateString);
				insertFriend.setString(1, roomId);
				insertFriend.setString(2, "n");
				insertFriend.setLong(3, invitorAccount);
				insertFriend.setLong(4, inviteeAccount);
			}
			insertFriend.executeUpdate();
			conn.commit();

			return true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (insertFriend != null) {
					insertFriend.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return false;
	}

	/**
	 * method to find out whether there's a previous chat invitation record from
	 * the same (invitor, invitee) pair
	 * 
	 * @param invitorAccount
	 * @param inviteeAccount
	 * @return
	 */
	private boolean hasPreviousInviteToChatRecord(long invitorAccount,
			long inviteeAccount) {
		ResultSet rs = getInviteToChatRecord(invitorAccount, inviteeAccount);

		try {
			if (rs != null && rs.next())
				return true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return false;
	}

	/**
	 * method to retrieve a previous chat invitation record from
	 * the specified (invitor, invitee) pair
	 * 
	 * @param invitorAccount
	 * @param inviteeAccount
	 * @return
	 */
	private ResultSet getInviteToChatRecord(long invitorAccount,
			long inviteeAccount) {
		PreparedStatement selectUser = null;

		String selectString = "select room_id, started, invited_time from chat_invitation where invitor_id = ? and invitee_id = ?)";

		try {
			selectUser = conn.prepareStatement(selectString);

			selectUser.setLong(1, invitorAccount);
			selectUser.setLong(2, inviteeAccount);
			ResultSet rs = selectUser.executeQuery();
			return rs;
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
}
