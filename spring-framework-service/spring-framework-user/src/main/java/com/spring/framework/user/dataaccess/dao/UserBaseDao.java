package com.spring.framework.user.dataaccess.dao;

import com.spring.framework.user.dataaccess.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserBaseDao
{
    public UserPo selectUserByCurrPwd(Map map);
}
