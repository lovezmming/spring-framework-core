package com.spring.framework.user.feign;

import com.spring.framework.system.api.response.SystemBaseResponse;
import com.spring.framework.system.api.service.SystemFeignApi;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserRpcService
{
    @Resource
    private UserFeignApi userFeignApi;

    @Resource
    private SystemFeignApi systemFeignApi;

    public UserBaseResponse getUserDetail(String userGetRequest) {
        return userFeignApi.getUserDetail(userGetRequest);
    }

    public SystemBaseResponse getSystemAbout(String id) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("id", id);
        return systemFeignApi.getAbout(requestMap);
    }

}
