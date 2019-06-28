package com.spring.framework.common.base.enums;

public enum ServiceIdEnum
{

    /** 用户 */
    USER(1, "000001", "01"),

    /**  */
    EXPLORE(2, "000001", "01");

    private int code;

    private String desc;

    private String flag;

    public int getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getFlag()
    {
        return flag;
    }

    ServiceIdEnum(int code, String desc, String flag)
    {
        this.code = code;
        this.desc = desc;
        this.flag = flag;
    }
}
