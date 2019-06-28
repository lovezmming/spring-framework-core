package com.spring.framework.user.api.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserLoginRequest implements Serializable
{

    private static final long serialVersionUID = -2063316290046177590L;

    private String userName;

    private String passWord;

}
