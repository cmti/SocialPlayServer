package com.peets.socialplay.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.server.ResourceLevel;
import com.linkedin.restli.server.annotations.Action;
import com.linkedin.restli.server.annotations.ActionParam;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.ComplexKeyResourceTemplate;
import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.ParentingTip;
import com.peets.socialplay.server.ParentingTipId;
import com.peets.socialplay.server.ds.SocialPlayDataService;

@RestLiCollection(name = "parentingTip", namespace = "com.peets.socialplay.server")
public class ParentingTipResource extends
	ComplexKeyResourceTemplate<ParentingTipId, Account, ParentingTip> {
	Logger _log = LoggerFactory.getLogger(ParentingTipResource.class);

	private static SocialPlayDataService dataService = null;
	
	@Override
	public ParentingTip get(ComplexResourceKey<ParentingTipId, Account> tipId) {
		return ServerUtils.initService(dataService).getTip(tipId.getKey(), tipId.getParams().getAccountId());
	}

	@Action(name = "getTip", resourceLevel = ResourceLevel.COLLECTION)
	public ParentingTip getTip() {
		return ServerUtils.initService(dataService).getRandomTip();
	}
}
