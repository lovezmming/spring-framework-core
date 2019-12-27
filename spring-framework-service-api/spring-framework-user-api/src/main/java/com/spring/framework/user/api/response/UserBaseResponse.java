package com.spring.framework.user.api.response;

import com.spring.framework.common.web.support.BaseResult;
import com.spring.framework.user.api.response.entity.UserRoleEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserBaseResponse extends BaseResult {

    private String userId;

    private String userName;

    private String passWord;

    private String name;

    private Integer gender;

    private Date birthDay;

    private String phoneNumber;

    private List<UserRoleEntity> userRoles;

    private List<Date> signInDates;

    private Integer level;

    private Integer experience;

    private Integer TotalExperience;

}
