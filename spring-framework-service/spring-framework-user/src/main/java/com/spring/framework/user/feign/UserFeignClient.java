package com.spring.framework.user.feign;

import com.spring.framework.common.support.BaseController;
import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import com.spring.framework.user.service.UserManagerService;

import javax.annotation.Resource;

public class UserFeignClient extends BaseController implements UserFeignApi
{

    @Resource
    private UserManagerService userManagerService;

    @Override
    public UserGetResponse getUsers(UserGetRequest userGetRequest)
    {
        UserGetResponse userGetResponse = userManagerService.getUsers(userGetRequest);
        return userGetResponse;
    }
}
