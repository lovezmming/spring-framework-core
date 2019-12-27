package com.spring.framework.explore.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CommodityDetailGetRequest implements Serializable {

    private static final long serialVersionUID = 2386297692838305336L;

    @NotNull
    private String id;
}
