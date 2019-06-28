package com.spring.framework.user.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class UserBaseResponse
{

    private String userId;

    private String userName;

    private String passWord;

    private String name;

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
