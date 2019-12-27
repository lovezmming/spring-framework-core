package com.spring.framework.explore.service.impl;

import com.spring.framework.common.base.util.TextUtil;
import com.spring.framework.explore.api.request.CommodityDetailGetRequest;
import com.spring.framework.explore.api.request.CommodityGetRequest;
import com.spring.framework.explore.api.response.CommodityBaseResponse;
import com.spring.framework.explore.api.response.CommodityGetResponse;
import com.spring.framework.explore.database.mapper.CommodityMapper;
import com.spring.framework.explore.database.po.Commodity;
import com.spring.framework.explore.service.CommodityManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityManagerServiceImpl implements CommodityManagerService {

    @Resource
    private CommodityMapper commodityMapper;

    @Override
    public CommodityBaseResponse getCommodityDetail(CommodityDetailGetRequest commodityDetailGetRequest) {
        Commodity commodity = commodityMapper.selectByPrimaryKey(commodityDetailGetRequest.getId());
        return initBaseInfo(commodity);
    }

    private CommodityBaseResponse initBaseInfo(Commodity commodity) {
        CommodityBaseResponse commodityBaseResponse = new CommodityBaseResponse();
        commodityBaseResponse.setId(commodity.getId());
        commodityBaseResponse.setDescription(commodity.getDescription());
        commodityBaseResponse.setPrice(commodity.getPrice());
        commodityBaseResponse.setStatus(commodity.getStatus());
        commodityBaseResponse.setUrl(commodity.getUrl());
        return commodityBaseResponse;
    }

    @Override
    public CommodityGetResponse getCommodities(CommodityGetRequest commodityGetRequest) {
        List<CommodityBaseResponse> responses = new ArrayList<>();
        List<Commodity> commodities = commodityMapper.selectAll();
        if (!TextUtil.isEmpty(commodities)) {
            for (Commodity commodity : commodities) {
                responses.add(initBaseInfo(commodity));
            }
        }
        CommodityGetResponse commodityGetResponse = new CommodityGetResponse();
        commodityGetResponse.setCommodityBaseResponses(responses);
        return commodityGetResponse;
    }
}
