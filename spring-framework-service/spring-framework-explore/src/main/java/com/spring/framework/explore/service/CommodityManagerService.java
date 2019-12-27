package com.spring.framework.explore.service;

import com.spring.framework.explore.api.request.CommodityDetailGetRequest;
import com.spring.framework.explore.api.request.CommodityGetRequest;
import com.spring.framework.explore.api.response.CommodityBaseResponse;
import com.spring.framework.explore.api.response.CommodityGetResponse;

public interface CommodityManagerService
{
    public CommodityBaseResponse getCommodityDetail(CommodityDetailGetRequest commodityDetailGetRequest);

    public CommodityGetResponse getCommodities(CommodityGetRequest commodityGetRequest);
}
