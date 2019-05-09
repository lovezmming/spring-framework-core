package com.spring.framework.user.api.response;

import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
public class UserGetResponse implements Serializable
{

    private List<UserBaseResponse> userBaseResponses;

}
