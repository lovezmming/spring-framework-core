package com.spring.framework.user.api.response;

import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
public class UserBaseResponse implements Serializable
{
    private String userId;

    private String userName;

    private String passWord;

    private Integer gender;

    private Date birthDay;

    private String phoneNumber;


    private String roleId;

    private String roleName;


    private List<Date> signInDates;

    private Integer score;

    private Integer level;

    private Integer experience;

}
