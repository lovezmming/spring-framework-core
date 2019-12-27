package com.spring.framework.system.controller;

import com.spring.framework.common.web.support.BaseController;
import com.spring.framework.system.api.request.SystemGetRequest;
import com.spring.framework.system.api.response.SystemBaseResponse;
import com.spring.framework.system.service.SystemManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/system")
public class SystemManageController extends BaseController
{

    @Autowired
    private SystemManagerService systemManagerService;

    @GetMapping("/getAbout")
    @ResponseBody
    public SystemBaseResponse getAbout(SystemGetRequest systemGetRequest)
    {
        SystemBaseResponse systemBaseResponse = systemManagerService.getAbout(systemGetRequest.getId());
        systemBaseResponse.success();
        return systemBaseResponse;
    }
}
