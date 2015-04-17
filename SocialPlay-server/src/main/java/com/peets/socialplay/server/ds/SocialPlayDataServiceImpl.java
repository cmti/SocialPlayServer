package com.peets.socialplay.server.ds;

import com.peets.socialplay.server.db.SocialPlayDB;
import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.db.mysql.SocialPlayDBImpl;

public class SocialPlayDataServiceImpl implements SocialPlayDataService{

	private String dbUrl;
	private String dbName;
	private String userName;
	private String password;
	private SocialPlayDB db;
	
	public SocialPlayDataServiceImpl(String url, String name, String uName, String pwd)
	{
		this.dbName = name;
		this.dbUrl = url;
		this.password = pwd;
		this.userName = uName;
		
		this.db = new SocialPlayDBImpl(dbUrl, dbName, userName, password);
	}
	
	@Override
	public Long getCurrentId() {
		
		return db.getCurrentId();
	}

	@Override
	public Long getAccountIdFromHash(String accountCode) {

		return db.getAccountIdFromHash(accountCode);
	}

	@Override
	public ActivationRecord getActivationRecord(long accountId) {
		
		return db.getActivationRecord(accountId);
	}

	@Override
	public boolean updateActivationRecord(long accountId,
			ActivationRecord activationRecord) {
		
		return db.updateActivationRecord(accountId, activationRecord);
	}

	@Override
	public Long insertAccount(Account account) {
		return db.insertAccountRecord(account.getIdentity().getIdentityType(), account.getName(), account.getIdentity().getIdentityStr(), false);
	}

	@Override
	public boolean invite(long invitorAccount, long inviteeAccount) {
		return db.invite(invitorAccount, inviteeAccount);
	}

	@Override
	public boolean keepLive(long accountId)
	{
		return db.keepLive(accountId);
	}

}
