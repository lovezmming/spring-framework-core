package com.spring.framework.common.web.support;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseResult implements Serializable
{
    private static final long serialVersionUID = 2865880277622897364L;

    private String desc;

    private Boolean flag;

}
