package com.spring.framework.explore.controller;

import com.spring.framework.common.web.support.BaseController;
import com.spring.framework.common.web.wrapper.WrapMapper;
import com.spring.framework.common.web.wrapper.Wrapper;
import com.spring.framework.explore.api.request.CommodityGetRequest;
import com.spring.framework.explore.api.response.CommodityGetResponse;
import com.spring.framework.explore.service.CommodityManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/explore")
public class CommodityManageController extends BaseController
{

    @Autowired
    private CommodityManagerService commodityManagerService;

    @GetMapping("/getCommodities")
    public Wrapper<CommodityGetResponse> getCommodities(CommodityGetRequest commodityGetRequest)
    {
        CommodityGetResponse commodityGetResponse = commodityManagerService.getCommodities(commodityGetRequest);
        return WrapMapper.success(commodityGetResponse);
    }
}
