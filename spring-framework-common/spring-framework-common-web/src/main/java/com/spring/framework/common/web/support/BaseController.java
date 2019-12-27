package com.spring.framework.common.web.support;

import com.spring.framework.common.web.wrapper.WrapMapper;
import com.spring.framework.common.web.wrapper.Wrapper;

import java.util.Collection;
import java.util.Map;

public class BaseController
{
	protected <T> Wrapper<T> handleResult(T result) {
		boolean flag = isFlag(result);
		if (flag) {
			return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "success", result);
		} else {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, "failure", result);
		}
	}

	protected <E> Wrapper<E> handleResult(E result, String errorMsg) {
		boolean flag = isFlag(result);

		if (flag) {
			return WrapMapper.wrap(Wrapper.SUCCESS_CODE, "success", result);
		} else {
			return WrapMapper.wrap(Wrapper.ERROR_CODE, errorMsg, result);
		}
	}

	private boolean isFlag(Object result) {
		boolean flag;
		if (result instanceof Integer) {
			flag = (Integer) result > 0;
		} else if (result instanceof Boolean) {
			flag = (Boolean) result;
		} else if (result instanceof String) {
			flag = ((String) result).length() == 0;
		} else if (result instanceof Collection) {
			return ((Collection) result).isEmpty();
		} else if (result instanceof Map) {
			return ((Map) result).size() == 0;
		} else {
			flag = (result == null || result == "");
		}
		return flag;
	}

}
  