package com.peets.socialplay.server;

import com.peets.socialplay.server.SocialPlayContext;
import com.peets.socialplay.server.SocialPlayRequestBuilders;
import com.linkedin.r2.transport.common.Client;
import com.linkedin.r2.transport.common.bridge.client.TransportClientAdapter;
import com.linkedin.r2.transport.http.client.HttpClientFactory;
import com.linkedin.restli.client.CreateRequest;
import com.linkedin.restli.client.Response;
import com.linkedin.restli.client.ResponseFuture;
import com.linkedin.restli.client.RestClient;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.common.IdResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Locale;

import org.json.JSONObject;

import java.util.Collections;
public class SocialPlayClient {
	private static final int BLOCK_SIZE = 16*1024;
	private static final String CREATE_URL = "http://localhost:8080/SocialPlay-server/";
	private static final String BASE_URL = CREATE_URL + "socialPlay" ;
	private static final String GET_URL = BASE_URL + "/1";
	private static final String UPDATE_URL = BASE_URL + "/2";
	private static final String POST_URL = BASE_URL + "/1234567";
	private static final String FIND_URL = 	BASE_URL + "?action=findChatRoom";
	
	public static void main(String[] args) throws Exception{
		String body = doFind();
		System.out.println(body);
		
		JSONObject json = new JSONObject(body);
		String chatRoomId = json.getString("value");
		System.out.println(chatRoomId);
		create(chatRoomId);
		System.out.println(doGet(GET_URL));
		System.out.println(doGet(UPDATE_URL));
		System.out.println(doGet(POST_URL));
	}
	
	private static String doFind() throws Exception
	{
        URL url = new URL(FIND_URL);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.setRequestMethod("POST");
        InputStream response = request.getInputStream();
        byte[] data = readAllBytes(response);
        // Extract the token from JSON.
        String body = new String(data, "UTF8");
        
        return body;
	}
	
	private static String doGet(String getUrl) throws Exception
	{
        URL url = new URL(getUrl);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.setRequestMethod("GET");
        InputStream response = request.getInputStream();
        byte[] data = readAllBytes(response);
        // Extract the token from JSON.
        String body = new String(data, "UTF8");
        
        return body;
	}
	
	
    private static byte[]
    readAllBytes(InputStream input)
        throws IOException
    {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(BLOCK_SIZE);
        byte[] block = new byte[BLOCK_SIZE];
        int n;
        while ((n = input.read(block)) > 0)
            buffer.write(block, 0, n);
        return buffer.toByteArray();
    }
    
	private static void create(String chatRoomId) {
		String room = "";
		try {

			final HttpClientFactory http = new HttpClientFactory();
			final Client r2Client = new TransportClientAdapter(
					http.getClient(Collections.<String, String> emptyMap()));

			// Create a RestClient to talk to customer service server
			RestClient restClient = new RestClient(r2Client,
					CREATE_URL);
			SocialPlayBuilders builders = new SocialPlayBuilders();

			SocialPlayContext csc = new SocialPlayContext().setChatRoomId(chatRoomId).setTimestamp(new Date().getTime())
					.setStarted(false).setInitator("John").setParticipant("Google").setTheme("TicTacToe");
			CreateRequest<SocialPlayContext> createReq = builders.create().input(csc).build();
			
			System.out.println(createReq.toString());
			ResponseFuture<EmptyRecord> createFuture = restClient
					.sendRequest(createReq);
			Response<EmptyRecord> createResp = createFuture.getResponse();
			int statusCode = createResp.getStatus();
			if (statusCode != 200) {
				System.out.println("status code: " + statusCode);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			for(StackTraceElement elem : ex.getStackTrace())
			{
				System.out.println(elem.toString());
			}
		}
	}	
}
