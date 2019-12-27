package com.spring.framework.user.common.init;

import com.alibaba.fastjson.JSONObject;
import com.spring.framework.common.base.enums.CacheKeyEnum;
import com.spring.framework.common.base.enums.CacheNameEnum;
import com.spring.framework.common.base.util.TextUtil;
import com.spring.framework.user.database.mapper.LevelMapper;
import com.spring.framework.user.database.mapper.UserMapper;
import com.spring.framework.user.database.po.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserCacheDataInit implements CommandLineRunner {
    private static final Logger logger =  LoggerFactory.getLogger(UserCacheDataInit.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private CacheManager cacheManager;

    @Resource
    private LevelMapper levelMapper;

    @Override
    public void run(String... args) throws Exception {
        logger.info("User Cache Data Init!");
        List<Level> levels = levelMapper.selectAll();
        if (!TextUtil.isEmpty(levels)) {
            Cache userCache = cacheManager.getCache(CacheNameEnum.USER.getName());
            for (Level level : levels) {
                Map<String, Object> userLevelMap = new HashMap<>();
                userLevelMap.put("id", level.getId());
                userLevelMap.put("experience", level.getExperience());
                userCache.put(CacheKeyEnum.USER_LEVEL.getKey() + level.getLevel(), JSONObject.toJSONString(userLevelMap));
                logger.info("key:{},value:{}", CacheKeyEnum.USER_LEVEL.getKey() + level.getLevel(), JSONObject.toJSONString(userLevelMap));
            }
        }
    }

}
