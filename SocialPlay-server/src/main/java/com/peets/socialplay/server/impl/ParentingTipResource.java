package com.peets.socialplay.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.ComplexKeyResourceTemplate;
import com.peets.socialplay.server.ParentingTip;
import com.peets.socialplay.server.ParentingTipId;
import com.peets.socialplay.server.ds.SocialPlayDataService;

@RestLiCollection(name = "parentingTip", namespace = "com.peets.socialplay.server")
public class ParentingTipResource extends
	ComplexKeyResourceTemplate<ParentingTipId, ParentingTipId, ParentingTip> {
	Logger _log = LoggerFactory.getLogger(ParentingTipResource.class);

	private static SocialPlayDataService dataService = null;
	
	@Override
	public ParentingTip get(ComplexResourceKey<ParentingTipId, ParentingTipId> tipId) {
		return ServerUtils.initService(dataService).getTip(tipId.getKey());
	}
}
