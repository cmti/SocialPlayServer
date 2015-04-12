package com.peets.socialplay.server.ds;

import com.peets.socialplay.server.ActivationRecord;

public interface SocialPlayDataService {
	public Long getCurrentId();
	public Long getAccountIdFromHash(long accountCode);
	public ActivationRecord getActivationRecord(long accountId);
	public boolean updateActivationRecord(long accountId, ActivationRecord activationRecord);
}
