package com.spring.framework.explore.api.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ExploreGetRequest implements Serializable
{
    private static final long serialVersionUID = -4401356593546677195L;

    private String userId;

}
