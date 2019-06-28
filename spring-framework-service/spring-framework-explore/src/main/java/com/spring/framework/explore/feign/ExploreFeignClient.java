package com.spring.framework.explore.feign;

import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.explore.api.service.ExploreFeignApi;
import com.spring.framework.explore.service.ExploreManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExploreFeignClient implements ExploreFeignApi
{

    @Resource
    private ExploreManagerService exploreManagerService;

    @Override
    public ExploreBaseResponse getExploreDetails(ExploreGetRequest exploreGetRequest)
    {
        ExploreBaseResponse exploreBaseResponse = exploreManagerService.getExploreDetails(exploreGetRequest);
        return exploreBaseResponse;
    }

    @Override
    public String getTestDetail(String name)
    {
        return "this is ExploreFeignClient, hello !" + name;
    }
}
