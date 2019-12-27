package com.spring.framework.system.api.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemGetRequest implements Serializable {

    private static final long serialVersionUID = 1820417623362857356L;

    private String id;
}
