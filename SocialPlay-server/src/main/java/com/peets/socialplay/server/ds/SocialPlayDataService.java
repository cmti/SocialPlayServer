package com.peets.socialplay.server.ds;

import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.ActivationRecord;

public interface SocialPlayDataService {
	public Long getCurrentId();
	public Long getAccountIdFromHash(String accountCode);
	public ActivationRecord getActivationRecord(long accountId);
	public boolean updateActivationRecord(long accountId, ActivationRecord activationRecord);
	public Long insertAccount(Account account);
	public boolean invite(long invitorAccount, long inviteeAccount);
	public boolean keepLive(long accountId);
	public boolean inviteToChat(long invitorAccount, long inviteeAccount, String roomId);
}
