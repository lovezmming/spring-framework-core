package com.spring.framework.common.Wrapper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Wrapper<T> implements Serializable
{

    private static final long serialVersionUID = 4893280118017319089L;

    public static final int SUCCESS_CODE = 200;

    public static final String SUCCESS_MESSAGE = "操作成功";

    public static final int ERROR_CODE = 500;

    public static final String ERROR_MESSAGE = "内部异常";

    public static final int ILLEGAL_ARGUMENT_CODE_ = 100;

    public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private T result;

    Wrapper()
    {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    Wrapper(int code, String message)
    {
        this(code, message, null);
    }

    Wrapper(int code, String message, T result)
    {
        super();
        this.code(code).message(message).result(result);
    }

    private Wrapper<T> code(int code)
    {
        this.setCode(code);
        return this;
    }

    private Wrapper<T> message(String message)
    {
        this.setMessage(message);
        return this;
    }

    public Wrapper<T> result(T result)
    {
        this.setResult(result);
        return this;
    }

    @JsonIgnore
    public boolean success()
    {
        return Wrapper.SUCCESS_CODE == this.code;
    }

    @JsonIgnore
    public boolean error()
    {
        return !success();
    }

}
