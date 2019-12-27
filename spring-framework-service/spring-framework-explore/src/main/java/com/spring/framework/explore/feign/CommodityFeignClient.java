package com.spring.framework.explore.feign;

import com.spring.framework.explore.api.request.CommodityDetailGetRequest;
import com.spring.framework.explore.api.response.CommodityBaseResponse;
import com.spring.framework.explore.api.service.CommodityFeignApi;
import com.spring.framework.explore.service.CommodityManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityFeignClient implements CommodityFeignApi
{

    @Resource
    private CommodityManagerService commodityManagerService;

    @Override
    public CommodityBaseResponse getCommodityDetail(CommodityDetailGetRequest commodityDetailGetRequest)
    {
        CommodityBaseResponse commodityBaseResponse = commodityManagerService.getCommodityDetail(commodityDetailGetRequest);
        return commodityBaseResponse;
    }
}
