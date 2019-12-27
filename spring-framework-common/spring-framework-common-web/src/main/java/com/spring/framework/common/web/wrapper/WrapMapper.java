package com.spring.framework.common.web.wrapper;

import org.apache.commons.lang3.StringUtils;

public class WrapMapper
{
	private WrapMapper() {}

	public static <E> Wrapper<E> wrap(int code, String message, E o) {
		return new Wrapper<>(code, message, o);
	}

	public static <E> Wrapper<E> wrap(int code, String message) {
		return wrap(code, message, null);
	}

	public static <E> Wrapper<E> wrap(int code) {
		return wrap(code, null);
	}

	public static <E> Wrapper<E> wrap(Exception e) {
		return new Wrapper<>(Wrapper.ERROR_CODE, e.getMessage());
	}

	public static <E> E unWrap(Wrapper<E> wrapper) {
		return wrapper.getResult();
	}

	public static <E> Wrapper<E> illegalArgument() {
		return wrap(Wrapper.ILLEGAL_ARGUMENT_CODE_, Wrapper.ILLEGAL_ARGUMENT_MESSAGE);
	}

	public static <E> Wrapper<E> error() {
		return wrap(Wrapper.ERROR_CODE, Wrapper.ERROR_MESSAGE);
	}

	public static <E> Wrapper<E> error(String message) {
		return wrap(Wrapper.ERROR_CODE, StringUtils.isBlank(message) ? Wrapper.ERROR_MESSAGE : message);
	}

	public static <E> Wrapper<E> success() {
		return new Wrapper<>();
	}

	public static <E> Wrapper<E> success(E o) {
		return new Wrapper<>(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, o);
	}
}
