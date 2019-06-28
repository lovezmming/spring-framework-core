package com.spring.framework.user.api.response;

import com.spring.framework.common.web.support.BaseResult;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class UserLoginResponse extends BaseResult
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

    private Integer experience;

}
