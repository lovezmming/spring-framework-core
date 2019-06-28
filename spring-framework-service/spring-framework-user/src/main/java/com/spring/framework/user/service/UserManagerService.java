package com.spring.framework.user.service;

import com.spring.framework.common.base.exceptions.BusinessException;
import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.response.UserGetResponse;

public interface UserManagerService
{

    public UserGetResponse getUsers(UserGetRequest userGetRequest);

    public UserBaseResponse createUser(UserCreateRequest userCreateRequest) throws BusinessException;

}
