package com.peets.socialplay.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;
import java.util.List;
import java.util.Date;

import com.linkedin.data.template.LongArray;
import com.linkedin.data.template.StringArray;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.ResourceLevel;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.Action;
import com.linkedin.restli.server.annotations.ActionParam;
import com.linkedin.restli.server.annotations.Optional;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.Identity;
import com.peets.socialplay.server.IdentityType;
import com.peets.socialplay.server.ds.SocialPlayDataService;
import com.peets.socialplay.server.utils.aws.AwsEmailClient;
import com.peets.socialplay.server.utils.twilio.TwilioClient;

@RestLiCollection(name = "registration", namespace = "com.peets.socialplay.server")
public class RegistrationResource extends
		CollectionResourceTemplate<String, Account> {
	Logger _log = LoggerFactory.getLogger(RegistrationResource.class);

	public static String ACTIVATION_URL_PREFIX = "http://localhost:8080/SocialPlay-server/activation/";
	static final String ACTIVATION_SUBJECT = "Please activate!";

	private static SocialPlayDataService dataService = null;

	/**
	 * get the account information that is associated with an identity
	 * 
	 * @param identityStr
	 * @return
	 */
	@Override
	public Account get(String identityStr) {
		if (identityStr == null || identityStr.length() == 0) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Identity is not acceptable in request: can't be empty or null");
		}

		Identity identity = ServerUtils.isValidIdentity(identityStr);
		if (identity == null) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Identity is malformed in request");
		}

		Long accountId = ServerUtils.initService(dataService)
				.getAccountIdFromHash(identityStr);
		if (accountId == null) {
			return new Account().setIdentity(identity).setAccountId(-2L);
		}

		return new Account().setIdentity(identity).setAccountId(accountId);
	}

	/**
	 * create an account
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public CreateResponse create(Account entity) {
		if (entity.hasAccountId()) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Account ID is not acceptable in request");
		}

		if (!entity.hasIdentity() || !entity.getIdentity().hasIdentityStr()
				|| !entity.getIdentity().hasIdentityType()) {
			throw new RestLiServiceException(
					HttpStatus.S_400_BAD_REQUEST,
					"Identity is not acceptable in request: identity has to have both type and a value");
		}

		if (!entity.hasName()) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Account name must present in request");
		}
		Long newId = ServerUtils.initService(dataService).insertAccount(entity);
		if (newId == null) {
			System.out.println("Failed to provision account: "
					+ entity.getIdentity());
			throw new RestLiServiceException(
					HttpStatus.S_500_INTERNAL_SERVER_ERROR,
					"Failed to provision account!");
		}

		sendActivationNotification(entity.getIdentity(), newId);

		// grant it the account ID
		entity.setAccountId(newId);

		System.out.println("newId: " + newId);
		return new CreateResponse(newId);
	}

	/**
	 * Based on the user's identity type, send out activation url via SMS or
	 * email, respectively
	 * 
	 * @param identity
	 * @param accountId
	 */
	private void sendActivationNotification(Identity identity, long accountId) {
		// send a SMS to the registered phone
		if (identity.getIdentityType() == IdentityType.PHONE) {
			try {
				if (!TwilioClient.sendSMS(identity.getIdentityStr(),
						generateActivationMsg(accountId))) {
					throw new RestLiServiceException(
							HttpStatus.S_500_INTERNAL_SERVER_ERROR,
							"failed to send activation URL to user via SMS!");
				}
			} catch (IOException ioex) {
				throw new RestLiServiceException(
						HttpStatus.S_500_INTERNAL_SERVER_ERROR,
						"failed to send activation URL to user via SMS! Error: "
								+ ioex.getMessage());
			}
		} else if (identity.getIdentityType() == IdentityType.EMAIL) {
			try {
				if (!AwsEmailClient.sendEmail(identity.getIdentityStr(),
						ACTIVATION_SUBJECT, generateActivationMsg(accountId))) {

				}
			} catch (IOException ioex) {
				throw new RestLiServiceException(
						HttpStatus.S_500_INTERNAL_SERVER_ERROR,
						"failed to send activation URL to user via email! Error: "
								+ ioex.getMessage());
			}
		} else if (identity.getIdentityType() == IdentityType.FB) {
			// nothing to do, as FB login already takes care of it
			System.out.println("FB registration for accountId: " + accountId);
		}
	}

	/**
	 * utility to generate activation message
	 * @param accountId
	 * @return
	 * @throws IOException
	 */
	private String generateActivationMsg(long accountId) throws IOException {
		return "Please access " + generateActivationUrl(accountId)
				+ " to activate!";
	}

	/**
	 * generate the associated activation url for a newly registered user
	 * 
	 * @param accountId
	 * @return
	 */
	private String generateActivationUrl(long accountId) throws IOException {
		ActivationRecord activationRecord = ServerUtils
				.initService(dataService).getActivationRecord(accountId);
		if (activationRecord == null) {
			throw new IOException(
					"No corresponding activation record found for account: "
							+ accountId);
		}

		try {
			return ACTIVATION_URL_PREFIX
					+ ServerUtils
							.formQueryStringFromActivationRecord(activationRecord);
		} catch (Exception ex) {
			throw new IOException(
					"failed to generate query string from record. error: "
							+ ex.getMessage());
		}
	}

	/**
	 * add a friend by accountId
	 * @param invitorAccount
	 * @param inviteeAccount
	 * @return
	 */
	@Action(name = "invite", resourceLevel = ResourceLevel.COLLECTION)
	public Boolean invite(@ActionParam("invitor") Long invitorAccount,
			@ActionParam("invitee") Long inviteeAccount) {
		if (!accountExists(invitorAccount)) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Invalid invitorAccount: " + invitorAccount);
		}

		if (!accountExists(inviteeAccount)) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Invalid inviteeAccount: " + inviteeAccount);
		}

		return ServerUtils.initService(dataService).invite(invitorAccount,
				inviteeAccount);
	}

	/**
	 * action to retrieve an activation record associated with an accountId
	 * @param accountId
	 * @return
	 */
	@Action(name = "getActivationRecord", resourceLevel = ResourceLevel.COLLECTION)
	public ActivationRecord getActivationRecord(
			@ActionParam("accountId") Long accountId) {
		return ServerUtils.initService(dataService).getActivationRecord(
				accountId);
	}

	/**
	 * keep live from client
	 * @param accountId
	 * @return
	 */
	@Action(name = "keepLive", resourceLevel = ResourceLevel.COLLECTION)
	public Boolean keepLive(
			@ActionParam("accountId") Long accountId) {
		return ServerUtils.initService(dataService).keepLive(accountId);
	}
	
	/**
	 * utility to check whether an account exists by a specified accountId
	 * @param accountId
	 * @return
	 */
	private boolean accountExists(Long accountId) {
		ActivationRecord aRecord = ServerUtils.initService(dataService)
				.getActivationRecord(accountId);
		if (aRecord == null || !aRecord.hasAccount() || !aRecord.isActivated())
			return false;

		return true;
	}
}
