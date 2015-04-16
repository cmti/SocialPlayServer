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
	
	private static SocialPlayDataService dataService = null;
	
	/**
	 * get the activation record by a compound key
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
		
		Long accountId = ServerUtils.initService(dataService).getAccountIdFromHash(verification);
		if (accountId != null) {

			ActivationRecord activationRecord = ServerUtils.initService(dataService)
					.getActivationRecord(accountId);

			if (regType.equalsIgnoreCase(activationRecord.getRegType()
					.toString())
					&& activationRecord.getAccount().equals(account)
					&& activationRecord.getVerification().equals(verification)) {
				activationRecord.setActivated(true);
				
				boolean result = ServerUtils.initService(dataService).updateActivationRecord(accountId, activationRecord);
				
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
