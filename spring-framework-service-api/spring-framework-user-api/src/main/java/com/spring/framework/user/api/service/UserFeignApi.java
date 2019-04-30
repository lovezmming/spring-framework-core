package com.spring.framework.user.api.service;

import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "spring-framework-user")
public interface UserFeignApi
{
    @PostMapping(value = "/api/user/createUser")
    public UserBaseResponse createUser(UserCreateRequest userCreateRequest);

}
