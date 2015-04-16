package com.peets.socialplay.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import com.linkedin.restli.common.CompoundKey;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.ResourceLevel;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.Action;
import com.linkedin.restli.server.annotations.ActionParam;
import com.linkedin.restli.server.annotations.Finder;
import com.linkedin.restli.server.annotations.Key;
import com.linkedin.restli.server.annotations.Optional;
import com.linkedin.restli.server.annotations.QueryParam;
import com.linkedin.restli.server.annotations.RestLiAssociation;
import com.linkedin.restli.server.resources.AssociationResourceTemplate;
import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.ds.SocialPlayDataService;
import com.peets.socialplay.server.ds.SocialPlayDataServiceImpl;

@RestLiAssociation(name = "activation", namespace = "com.peets.socialplay.server", assocKeys = {
		@Key(name = "regType", type = String.class),
		@Key(name = "account", type = Long.class),
		@Key(name = "verification", type = String.class) })

public class ActivationResource extends AssociationResourceTemplate<ActivationRecord>
{
	Logger _log = LoggerFactory.getLogger(ActivationResource.class);
	
	private static String dbName = "socialplay";
	private static String dbUrl = "localhost";
	private static String userName = "socialplay";
	private static String password = "socialplay";
	private SocialPlayDataService dataService = null;
	
	private SocialPlayDataService initService()
	{
		if(dataService == null)
		{
			dataService = new SocialPlayDataServiceImpl(dbUrl, dbName, userName, password);
		}
		
		return dataService;
	}
	
	/**
	 * get a list of Feeds by providing a compound key, consisting of a regType, and a sequence number
	 * any Feeds from the same group chat with a sequence number no less than the requested sequence number
	 * will be returned
	 * @param key: the compound key used to query the Feeds
	 * @return
	 */
	@Override
	public ActivationRecord get(CompoundKey key) {
		
		String regType = key.getPartAsString("regType");
		
		if(regType == null || ServerUtils.isValidType(regType) == null)
		{
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Invalid regType!");			
		}
		
		Long account = key.getPartAsLong("account");		
		
		if(account == null)
		{
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Invalid account!");			
		}
		
		String verification = key.getPartAsString("verification");
		if(verification == null)
		{
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Invalid verification!");			
		}
		
		Long accountId = initService().getAccountIdFromHash(verification);
		if (accountId != null) {

			ActivationRecord activationRecord = initService()
					.getActivationRecord(accountId);

			if (regType.equalsIgnoreCase(activationRecord.getRegType()
					.toString())
					&& activationRecord.getAccount().equals(account)
					&& activationRecord.getVerification().equals(verification)) {
				activationRecord.setActivated(true);
				
				boolean result = initService().updateActivationRecord(accountId, activationRecord);
				
				if(!result)
				{
					throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR,
							"Failed to activate!");			
				}
				return activationRecord;
			}
		}
		return new ActivationRecord();
	}

}
