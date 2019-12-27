package com.spring.framework.explore.api.service.hystrix;

import com.spring.framework.explore.api.request.CommodityDetailGetRequest;
import com.spring.framework.explore.api.response.CommodityBaseResponse;
import com.spring.framework.explore.api.service.CommodityFeignApi;
import org.springframework.stereotype.Component;

@Component
public class CommodityApiHystrix implements CommodityFeignApi
{
    @Override
    public CommodityBaseResponse getCommodityDetail(CommodityDetailGetRequest commodityDetailGetRequest)
    {
        CommodityBaseResponse commodityBaseResponse = new CommodityBaseResponse();
        commodityBaseResponse.setDesc("error!");
        commodityBaseResponse.setFlag(Boolean.FALSE);
        return commodityBaseResponse;
    }
}
