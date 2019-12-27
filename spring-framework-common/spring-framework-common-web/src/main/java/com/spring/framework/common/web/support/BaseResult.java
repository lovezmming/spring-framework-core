package com.spring.framework.common.web.support;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Data
public class BaseResult implements Serializable
{
    private static final long serialVersionUID = 2865880277622897364L;

    private String desc;

    private Boolean flag;

    @PostConstruct
    public void success() {
        setFlag(Boolean.TRUE);
        setDesc("success");
    }

    public void failure(String desc) {
        setFlag(Boolean.FALSE);
        setDesc(desc);
    }
}
