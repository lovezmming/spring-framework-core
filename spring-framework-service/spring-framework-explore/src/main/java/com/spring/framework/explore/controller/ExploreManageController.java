package com.spring.framework.explore.controller;

import com.spring.framework.common.Wrapper.WrapMapper;
import com.spring.framework.common.Wrapper.Wrapper;
import com.spring.framework.common.support.BaseController;
import com.spring.framework.explore.api.request.ExploreCreateRequest;
import com.spring.framework.explore.api.response.ExploreBaseResponse;
import com.spring.framework.explore.service.ExploreManagerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/explore")
public class ExploreManageController extends BaseController
{
    @Resource
    private ExploreManagerService exploreManagerService;

    @PostMapping(value = "/createExplore")
    public Wrapper<ExploreBaseResponse> createExplore(@RequestBody ExploreCreateRequest exploreCreateRequest)
    {
        ExploreBaseResponse exploreBaseResponse = exploreManagerService.createExplore(exploreCreateRequest);
        return WrapMapper.success(exploreBaseResponse);
    }

}
