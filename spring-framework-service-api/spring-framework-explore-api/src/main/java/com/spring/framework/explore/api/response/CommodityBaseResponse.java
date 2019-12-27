package com.spring.framework.explore.api.response;

import com.spring.framework.common.web.support.BaseResult;
import lombok.Data;

@Data
public class CommodityBaseResponse extends BaseResult {

    private String id;

    private String name;

    private String url;

    private Integer price;

    private String description;

    private Boolean status;
}
