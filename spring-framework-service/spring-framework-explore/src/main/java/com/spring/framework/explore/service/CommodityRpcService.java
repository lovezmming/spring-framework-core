package com.spring.framework.explore.service;

import com.spring.framework.explore.api.request.CommodityDetailGetRequest;
import com.spring.framework.explore.api.response.CommodityBaseResponse;
import com.spring.framework.explore.api.service.CommodityFeignApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityRpcService
{
    @Resource
    private CommodityFeignApi commodityFeignApi;

    public CommodityBaseResponse getCommodityDetail(CommodityDetailGetRequest commodityDetailGetRequest)
    {
        return commodityFeignApi.getCommodityDetail(commodityDetailGetRequest);
    }

}
