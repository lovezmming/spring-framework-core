package com.spring.framework.explore.api.service.hystrix;

import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.explore.api.service.ExploreFeignApi;
import org.springframework.stereotype.Component;

@Component
public class ExploreApiHystrix implements ExploreFeignApi
{
    @Override
    public ExploreBaseResponse getExploreDetails(ExploreGetRequest exploreGetRequest)
    {
        ExploreBaseResponse exploreBaseResponse = new ExploreBaseResponse();
        exploreBaseResponse.setDesc("error!");
        exploreBaseResponse.setFlag(Boolean.FALSE);
        return exploreBaseResponse;
    }

    @Override
    public String getTestDetail(String name)
    {
        return "this is ExploreApiHystrix, hello! " + name;
    }
}
