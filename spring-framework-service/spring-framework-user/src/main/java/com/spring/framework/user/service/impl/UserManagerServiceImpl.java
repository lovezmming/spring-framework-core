package com.spring.framework.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.spring.framework.common.base.enums.CacheKeyEnum;
import com.spring.framework.common.base.enums.CacheNameEnum;
import com.spring.framework.common.base.enums.ServiceIdEnum;
import com.spring.framework.common.base.exceptions.BusinessException;
import com.spring.framework.common.base.util.PrimaryKeyUtil;
import com.spring.framework.common.base.util.TextUtil;
import com.spring.framework.user.api.request.UserCreateRequest;
import com.spring.framework.user.api.request.UserGetRequest;
import com.spring.framework.user.api.request.UserSignInRequest;
import com.spring.framework.user.api.response.UserBaseResponse;
import com.spring.framework.user.api.response.UserGetResponse;
import com.spring.framework.user.api.response.entity.UserRoleEntity;
import com.spring.framework.user.database.custom.SignInCustomMapper;
import com.spring.framework.user.database.custom.UserRoleRelationCustomMapper;
import com.spring.framework.user.database.mapper.RoleMapper;
import com.spring.framework.user.database.mapper.SignInMapper;
import com.spring.framework.user.database.mapper.UserMapper;
import com.spring.framework.user.database.po.Role;
import com.spring.framework.user.database.po.SignIn;
import com.spring.framework.user.database.po.User;
import com.spring.framework.user.database.po.UserRoleRelation;
import com.spring.framework.user.service.UserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserManagerServiceImpl implements UserManagerService {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private SignInCustomMapper signInCustomMapper;

    @Resource
    private SignInMapper signInMapper;

    @Resource
    private UserRoleRelationCustomMapper userRoleRelationCustomMapper;

    @Resource
    private CacheManager cacheManager;

    @Override
    public UserGetResponse getUsers(UserGetRequest userGetRequest) {
        UserGetResponse userGetResponse = new UserGetResponse();
        List<UserBaseResponse> userBaseResponses = new ArrayList<UserBaseResponse>();
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            userBaseResponses.add(getUserBaseResponse(user));
        }
        userGetResponse.setUserBaseResponses(userBaseResponses);
        return userGetResponse;
    }

    @Override
    public UserBaseResponse createUser(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setName(userCreateRequest.getName());
        user.setBirthday(userCreateRequest.getBirthDay());
        user.setGender(userCreateRequest.getGender());
        user.setPhoneNumber(userCreateRequest.getPhoneNumber());

        user.setUserName(userCreateRequest.getUserName());
        user.setPassWord(userCreateRequest.getPassWord());
        try {
            user.setPrivatePassWord(PrimaryKeyUtil.primaryPassword(userCreateRequest.getPassWord()));
        } catch (Exception e) {
            throw new BusinessException("password primary error!");
        }
        user.setId(PrimaryKeyUtil.nextId(ServiceIdEnum.USER, Boolean.TRUE));
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        int id = userMapper.insert(user);
        user.setId(String.valueOf(id));
        return getUserBaseResponse(user);
    }

    @Override
    public UserBaseResponse getUserDetail(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return getUserBaseResponse(user);
    }

    @Override
    public UserBaseResponse userSignIn(UserSignInRequest userSignInRequest) {
        User user = userMapper.selectByPrimaryKey(userSignInRequest.getUserId());
        Integer experience = user.getExperience();

        Integer requestEx = userSignInRequest.getExperience();
        if (requestEx == null)
        {
            requestEx = 1;
        }
        Integer allEx = experience + requestEx;
        Integer level = user.getLevel();
        Cache userCache = cacheManager.getCache(CacheNameEnum.USER.getName());
        String userLevel = (String) userCache.get(CacheKeyEnum.USER_LEVEL.getKey() + level).get();
        Map<String, Object> userLevelMap = (Map<String, Object>) JSONObject.parse(userLevel);
        Integer totalEx = (Integer) userLevelMap.get("experience");
        if (totalEx - allEx <= 0) {
            user.setLevel(level + 1);
            user.setExperience(allEx - totalEx);
        } else {
            user.setExperience(allEx);
        }

        Date now = new Date();
        SignIn signIn = new SignIn();
        String newId = PrimaryKeyUtil.nextId(ServiceIdEnum.USER, Boolean.TRUE);
        logger.info("id:{}", newId);
        signIn.setId(newId);
        signIn.setStatus(Boolean.TRUE);
        signIn.setUserId(user.getId());
        signIn.setCreateTime(now);
        signIn.setCreateUser(user.getId());
        signIn.setUpdateTime(now);
        signIn.setUpdateUser(user.getId());
        signInMapper.insert(signIn);

        user.setUpdateTime(now);
        userMapper.updateByPrimaryKey(user);

        return getUserBaseResponse(user);
    }

    private UserBaseResponse getUserBaseResponse(User user) {
        UserBaseResponse userBaseResponse = new UserBaseResponse();
        userBaseResponse.setUserId(user.getId());
        userBaseResponse.setName(user.getName());
        userBaseResponse.setGender(user.getGender());
        userBaseResponse.setBirthDay(user.getBirthday());
        userBaseResponse.setUserName(user.getUserName());
        userBaseResponse.setPassWord(user.getPassWord());
        userBaseResponse.setPhoneNumber(user.getPhoneNumber());
        Integer level = user.getLevel();
        Cache userCache = cacheManager.getCache(CacheNameEnum.USER.getName());
        String userLevel = (String) userCache.get(CacheKeyEnum.USER_LEVEL.getKey() + level).get();
        Map<String, Object> userLevelMap = (Map<String, Object>) JSONObject.parse(userLevel);
        userBaseResponse.setTotalExperience((Integer) userLevelMap.get("experience"));
        userBaseResponse.setExperience(user.getExperience());
        userBaseResponse.setLevel(level);

        Role role = null;
        UserRoleEntity userRoleEntity = null;
        List<UserRoleEntity> userRoleEntitys = new ArrayList<>();
        List<UserRoleRelation> userRoleRelations = userRoleRelationCustomMapper.getUserRolesByUserId(user.getId());
        if (!TextUtil.isEmpty(userRoleRelations)) {
            for (UserRoleRelation userRoleRelation : userRoleRelations) {
                userRoleEntity = new UserRoleEntity();
                role = roleMapper.selectByPrimaryKey(userRoleRelation.getRoleId());
                userRoleEntity.setRoleId(role.getId());
                userRoleEntity.setRoleName(role.getName());
                userRoleEntitys.add(userRoleEntity);
            }
        }
        userBaseResponse.setUserRoles(userRoleEntitys);

        List<Date> signInDates = new ArrayList<>();
        List<SignIn> signIns = signInCustomMapper.getSignInsByUserId(user.getId());
        if (!TextUtil.isEmpty(signIns)) {
            for (SignIn signIn : signIns) {
                signInDates.add(signIn.getCreateTime());
            }
        }
        userBaseResponse.setSignInDates(signInDates);
        return userBaseResponse;
    }

    public static void main(String[] args)
    {
        String ss = "000000";
        System.out.println(Integer.valueOf(ss)%4);
    }
}
