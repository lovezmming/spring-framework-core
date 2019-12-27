package com.spring.framework.explore.api.response;

import com.spring.framework.common.web.support.BaseResult;
import lombok.Data;

import java.util.List;

@Data
public class CommodityGetResponse extends BaseResult {

    private List<CommodityBaseResponse> commodityBaseResponses;
}
