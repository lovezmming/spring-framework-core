package com.spring.framework.explore.service;

import com.spring.framework.explore.api.request.ExploreCreateRequest;
import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;

public interface ExploreManagerService
{
    public ExploreBaseResponse getExploreDetails(ExploreGetRequest exploreGetRequest);

    public ExploreBaseResponse createExplore(ExploreCreateRequest exploreCreateRequest);
}
