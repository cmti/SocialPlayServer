package com.peets.socialplay.server.db;

import java.util.List;
import java.util.Set;

import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.IdentityType;

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
}