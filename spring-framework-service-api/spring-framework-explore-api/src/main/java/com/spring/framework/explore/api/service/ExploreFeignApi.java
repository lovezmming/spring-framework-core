package com.spring.framework.explore.api.service;

import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "spring-framework-explore")
public interface ExploreFeignApi
{
    @PostMapping(value = "/api/explore/getExploreDetails")
    public ExploreBaseResponse getExploreDetails(ExploreGetRequest exploreGetRequest);

}
