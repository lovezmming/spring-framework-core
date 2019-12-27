package com.spring.framework.user.api.service.hystrix;

import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import org.springframework.stereotype.Component;

@Component
public class UserApiHystrix implements UserFeignApi {

    @Override
    public UserBaseResponse getUserDetail(String userId) {
        UserBaseResponse userBaseResponse = new UserBaseResponse();
        userBaseResponse.setUserId(userId);
        userBaseResponse.setDesc("error!");
        userBaseResponse.setFlag(Boolean.FALSE);
        return userBaseResponse;
    }
}
