package com.spring.framework.base.support;

import com.spring.framework.base.dto.LoginAuthDto;
import com.spring.framework.base.enums.GlobalConstant;
import com.spring.framework.util.enums.ErrorCodeEnum;
import com.spring.framework.util.exceptions.BusinessException;
import com.spring.framework.util.utils.PublicUtil;
import com.spring.framework.util.utils.ThreadLocalMap;
import com.spring.framework.util.wrapper.WrapMapper;
import com.spring.framework.util.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController
{

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected LoginAuthDto getLoginAuthDto() {
		LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
		if (PublicUtil.isEmpty(loginAuthDto)) {
			throw new BusinessException(ErrorCodeEnum.UAC10011041);
		}
		return loginAuthDto;
	}

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
		} else {
			flag = PublicUtil.isNotEmpty(result);
		}
		return flag;
	}

}
  