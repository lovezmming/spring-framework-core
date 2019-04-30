package com.spring.framework.user.api.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserLoginRequest implements Serializable
{

    private String userName;

    private String passWord;

}
