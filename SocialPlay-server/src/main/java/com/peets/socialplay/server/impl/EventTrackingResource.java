package com.peets.socialplay.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.peets.socialplay.server.Event;
import com.peets.socialplay.server.ds.SocialPlayDataService;

@RestLiCollection(name = "eventTracking", namespace = "com.peets.socialplay.server")
public class EventTrackingResource extends
		CollectionResourceTemplate<Long, Event> {
	Logger _log = LoggerFactory.getLogger(EventTrackingResource.class);
	private static SocialPlayDataService dataService = null;
	
	@Override
	public CreateResponse create(Event entity)
	{
		if(entity.hasEventId()){
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"Event ID must NOT present in request");
		}
		if(!entity.hasUserId()){
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"User ID must present in request");
		}
		
		Long eventId = ServerUtils.initService(dataService).insertEvent(entity);
		if(eventId == null)
		{
			throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR,
					"failed to insert an event");			
		}
		return new CreateResponse(eventId);
	}

}
