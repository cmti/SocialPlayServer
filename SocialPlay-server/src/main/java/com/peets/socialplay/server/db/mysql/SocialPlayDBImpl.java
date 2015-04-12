package com.peets.socialplay.server.db.mysql;

import java.sql.Connection;

import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.db.SocialPlayDB;

public class SocialPlayDBImpl implements SocialPlayDB {

	private Connection conn;
	
	public SocialPlayDBImpl(String dbUrl, String dbName, String userName, String password)
	{
		this.conn = DBUtilities.getConnection(dbUrl, dbName, userName, password);
	}
	
	@Override
	public Long getCurrentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAccountIdFromHash(long accountCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActivationRecord getActivationRecord(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateActivationRecord(long accountId,
			ActivationRecord activationRecord) {
		// TODO Auto-generated method stub
		return false;
	}

}
