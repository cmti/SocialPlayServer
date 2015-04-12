package com.peets.socialplay.server.db;

import java.util.List;
import java.util.Set;

import com.peets.socialplay.server.ActivationRecord;

// interface for the Message Database access
public interface SocialPlayDB {
	public Long getCurrentId();
	public Long getAccountIdFromHash(long accountCode);
	public ActivationRecord getActivationRecord(long accountId);
	public boolean updateActivationRecord(long accountId, ActivationRecord activationRecord);
}