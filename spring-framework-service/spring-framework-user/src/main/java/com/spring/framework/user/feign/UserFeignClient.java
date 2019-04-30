package com.spring.framework.user.feign;

import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import com.spring.framework.user.service.UserManagerService;

import javax.annotation.Resource;

public class UserFeignClient implements UserFeignApi
{

    @Resource
    private UserManagerService userManagerService;

    @Override
    public UserBaseResponse createUser(UserCreateRequest userCreateRequest)
    {
        UserBaseResponse userLoginResponse = userManagerService.createUser(userCreateRequest);
        return userLoginResponse;
    }
}
