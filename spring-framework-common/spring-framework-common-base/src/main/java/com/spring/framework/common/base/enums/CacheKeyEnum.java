package com.spring.framework.common.base.enums;

import lombok.Getter;

@Getter
public enum CacheKeyEnum
{

    USER("user", "user:user:", "用户信息"),

    /** key: user:level:1  value: {"id":"1234567","experience":100} */
    USER_LEVEL("user", "user:level:", "用户等级"),

    USER_TOKEN("user", "user:token:", "用户token"),

    USER_PERMISSION("user", "user:permission:", "权限信息");

    private String name;

    private String key;

    private String desc;

    CacheKeyEnum(String name, String key, String desc)
    {
        this.name = name;
        this.key = key;
        this.desc = desc;
    }
}
