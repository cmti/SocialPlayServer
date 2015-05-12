package com.peets.socialplay.server.db;

import java.util.List;
import java.util.Set;

import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.Event;
import com.peets.socialplay.server.IdentityType;
import com.peets.socialplay.server.ParentingComment;
import com.peets.socialplay.server.ParentingTip;
import com.peets.socialplay.server.ParentingTipId;
import com.peets.socialplay.server.Settings;
import com.peets.socialplay.server.SocialPlayContext;
import com.peets.socialplay.server.Account;

// interface for the SocialPlay Database access
public interface SocialPlayDB {
	public Long getCurrentId();
	public Long insertAccountRecord(IdentityType iType, String userName, String identity, boolean activated);
	public Long getAccountIdFromHash(String accountCode);
	public ActivationRecord getActivationRecord(long accountId);
	public boolean updateActivationRecord(long accountId, ActivationRecord activationRecord);
	public boolean invite(long invitorAccount, long inviteeAccount);
	public boolean keepLive(long accountId);
	public boolean inviteToChat(long invitorAccount, long inviteeAccount, String roomId);
	public boolean findParticipantJoined(long invitorAccount, long inviteeAccount, String roomId);
	public boolean updateParticipantJoined(long invitorAccount, long inviteeAccount, String roomId, Boolean joined);
	public SocialPlayContext findIncomingInvitation(long inviteeAccount);
	public Account[] findOnlineFriends(long accountId);
	public Long insertEvent(Event event);
	public ParentingTip getTip(ParentingTipId tipId, Long accountId);
	public ParentingComment[] getComments(ParentingTipId tipId, Long timestamp, Integer count, Boolean chronicleOrder, Long lastTimestamp);
	public Long createComment(ParentingComment entry);
	public Boolean registerToGCM(long accountId, String registrationId);
	public Settings getSettings(long accountId);
	public boolean createSettings(Settings entity);
}