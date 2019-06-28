package com.spring.framework.user.service;

import com.spring.framework.common.web.wrapper.WrapMapper;
import com.spring.framework.common.web.wrapper.Wrapper;
import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.explore.api.service.ExploreFeignApi;
import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Service
public class UserRpcService
{
    @Autowired
    private UserFeignApi userFeignApi;

    @Autowired
    private ExploreFeignApi exploreFeignApi;

    public UserGetResponse getUsers(UserGetRequest userGetRequest)
    {
        return userFeignApi.getUsers(userGetRequest);
    }

    public ExploreBaseResponse getUserExploreDetails(ExploreGetRequest exploreGetRequest)
    {
        return exploreFeignApi.getExploreDetails(exploreGetRequest);
    }

    public String getTestDetail(String name)
    {
        return exploreFeignApi.getTestDetail(name);
    }

}
