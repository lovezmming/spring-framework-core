package com.spring.framework.user.controller;

import com.spring.framework.common.Wrapper.WrapMapper;
import com.spring.framework.common.Wrapper.Wrapper;
import com.spring.framework.common.support.BaseController;
import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.service.UserManagerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserManageController extends BaseController
{
    @Resource
    private UserManagerService userManagerService;

    @PostMapping(value = "/createUser")
    public Wrapper<UserBaseResponse> createUser(@RequestBody UserCreateRequest userCreateRequest)
    {
        UserBaseResponse userBaseResponse = userManagerService.createUser(userCreateRequest);
        return WrapMapper.success(userBaseResponse);
    }

}
