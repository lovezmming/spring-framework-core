package com.spring.framework.system.service.impl;

import com.spring.framework.system.api.response.SystemBaseResponse;
import com.spring.framework.system.database.mapper.AboutMapper;
import com.spring.framework.system.database.po.About;
import com.spring.framework.system.service.SystemManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SystemManagerServiceImpl implements SystemManagerService {

    @Resource
    private AboutMapper aboutMapper;

    @Override
    public SystemBaseResponse getAbout(String id) {
        SystemBaseResponse systemBaseResponse = new SystemBaseResponse();
        About about = aboutMapper.selectByPrimaryKey(id);
        if (about == null) {
            systemBaseResponse.failure("未查询到about信息：" + id);
        } else {
            systemBaseResponse.setDescription(about.getDescription());
            systemBaseResponse.setName(about.getName());
            systemBaseResponse.setId(about.getId());
        }
        return systemBaseResponse;
    }
}
