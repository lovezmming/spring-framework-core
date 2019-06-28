package com.spring.framework.explore.service.impl;

import com.spring.framework.explore.api.request.ExploreCreateRequest;
import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.explore.service.ExploreManagerService;
import org.springframework.stereotype.Service;

@Service
public class ExploreManagerServiceImpl implements ExploreManagerService
{
    @Override
    public ExploreBaseResponse getExploreDetails(ExploreGetRequest exploreGetRequest)
    {
        return null;
    }

    @Override
    public ExploreBaseResponse createExplore(ExploreCreateRequest exploreCreateRequest)
    {
        return null;
    }
}
