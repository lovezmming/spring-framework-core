package com.spring.framework.user.database.custom;

import com.spring.framework.user.database.po.SignIn;

import java.util.List;

public interface SignInCustomMapper
{

    List<SignIn> getSignInsByUserId(String userId);

}