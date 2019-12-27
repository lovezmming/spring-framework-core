package com.spring.framework.system.api.service;

import com.spring.framework.common.web.config.FeignConfiguration;
import com.spring.framework.system.api.response.SystemBaseResponse;
import com.spring.framework.system.api.service.hystrix.SystemApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(value = "spring-framework-system", configuration = FeignConfiguration.class, fallback = SystemApiHystrix.class)
public interface SystemFeignApi {

    @GetMapping(value = "/system/getAbout")
    @ResponseBody
    public SystemBaseResponse getAbout(@RequestParam Map<String, Object> requestMap);

}
