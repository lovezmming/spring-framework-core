package com.spring.framework.user.api.service;

import com.spring.framework.common.web.config.FeignConfiguration;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.service.hystrix.UserApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "spring-framework-user", configuration = FeignConfiguration.class, fallback = UserApiHystrix.class)
public interface UserFeignApi {

    @GetMapping(value = "/user/getUserDetail")
    @ResponseBody
    public UserBaseResponse getUserDetail(String userId);

}
