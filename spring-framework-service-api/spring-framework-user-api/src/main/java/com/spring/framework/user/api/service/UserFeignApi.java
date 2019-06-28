package com.spring.framework.user.api.service;

import com.spring.framework.common.web.config.FeignConfiguration;
import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.api.service.hystrix.UserApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "spring-framework-user", configuration = FeignConfiguration.class, fallback = UserApiHystrix.class)
public interface UserFeignApi
{
    @GetMapping(value = "/user/getUsers")
    public UserGetResponse getUsers(UserGetRequest userGetRequest);

}
