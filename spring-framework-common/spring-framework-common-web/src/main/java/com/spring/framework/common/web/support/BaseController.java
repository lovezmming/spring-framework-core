package com.spring.framework.common.web.support;

import com.spring.framework.common.util.TextUtil;
import com.spring.framework.common.web.wrapper.WrapMapper;
import com.spring.framework.common.web.wrapper.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController
{

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

/*	protected LoginAuthDto getLoginAuthDto() {
		LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
		if (PublicUtil.isEmpty(loginAuthDto)) {
			throw new BusinessException(ErrorCodeEnum.UAC10011041);
		}
		return loginAuthDto;
	}*/

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
			flag = TextUtil.isEmpty(result);
		}
		return flag;
	}

}
  