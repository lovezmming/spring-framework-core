package com.spring.framework.user.database.custom;

import com.spring.framework.user.database.po.UserRoleRelation;

import java.util.List;

public interface UserRoleRelationCustomMapper
{
    List<UserRoleRelation> getUserRolesByUserId(String userId);
}