package com.spring.framework.user.api.response;

import com.spring.framework.common.web.support.BaseResult;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserGetResponse extends BaseResult
{

    private List<UserBaseResponse> userBaseResponses;

}
