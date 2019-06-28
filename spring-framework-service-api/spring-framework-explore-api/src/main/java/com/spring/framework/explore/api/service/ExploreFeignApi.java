package com.spring.framework.explore.api.service;

import com.spring.framework.common.web.config.FeignConfiguration;
import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.explore.api.service.hystrix.ExploreApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "spring-framework-explore", configuration = FeignConfiguration.class, fallback = ExploreApiHystrix.class)
public interface ExploreFeignApi
{
    @GetMapping(value = "/explore/getExploreDetails", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ExploreBaseResponse getExploreDetails(@RequestBody ExploreGetRequest exploreGetRequest);

    @GetMapping(value = "/explore/getTestDetail")
    public String getTestDetail(@RequestParam(value = "name") String name);
}
