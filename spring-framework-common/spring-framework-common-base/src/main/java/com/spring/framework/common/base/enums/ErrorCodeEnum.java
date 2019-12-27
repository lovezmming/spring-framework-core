package com.spring.framework.common.base.enums;

public enum ErrorCodeEnum
{

	RE_ERROR_1000(1000, "无访问权限"),

	DB_ERROR_1001(1001, "主键创建异常");

	private int code;

	private String msg;

	public String msg()
	{
		return msg;
	}

	public int code()
	{
		return code;
	}

	ErrorCodeEnum(int code, String msg)
	{
		this.code = code;
		this.msg = msg;
	}

	public static ErrorCodeEnum getEnum(int code)
	{
		for (ErrorCodeEnum ele : ErrorCodeEnum.values())
		{
			if (ele.code() == code) {
				return ele;
			}
		}
		return null;
	}
}
