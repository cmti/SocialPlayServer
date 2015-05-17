package com.peets.socialplay.server.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.linkedin.data.template.StringArray;
import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.DaySchedule;
import com.peets.socialplay.server.DayScheduleArray;
import com.peets.socialplay.server.Event;
import com.peets.socialplay.server.IdentityType;
import com.peets.socialplay.server.ParentingComment;
import com.peets.socialplay.server.ParentingTip;
import com.peets.socialplay.server.ParentingTipId;
import com.peets.socialplay.server.Settings;
import com.peets.socialplay.server.SocialPlayContext;
import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.db.SocialPlayDB;

public class SocialPlayDBImpl implements SocialPlayDB {

	private Connection conn;
	private final String SELECT_LAST_ID = "SELECT LAST_INSERT_ID()";
	private static final int TOTAL_TIPS = 48;
	private static Random random = new Random();

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

		String verification = null;
		try {
			verification = SymmetricEncryptionUtility.encrypt(userName + ":"
					+ iType + ":" + identity);
		} catch (Exception e) {
			System.out.println("SymmetricEncryptionUtility exception: "
					+ e.getMessage());
			return null;
		}

		Long accountId = getAccountIdFromHash(verification);	// already registered, just return the accountId
		if (accountId == null) {
			try {
				conn.setAutoCommit(false);
				updateUser = conn.prepareStatement(updateString);

				updateUser.setString(1, verification);
				updateUser
						.setString(2, DBUtilities.identityTypeToString(iType));
				updateUser.setString(3, activated ? "y" : (iType == IdentityType.FB ? "y" : "n"));
				updateUser.setString(4, userName);
				updateUser.setString(5, identity);
				updateUser.executeUpdate();
				conn.commit();

				accountId = getAccountIdFromHash(verification);
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
		}

		return accountId;
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

		String insertString = "insert into chat_invitation (invitor_id, invitee_id, room_id, started, invite_time) values (?, ?, ?, ?, utc_timestamp())";
		String updateString = "update chat_invitation set room_id = ?, started = ?, invite_time = utc_timestamp() where invitor_id = ? and invitee_id = ?";
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
		SocialPlayContext context = getInviteToChatRecord(invitorAccount,
				inviteeAccount);

		if (context != null && context.hasChatRoomId()) {
			return true;
		}

		return false;
	}

