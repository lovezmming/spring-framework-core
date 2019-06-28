package com.spring.framework.common.base.enums;

public enum ErrorCodeEnum
{

	GL99990100(9999100, "参数异常"),

	GL99990401(99990401, "无访问权限"),

	GL99990500(500, "未知异常"),

	GL99990403(9999403, "无权访问"),

	GL9999404(9999404, "找不到指定资源"),

	UAC10010001(10010001, "会话超时,请刷新页面重试"),

	UAC10010002(10010002, "TOKEN解析失败"),

	UAC10011001(10011001, "用户Id不能为空"),

	UAC10011002(10011002, "找不到用户,loginName=%s"),

	UAC10011003(10011003, "找不到用户,userId=%s"),

	UAC10011004(10011004, "找不到用户,email=%s"),

	UAC10011006(10012006, "手机号不能为空"),

	UAC10011007(10011007, "登录名不能为空"),

	UAC10011008(10011008, "新密码不能为空"),

	UAC10011009(10011009, "确认密码不能为空"),

	UAC10011010(10011010, "两次密码不一致"),

	UAC10011011(10011011, "用户不存在, userId=%s"),

	UAC10011012(10011012, "登录名已存在"),

	UAC10011013(10011013, "手机号已存在"),

	UAC10011014(10011014, "密码不能为空"),

	UAC10011016(10011016, "用户名或密码错误"),

	UAC10011017(10011017, "验证类型错误"),

	UAC10011018(10011018, "邮箱不能为空"),

	UAC10011019(10011019, "邮箱已存在"),

	UAC10011023(10011023, "越权操作"),

	UAC10011024(10011024, "找不到绑定的用户, userId=%"),

	UAC10011025(10011025, "用户已存在, loginName=%"),

	UAC10011026(10011026, "更新用户失败, userId=%"),

	UAC10011027(10011027, "找不到用户,mobile=%s"),

	UAC10011029(10011029, "重置密码失败"),

	UAC10011032(10011032, "邮箱不存在, loginName=%s,email=%s"),

	UAC10011034(10011034, "不允许操作admin用户"),

	UAC10011035(10011035, "原始密码输入错误"),

	UAC10011036(10011036, "新密码和原始密码不能相同"),

	UAC10011037(10011037, "修改用户失败,userId=%s"),

	UAC10011039(10011039, "验证token失败");

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
