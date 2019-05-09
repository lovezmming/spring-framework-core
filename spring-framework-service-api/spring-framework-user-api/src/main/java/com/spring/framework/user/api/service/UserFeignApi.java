package com.spring.framework.user.api.service;

import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserGetResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "spring-framework-user")
public interface UserFeignApi
{
    @PostMapping(value = "/api/user/getUsers")
    public UserGetResponse getUsers(UserGetRequest userGetRequest);

}
