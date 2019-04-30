package com.spring.framework.user.service;

import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRpcService
{
    @Resource
    private UserFeignApi userFeignApi;

    public UserBaseResponse createUser(UserCreateRequest userCreateRequest)
    {
        return userFeignApi.createUser(userCreateRequest);
    }

}
