package com.spring.framework.system.api.response;

import com.spring.framework.common.web.support.BaseResult;
import lombok.Data;

@Data
public class SystemBaseResponse extends BaseResult {

    private String id;

    private String name;

    private String description;

}
