package com.spring.framework.user.api.service.hystrix;

import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.api.service.UserFeignApi;
import org.springframework.stereotype.Component;

@Component
public class UserApiHystrix implements UserFeignApi
{
    @Override
    public UserGetResponse getUsers(UserGetRequest userGetRequest)
    {
        UserGetResponse userGetResponse = new UserGetResponse();
        userGetResponse.setDesc("error!");
        userGetResponse.setFlag(Boolean.FALSE);
        return userGetResponse;
    }
}
