package com.spring.framework.explore.api.service;

import com.spring.framework.common.web.config.FeignConfiguration;
import com.spring.framework.explore.api.request.CommodityDetailGetRequest;
import com.spring.framework.explore.api.response.CommodityBaseResponse;
import com.spring.framework.explore.api.service.hystrix.CommodityApiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "spring-framework-explore", configuration = FeignConfiguration.class, fallback = CommodityApiHystrix.class)
public interface CommodityFeignApi
{
    @GetMapping(value = "/commodity/getCommodityDetail")
    @ResponseBody
    public CommodityBaseResponse getCommodityDetail(CommodityDetailGetRequest commodityDetailGetRequest);

}
