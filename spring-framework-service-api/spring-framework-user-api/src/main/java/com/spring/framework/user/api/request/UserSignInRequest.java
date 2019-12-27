package com.spring.framework.user.api.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserSignInRequest implements Serializable {

    private static final long serialVersionUID = -968369232507226562L;

    @NotNull
    private String userId;

    private Integer experience;
}
