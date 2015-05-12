package com.peets.socialplay.server.impl;

import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.RestLiServiceException;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import com.peets.socialplay.server.Account;
import com.peets.socialplay.server.Settings;
import com.peets.socialplay.server.ds.SocialPlayDataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestLiCollection(name = "settings", namespace = "com.peets.socialplay.server")
public class SettingsResource extends
        CollectionResourceTemplate<Long, Settings> {
    Logger _log = LoggerFactory.getLogger(SettingsResource.class);

    private static SocialPlayDataService dataService = null;

    @Override
    public Settings get(Long accountId)
    {
        return ServerUtils.initService(dataService).getSettings(accountId);
    }

    @Override
    public CreateResponse create(Settings entity)
    {
        if (!entity.hasUserId()) {
            throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
                    "Account ID must be present in request");
        }

        if(!entity.hasSchedules()) {
            throw new RestLiServiceException(HttpStatus.S_400_BAD_REQUEST,
                    "must have schedules in the request");
        }

        if(!ServerUtils.initService(dataService).createSettings(entity))
        {
            throw new RestLiServiceException(HttpStatus.S_500_INTERNAL_SERVER_ERROR,
                    "Failed to create settings");
        }

        return new CreateResponse(true);
    }
}