	/**
	 * method to retrieve a previous chat invitation record from the specified
	 * (invitor, invitee) pair
	 * 
	 * @param invitorAccount
	 * @param inviteeAccount
	 * @return
	 */
	private SocialPlayContext getInviteToChatRecord(long invitorAccount,
			long inviteeAccount) {
		PreparedStatement selectUser = null;

		String selectString = "select room_id, started from chat_invitation where invitor_id = ? and invitee_id = ?";

		SocialPlayContext context = new SocialPlayContext();
		try {
			selectUser = conn.prepareStatement(selectString);

			selectUser.setLong(1, invitorAccount);
			selectUser.setLong(2, inviteeAccount);
			ResultSet rs = selectUser.executeQuery();
			while (rs.next()) {
				context.setChatRoomId(rs.getString(1));
				context.setStarted(DBUtilities.toBoolean(rs.getString(2)
						.charAt(0)));

				return context;
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

		return context;
	}

	/**
	 * check whether the participant joins the specified chat room
	 */
	@Override
	public boolean findParticipantJoined(long invitorAccount,
			long inviteeAccount, String roomId) {
		SocialPlayContext context = getInviteToChatRecord(invitorAccount,
				inviteeAccount);

		if (context != null && context.hasStarted() && context.isStarted()) {
			return true;
		}

		return false;
	}

	/**
	 * find whether there's existing record that matches (invitorAccount,
	 * inviteeAccount, roomId)
	 * 
	 * @param invitorAccount
	 * @param inviteeAccount
	 * @param roomId
	 * @return
	 */
	private boolean hasRecord(long invitorAccount, long inviteeAccount,
			String roomId) {
		SocialPlayContext context = getInviteToChatRecord(invitorAccount,
				inviteeAccount);

		if (context != null && context.hasChatRoomId()
				&& context.getChatRoomId().equalsIgnoreCase(roomId)) {
			return true;
		}

		return false;
	}

	/**
	 * update the participant join status
	 */
	@Override
	public boolean updateParticipantJoined(long invitorAccount,
			long inviteeAccount, String roomId, Boolean joined) {
		if (hasRecord(invitorAccount, inviteeAccount, roomId)) {
			PreparedStatement updateUser = null;

			String updateString = "update chat_invitation set room_id = ?, started = ? where invitor_id = ? and invitee_id = ?";

			try {
				conn.setAutoCommit(false);
				updateUser = conn.prepareStatement(updateString);

				updateUser.setString(1, roomId);
				updateUser.setString(2, joined ? "y" : "n");
				updateUser.setLong(3, invitorAccount);
				updateUser.setLong(4, inviteeAccount);
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
		}

		return false;
	}

	/**
	 * find out if there's any incoming invitation for the invitee
	 */
	@Override
	public SocialPlayContext findIncomingInvitation(long inviteeAccount) {
		PreparedStatement selectUser = null;

		// only select the incoming connection that is within 2 minutes
		String selectString = "select u.user_name, c.room_id, c.started, c.invite_time, u.user_id from users u, chat_invitation c where u.user_id = c.invitor_id and c.invitee_id= ? and c.started = ? and utc_timestamp() - c.invite_time < 200 order by c.invite_time desc limit 1";

		SocialPlayContext context = new SocialPlayContext();

		try {
			selectUser = conn.prepareStatement(selectString);

			selectUser.setLong(1, inviteeAccount);
			selectUser.setString(2, "n");
			ResultSet rs = selectUser.executeQuery();
			while (rs.next()) {
				context.setChatRoomId(rs.getString(2));
				context.setStarted(DBUtilities.toBoolean(rs.getString(3)
						.charAt(0)));
				context.setInitator(rs.getString(1));
				context.setInitatorId(rs.getLong(5));
				context.setParticipantId(inviteeAccount);

				return context;
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

		return context;
	}

	@Override
	public Account[] findOnlineFriends(long accountId) {
		PreparedStatement selectUser = null;

		String selectString = "select u.user_name, f.invitee_id, u.lastaccesstime from users u, friends f where u.user_id = f.invitee_id and f.invitor_id= ?";

		List<Account> accounts = new ArrayList<Account>();

		try {
			selectUser = conn.prepareStatement(selectString);

			selectUser.setLong(1, accountId);
			ResultSet rs = selectUser.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getLong(2));
				account.setName(rs.getString(1));
				accounts.add(account);
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
		return accounts.toArray(new Account[0]);
	}

	@Override
	public Long insertEvent(Event event) {
		PreparedStatement insertUser = null;

		String insertString = "insert into events (user_id, event_type, timestamp, duration, eventdetails) values (?, ?, utc_timestamp(), ?, ?)";

		try {
			conn.setAutoCommit(false);
			insertUser = conn.prepareStatement(insertString);

			insertUser.setLong(1, event.getUserId());
			insertUser.setString(2,
					DBUtilities.eventTypeToString(event.getEventType()));
			insertUser.setInt(3, event.hasDuration() ? event.getDuration() : 0);
			insertUser.setString(4, event.getDetails());
			insertUser.executeUpdate();
			conn.commit();
			
			PreparedStatement selectLastId = conn.prepareStatement(SELECT_LAST_ID);
			ResultSet rs = selectLastId.executeQuery();
			while(rs.next())
			{
				Long eventId = rs.getLong(1);
				return eventId;
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (insertUser != null) {
					insertUser.close();
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
	public ParentingTip getTip(ParentingTipId tipId, Long accountId)
	{
		PreparedStatement selectUser = null;

		String selectString = "select content from parenting_tips where resource_id = ? and tip_id = ?";

		try {
			selectUser = conn.prepareStatement(selectString);

			selectUser.setInt(1, tipId.getTipResourceId());
			selectUser.setInt(2, tipId.getTipSequenceId());
			ResultSet rs = selectUser.executeQuery();
			while (rs.next()) {
				ParentingTip tip = new ParentingTip();
				tip.setTipDetail(rs.getString(1)).setTipId(tipId);
				insertTipHistory(tipId, accountId);
				return tip;
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
		
		return new ParentingTip();
	}

	@Override
	public ParentingTip getRandomTip() {
		PreparedStatement selectUser = null;

		String selectString = "select content from parenting_tips where resource_id = 1 and tip_id = ?";

		try {
			selectUser = conn.prepareStatement(selectString);

			int tipId = random.nextInt(TOTAL_TIPS) + 1;
			selectUser.setInt(1, tipId);
			ResultSet rs = selectUser.executeQuery();
			while (rs.next()) {
				ParentingTip tip = new ParentingTip();
				tip.setTipDetail(rs.getString(1)).setTipId(new ParentingTipId().setTipResourceId(1).setTipSequenceId(tipId));
				return tip;
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

		return new ParentingTip();
	}

	private boolean insertTipHistory(ParentingTipId tipId, Long accountId)
	{
		PreparedStatement insertUser = null;

		String insertString = "insert into parenting_tips_history (user_id, timestamp, resource_id, tip_id) values (?, utc_timestamp(), ?, ?)";

		try {
			conn.setAutoCommit(false);
			insertUser = conn.prepareStatement(insertString);

			insertUser.setLong(1, accountId);
			insertUser.setInt(2, tipId.getTipResourceId());
			insertUser.setInt(3, tipId.getTipSequenceId());
			insertUser.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (insertUser != null) {
					insertUser.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
		return false;
	}
	
	@Override
	public ParentingComment[] getComments(ParentingTipId tipId, Long timestamp,
			Integer count, Boolean chronicleOrder, Long lastTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long createComment(ParentingComment entry) {
		PreparedStatement insertUser = null;

		String insertString = "insert into parenting_tips_comments (user_id, timestamp, resource_id, tip_id, comments) values (?, utc_timestamp(), ?, ?, ?)";

		try {
			conn.setAutoCommit(false);
			insertUser = conn.prepareStatement(insertString);

			insertUser.setLong(1, entry.getUserId());
			insertUser.setInt(2, entry.hasTipId() ? (entry.getTipId().hasTipResourceId() ? entry.getTipId().getTipResourceId() : 0) : 0);
			insertUser.setInt(3, entry.hasTipId() ? (entry.getTipId().hasTipSequenceId() ? entry.getTipId().getTipSequenceId() : 0) : 0);
			insertUser.setString(4, entry.getCommentDetail());
			insertUser.executeUpdate();
			conn.commit();
			
			PreparedStatement selectLastId = conn.prepareStatement(SELECT_LAST_ID);
			ResultSet rs = selectLastId.executeQuery();
			while(rs.next())
			{
				Long commentId = rs.getLong(1);
				return commentId;
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (insertUser != null) {
					insertUser.close();
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
	public Boolean registerToGCM(long accountId, String registrationId) {
		PreparedStatement insertUser = null;

		String insertString = "insert into gcm_registration values (?, ?, utc_timestamp())";

		try {
			conn.setAutoCommit(false);
			insertUser = conn.prepareStatement(insertString);

			insertUser.setLong(1, accountId);
			insertUser.setString(2, registrationId);
			insertUser.executeUpdate();
			conn.commit();

			return true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (insertUser != null) {
					insertUser.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return false;
	}

	@Override
	public Settings getSettings(long accountId) {
		PreparedStatement selectSettings = null;

		String selectString = "select day, schedule from parenting_notification_schedule where user_id = ?";

		try {
			selectSettings = conn.prepareStatement(selectString);

			selectSettings.setLong(1, accountId);
			ResultSet rs = selectSettings.executeQuery();
			while (rs.next()) {
				Settings settings = new Settings();
				settings.setUserId(accountId);
				DaySchedule daySchedule = new DaySchedule();
				daySchedule.setDay(DBUtilities.numberToDay(rs.getShort(1)));
				StringArray stringArray = new StringArray(1);
				stringArray.add(rs.getTime(2).toString());
				daySchedule.setSchedules(stringArray);
				DayScheduleArray dayScheduleArray= new DayScheduleArray(1);
				dayScheduleArray.add(daySchedule);
				settings.setSchedules(dayScheduleArray);

				return settings;
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (selectSettings != null) {
					selectSettings.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}

		return new Settings();
	}

	@Override
	public boolean createSettings(Settings entity) {
		PreparedStatement insertSettings = null;

		String insertString = "insert into parenting_notification_schedule (user_id, day, schedule) values (?, ?, ?)";

		try {
			conn.setAutoCommit(false);
			insertSettings = conn.prepareStatement(insertString);
			DayScheduleArray dayScheduleArray = entity.getSchedules();
			DaySchedule[] daySchedules = (DaySchedule[]) dayScheduleArray.toArray(new DaySchedule[dayScheduleArray.size()]);

			insertSettings.setLong(1, entity.getUserId());
			insertSettings.setShort(2, DBUtilities.dayToNumber(daySchedules[0].getDay()));
			insertSettings.setTime(3, DBUtilities.stringToTime(daySchedules[0].getSchedules().get(0)));
			insertSettings.executeUpdate();
			conn.commit();

			return true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				conn.setAutoCommit(true);
				if (insertSettings != null) {
					insertSettings.close();
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
