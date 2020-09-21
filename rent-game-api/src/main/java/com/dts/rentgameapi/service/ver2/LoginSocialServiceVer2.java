package com.dts.rentgameapi.service.ver2;

import com.dts.rentgameapi.domain.request.LoginFacebookRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

/**
 * @author Rin-DTS
 */
public interface LoginSocialServiceVer2 {
    BaseResponse loginFacebook(LoginFacebookRequest request);
}
