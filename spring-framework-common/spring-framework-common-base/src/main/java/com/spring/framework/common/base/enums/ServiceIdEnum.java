package com.spring.framework.common.base.enums;

public enum ServiceIdEnum
{

    /** 用户 */
    USER(1, "user", "01"),

    /** 商品 */
    COMMODITY(2, "commodity", "02"),

    /** 系统 */
    SYSTEM(3, "system", "03");

    private long code;

    private String desc;

    private String key;

    public long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getKey() {
        return key;
    }

    ServiceIdEnum(long code, String desc, String key) {
        this.code = code;
        this.desc = desc;
        this.key = key;
    }
}
