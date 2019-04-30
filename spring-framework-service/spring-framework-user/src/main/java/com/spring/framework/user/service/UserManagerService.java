package com.spring.framework.user.service;

import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.response.UserBaseResponse;

public interface UserManagerService
{
    public UserBaseResponse createUser(UserCreateRequest userCreateRequest);

//    public UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest);
//    public UserDetailResponse getUserDetail(UserDetailRequest userDetailRequest);
}
