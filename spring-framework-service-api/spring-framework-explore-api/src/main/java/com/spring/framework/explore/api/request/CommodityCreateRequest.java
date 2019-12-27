package com.spring.framework.explore.api.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommodityCreateRequest implements Serializable {

    private static final long serialVersionUID = -3965492660811954903L;

    private String name;

    private String description;

    private Integer price;

    private Boolean status;
}
