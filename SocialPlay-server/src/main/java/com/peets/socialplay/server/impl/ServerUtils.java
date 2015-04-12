package com.peets.socialplay.server.impl;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.*;
import java.util.SortedSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;

import com.peets.socialplay.server.IdentityType;
import com.peets.socialplay.server.ActivationRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerUtils {

	public static String SEPERATOR = ":";

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
	
	public static String formQueryStringFromActivationRecordWithReflection(
			ActivationRecord activationRecord) throws IllegalArgumentException,
			IllegalAccessException {
		Class aClass = activationRecord.getClass();
		Field[] declaredFields = aClass.getDeclaredFields();
		Map<String, String> attributeEntries = new HashMap<>();

		for (Field field : declaredFields) {
			attributeEntries.put(field.getName(),
					String.valueOf(field.get(activationRecord)));
		}

		SortedSet<String> sortedLog = new TreeSet<>(attributeEntries.keySet());

		StringBuilder sb = new StringBuilder();

		Iterator<String> it = sortedLog.iterator();
		while (it.hasNext()) {
			String key = it.next();
			sb.append(key);
			sb.append('=');
			sb.append(attributeEntries.get(key));
			if (it.hasNext())
				sb.append('&');
		}

		System.out.println(sb.toString());

		return sb.toString();
	}
}
