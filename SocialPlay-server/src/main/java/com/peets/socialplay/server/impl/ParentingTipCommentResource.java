package com.peets.socialplay.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.ResourceLevel;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.annotations.Action;
import com.linkedin.restli.server.annotations.ActionParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.linkedin.restli.server.resources.ComplexKeyResourceTemplate;
import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.ParentingComment;
import com.peets.socialplay.server.ParentingTip;
import com.peets.socialplay.server.ParentingTipId;
import com.peets.socialplay.server.ds.SocialPlayDataService;

@RestLiCollection(name = "parentingComment", namespace = "com.peets.socialplay.server")
public class ParentingTipCommentResource extends
ComplexKeyResourceTemplate<ParentingTipId, ParentingTipId, ParentingComment> {
	Logger _log = LoggerFactory.getLogger(ParentingTipResource.class);

	private static SocialPlayDataService dataService = null;

	@Override
	public ParentingComment get(ComplexResourceKey<ParentingTipId, ParentingTipId> tipId) {
		return null;
	}
	
	@Override
	public CreateResponse create(ParentingComment entry)
	{
		if (!entry.hasCommentDetail()) {
			throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
					"comment detail must present!");
		}
		
		Long timestamp = ServerUtils.initService(dataService).createComment(entry);
		
		return new CreateResponse(timestamp);
	}

	@Action(name = "getCommentsPaged", resourceLevel = ResourceLevel.COLLECTION)
	public ParentingComment[] getCommentsPaged(
			@ActionParam("tipId") ParentingTipId tipId,
			@ActionParam("timestamp") Long timestamp,
			@ActionParam("count") Integer count,
			@ActionParam("chronicleOrder") Boolean chronicleOrder,
			@ActionParam("lastTimestamp") Long lastTimestamp) {
		return ServerUtils.initService(dataService).getComments(tipId,
				timestamp, count, chronicleOrder, lastTimestamp);
	}
}