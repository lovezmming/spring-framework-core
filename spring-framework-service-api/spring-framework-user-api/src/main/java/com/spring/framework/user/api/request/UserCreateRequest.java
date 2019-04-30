package com.spring.framework.user.api.request;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
public class UserCreateRequest implements Serializable
{

    private String name;

    private String userName;

    private String passWord;

    private Integer gender;

    private String phoneNumber;

    private Date birthDay;

}
