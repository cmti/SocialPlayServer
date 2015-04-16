package com.peets.socialplay.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.linkedin.data.ByteString;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.ResourceLevel;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.Action;
import com.linkedin.restli.server.annotations.ActionParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.peets.socialplay.server.SocialPlayContext;

@RestLiCollection(name = "socialPlay", namespace = "com.peets.socialplay.server")
public class SocialPlayResource extends
		CollectionResourceTemplate<Long, SocialPlayContext> {
	Logger _log = LoggerFactory.getLogger(SocialPlayResource.class);
	private static Random _random = new Random();

	private static SocialPlayContext _context = null; 

	private static final String USER_AGENT = "Mozilla/5.0";
	private static String WEBRTC_URL = "https://apprtc.appspot.com";
	/**
	 * the Create method to create a new SocialPlayContext entry
	 * 
	 * @param entity
	 *            : the input SocialPlayContext
	 * @return
	 */
	@Override
	public CreateResponse create(SocialPlayContext entity) {
		System.out.println("received request!");
		if (!entity.hasChatRoomId()) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Chat Room ID must present in request");
		}

		if (!entity.hasStarted()) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Started field must present in request");
		}
		
		if(!entity.hasInitator())
			entity.setInitator("John");
		
		if(!entity.hasParticipant())
		{
			entity.setParticipant("David");
		}
		
		_context = new SocialPlayContext()
				.setChatRoomId(entity.getChatRoomId()).setTimestamp(new Date().getTime())
				.setInitator(entity.getInitator()).setParticipant(entity.getParticipant()).setStarted(entity.isStarted());

		_log.debug(entity.toString());
		System.out.println("Created: " + entity.toString());
		return new CreateResponse(entity.getTimestamp());
	}

	
	/**
	 * action to find a chat room
	 * @return
	 */
	@Action(name = "findChatRoom", resourceLevel = ResourceLevel.COLLECTION)
	public String findChatRoom() {
		try {
			String roomId = String.format("%09d", _random.nextInt(999999999));
			return roomId; //findChatRoomNumber();
		} catch (Exception ex) {
			throw new RestLiServiceException(
					HttpStatus.S_500_INTERNAL_SERVER_ERROR,
					"Can't find a chat room: " + ex.getMessage());
		}
	}
	
	/**
	 * retrieve SocialPlayContext by a specified contextId
	 */
	@Override
	public SocialPlayContext get(Long contextId)
	{
		SocialPlayContext result = new SocialPlayContext();
		if (contextId.longValue() == 1L) {
			if (_context != null && !_context.isStarted()) {
					result = _context;
			}
		} else if(contextId.longValue() == 2L){
			// indicate the participant also joined
			if(_context != null){
				_context.setStarted(true);
				result = _context;
			}
		}
		else {
			// initator joined but not yet the participant
			String roomId = String.format("%08d", contextId);
			_context = new SocialPlayContext().setChatRoomId(roomId).setStarted(false)
					.setTimestamp(new Date().getTime());
			
			result = _context;
		}
		
		return result;
	}
	
	/**
	 * get response from a http GET request to a specified url
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private String getResponse(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		String msg = con.getResponseMessage();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
		return response.toString();
	}
	
	/**
	 * find a chat room
	 * @return
	 * @throws Exception
	 */
	private String findChatRoomNumber() throws Exception {
		 
		String retValue = "";
		URL obj = new URL(WEBRTC_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		String msg = con.getResponseMessage();
		int responseCode = con.getResponseCode();
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		Pattern pattern = Pattern.compile(WEBRTC_URL + "/r/\\d+");
		Matcher matcher = null;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			response.append("\n");
			matcher = pattern.matcher(inputLine);
			if(matcher.find())
			{				
				String[] parts = matcher.group().toString().split("/");
				retValue = parts[parts.length - 1];
				Date dt = new Date();
				System.out.println(dt + " Found a match: " + retValue);
			}
		}
		in.close();
 
		return retValue;
	}

}
