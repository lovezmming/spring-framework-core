package com.spring.framework.system.service;

import com.spring.framework.system.api.response.SystemBaseResponse;

public interface SystemManagerService
{
    public SystemBaseResponse getAbout(String id);
}
