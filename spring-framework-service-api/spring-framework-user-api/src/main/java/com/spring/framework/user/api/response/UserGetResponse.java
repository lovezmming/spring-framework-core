package com.spring.framework.user.api.response;

import com.spring.framework.common.web.support.BaseResult;
import lombok.Data;

import java.util.List;

@Data
public class UserGetResponse extends BaseResult {

    private List<UserBaseResponse> userBaseResponses;

}
