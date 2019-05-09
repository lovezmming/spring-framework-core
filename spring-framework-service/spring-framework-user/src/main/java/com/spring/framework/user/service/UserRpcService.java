package com.spring.framework.user.service;

import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRpcService
{
    @Resource
    private UserFeignApi userFeignApi;

    public UserGetResponse getUsers(UserGetRequest userGetRequest)
    {
        return userFeignApi.getUsers(userGetRequest);
    }

}
