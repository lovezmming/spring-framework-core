package com.spring.framework.user.controller;

import com.spring.framework.common.web.support.BaseController;
import com.spring.framework.system.api.response.SystemBaseResponse;
import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.request.UserDetailGetRequest;
import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.request.UserSignInRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.feign.UserRpcService;
import com.spring.framework.user.service.UserManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理接口")
public class UserManageController extends BaseController
{

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    private UserRpcService userRpcService;

    @PostMapping("/createUser")
    @ApiOperation("创建用户")
    public UserBaseResponse createUser(@RequestBody UserCreateRequest userCreateRequest)
    {
        UserBaseResponse userBaseResponse = userManagerService.createUser(userCreateRequest);
        return userBaseResponse;
    }

    @GetMapping("/getUsers")
    @ApiOperation("获取用户列表")
    @ResponseBody
    public UserGetResponse getUsers(UserGetRequest userGetRequest)
    {
        UserGetResponse userGetResponse = userManagerService.getUsers(userGetRequest);
        return userGetResponse;
    }

    @GetMapping("/getUserDetail")
    @ApiOperation("获取用户详情")
    @ResponseBody
    public UserBaseResponse getUserDetail(UserDetailGetRequest userDetailGetRequest)
    {
        UserBaseResponse userBaseResponse = userManagerService.getUserDetail(userDetailGetRequest.getUserId());
        return userBaseResponse;
    }

    @PostMapping("/userSignIn")
    @ApiOperation("签到")
    @ResponseBody
    public UserBaseResponse userSignIn(UserSignInRequest userSignInRequest)
    {
        UserBaseResponse userBaseResponse = userManagerService.userSignIn(userSignInRequest);
        return userBaseResponse;
    }

    @GetMapping("/getAbout")
    @ApiOperation("测试feign")
    @ResponseBody
    public SystemBaseResponse getAbout(UserDetailGetRequest userDetailGetRequest)
    {
        SystemBaseResponse systemBaseResponse = userRpcService.getSystemAbout(userDetailGetRequest.getUserId());
        return systemBaseResponse;
    }

}
