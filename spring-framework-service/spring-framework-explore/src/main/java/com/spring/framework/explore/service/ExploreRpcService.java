package com.spring.framework.explore.service;

import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.explore.api.service.ExploreFeignApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExploreRpcService
{
    @Resource
    private ExploreFeignApi exploreFeignApi;

    public ExploreBaseResponse getExploreDetails(ExploreGetRequest exploreGetRequest)
    {
        return exploreFeignApi.getExploreDetails(exploreGetRequest);
    }

}
