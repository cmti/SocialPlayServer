package com.peets.socialplay.server.impl;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

import com.peets.socialplay.server.Identity;
import com.peets.socialplay.server.IdentityType;
import com.peets.socialplay.server.ActivationRecord;
import com.peets.socialplay.server.ds.SocialPlayDataService;
import com.peets.socialplay.server.ds.SocialPlayDataServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerUtils {

	public static String SEPERATOR = ":";

	private static String dbName = "socialplay";
	private static String dbUrl = "localhost";
	private static String userName = "socialplay";
	private static String password = "socialplay";
	private SocialPlayDataService dataService = null;
	
	/**
	 * lazy initialization
	 * @param ds
	 * @return
	 */
	public static SocialPlayDataService initService(SocialPlayDataService ds)
	{
		if(ds == null){
			ds = new SocialPlayDataServiceImpl(dbUrl, dbName, userName, password);;
		}
		
		return ds;
	}
	
	/**
	 * utility to verify the validity of a string presentation of an
	 * IdentityType
	 * 
	 * @param s
	 * @return
	 */
	public static IdentityType isValidType(String s) {
		for (IdentityType at : IdentityType.values()) {
			if (at.name().equalsIgnoreCase(s))
				return at;
		}

		return null;
	}

	/**
	 * utility to verify the validity of a string presentation of an Identity
	 * 
	 * @param s
	 * @return
	 */
	public static Identity isValidIdentity(String s) {
		// expect the format as "TYPE:IDENTITY-STRING" such as
		// "EMAIL:xxx@example.com"

		String[] subs = s.toLowerCase().split(SEPERATOR);
		if (subs == null || subs.length != 2) {
			return null;
		}
		IdentityType it = isValidType(subs[0]);
		if (it == null) {
			return null;
		}

		return new Identity().setIdentityType(it).setIdentityStr(subs[1]);
	}
	
	/**
	 * utility to form query string from an activation record
	 * @param activationRecord
	 * @return
	 */
	public static String formQueryStringFromActivationRecord(
			ActivationRecord activationRecord) {
		if(activationRecord == null)
			return null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("account=");
		sb.append(activationRecord.getAccount());
		sb.append('&');
		sb.append("verification=");
		sb.append(activationRecord.getVerification());
		sb.append('&');
		sb.append("regType=");
		sb.append(activationRecord.getRegType());
//		sb.append('&');
//		sb.append("activated=");
//		sb.append(activationRecord.isActivated());
		
		System.out.println("QueryParams: " + sb.toString());
		return sb.toString();
	}
}
