package com.spring.framework.user.service.impl;

import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.database.mapper.ExperienceMapper;
import com.spring.framework.user.database.mapper.RoleMapper;
import com.spring.framework.user.database.mapper.SignInMapper;
import com.spring.framework.user.database.mapper.UserMapper;
import com.spring.framework.user.database.po.Experience;
import com.spring.framework.user.database.po.Role;
import com.spring.framework.user.database.po.User;
import com.spring.framework.user.service.UserManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService
{

    @Resource
    private UserMapper userMapper;

    @Resource
    private ExperienceMapper experienceMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private SignInMapper signInMapper;

    @Override public UserGetResponse getUsers(UserGetRequest userGetRequest)
    {
        UserGetResponse userGetResponse = new UserGetResponse();
        List<UserBaseResponse> userBaseResponses = new ArrayList<UserBaseResponse>();
        List<User> users = userMapper.selectAll();
        for (User user : users)
        {
            userBaseResponses.add(getUserBaseResponse(user));
        }
        userGetResponse.setUserBaseResponses(userBaseResponses);
        return userGetResponse;
    }

    @Override
    public UserBaseResponse createUser(UserCreateRequest userCreateRequest)
    {
        User user = new User();
        user.setName(userCreateRequest.getName());
        user.setBirthday(userCreateRequest.getBirthDay());
        user.setGender(userCreateRequest.getGender());
        user.setPhoneNumber(userCreateRequest.getPhoneNumber());

        user.setUserName(userCreateRequest.getUserName());
        user.setPassWord(userCreateRequest.getPassWord());

        // TODO
//        user.setPrivatePassWord();

        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        int id = userMapper.insert(user);
        user.setId(String.valueOf(id));

        return getUserBaseResponse(user);
    }

    private UserBaseResponse getUserBaseResponse(User user)
    {
        UserBaseResponse userBaseResponse = new UserBaseResponse();
        userBaseResponse.setUserId(user.getId());
        userBaseResponse.setName(user.getName());
        userBaseResponse.setGender(user.getGender());
        userBaseResponse.setBirthDay(user.getBirthday());
        userBaseResponse.setUserName(user.getUserName());
        userBaseResponse.setPassWord(user.getPassWord());
        userBaseResponse.setPhoneNumber(user.getPhoneNumber());
        if (user.getExperienceId() != null)
        {
            Experience experience = experienceMapper.selectByPrimaryKey(user.getExperienceId());
            userBaseResponse.setLevel(experience.getLevel());
            userBaseResponse.setExperience(experience.getExperience());
            userBaseResponse.setScore(experience.getScore());
        }
        if (user.getRoleId() != null)
        {
            Role role = roleMapper.selectByPrimaryKey(user.getRoleId());
            userBaseResponse.setRoleId(user.getRoleId());
            userBaseResponse.setRoleName(role.getName());
        }

        //        signInMapper.selectByUserId();
        return userBaseResponse;
    }
}
