package com.spring.framework.system.api.service.hystrix;

import com.spring.framework.system.api.response.SystemBaseResponse;
import com.spring.framework.system.api.service.SystemFeignApi;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SystemApiHystrix implements SystemFeignApi {

    @Override
    public SystemBaseResponse getAbout(Map<String, Object> requestMap)
    {
        SystemBaseResponse systemBaseResponse = new SystemBaseResponse();
        systemBaseResponse.failure("error!");
        return systemBaseResponse;
    }
}
