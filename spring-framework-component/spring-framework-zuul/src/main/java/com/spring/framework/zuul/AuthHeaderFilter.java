/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：AuthHeaderFilter.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.spring.framework.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthHeaderFilter extends ZuulFilter {

	private static final String BEARER_TOKEN_TYPE = "bearer ";
	private static final String OPTIONS = "OPTIONS";
	private static final String AUTH_PATH = "/auth";
	private static final String LOGOUT_URI = "/oauth/token";
	private static final String ALIPAY_CALL_URI = "/pay/alipayCallback";

	@Override
	public String filterType()
	{
		return "pre";
	}

	@Override
	public int filterOrder()
	{
		return 0;
	}

	@Override
	public boolean shouldFilter()
	{
		return true;
	}

	@Override
	public Object run()
	{
		RequestContext requestContext = RequestContext.getCurrentContext();
		try {
			HttpServletRequest request = requestContext.getRequest();
			String requestURI = request.getRequestURI();
			if (OPTIONS.equalsIgnoreCase(request.getMethod()) || !requestURI.contains(AUTH_PATH) || !requestURI.contains(LOGOUT_URI) || !requestURI.contains(ALIPAY_CALL_URI)) {

			} else
			{
				throw new ZuulException("刷新页面重试", 403, "check token fail");
			}
			// 校验
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

}
