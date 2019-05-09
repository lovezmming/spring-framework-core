package com.spring.framework.user.dataaccess.dao;

import com.spring.framework.user.dataaccess.po.UserPo;

import java.util.Map;

public interface UserBaseDao
{
    public UserPo selectUserByCurrPwd(Map map);
}
