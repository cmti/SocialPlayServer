package com.peets.socialplay.server.ds;

import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.Event;
import com.peets.socialplay.server.ParentingComment;
import com.peets.socialplay.server.ParentingTip;
import com.peets.socialplay.server.ParentingTipId;
import com.peets.socialplay.server.SocialPlayContext;

public interface SocialPlayDataService {
	public Long getCurrentId();
	public Long getAccountIdFromHash(String accountCode);
	public ActivationRecord getActivationRecord(long accountId);
	public boolean updateActivationRecord(long accountId, ActivationRecord activationRecord);
	public Long insertAccount(Account account);
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
}
