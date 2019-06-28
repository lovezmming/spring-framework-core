package com.spring.framework.user.controller;

import com.spring.framework.common.base.exceptions.BusinessException;
import com.spring.framework.common.web.support.BaseController;
import com.spring.framework.common.web.wrapper.WrapMapper;
import com.spring.framework.common.web.wrapper.Wrapper;
import com.spring.framework.explore.api.request.ExploreGetRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.dataaccess.source.TargetDataSource;
import com.spring.framework.user.service.UserManagerService;
import com.spring.framework.user.service.UserRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserManageController extends BaseController
{

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    private UserRpcService userRpcService;

    @PostMapping("/createUser")
    public Wrapper<UserBaseResponse> createUser(@RequestBody UserCreateRequest userCreateRequest)
    {
        try
        {
            UserBaseResponse userBaseResponse = userManagerService.createUser(userCreateRequest);
            return WrapMapper.success(userBaseResponse);
        } catch (BusinessException be)
        {
            return WrapMapper.error(be.getMessage());
        }
    }

    @GetMapping("/getUserExploreDetails")
    @ResponseBody
    public Wrapper<ExploreBaseResponse> getUserExploreDetails(@RequestBody ExploreGetRequest exploreGetRequest)
    {
        ExploreBaseResponse exploreBaseResponse = userRpcService.getUserExploreDetails(exploreGetRequest);
        return WrapMapper.success(exploreBaseResponse);
    }

    @GetMapping("/getTestDetail")
    public String getTestDetail(@RequestParam(value = "name") String name)
    {
        return userRpcService.getTestDetail(name);
    }

    @GetMapping("/getSystemTime")
    @TargetDataSource("user")
    public Long getSystemTime()
    {
        return System.currentTimeMillis();
    }

}
