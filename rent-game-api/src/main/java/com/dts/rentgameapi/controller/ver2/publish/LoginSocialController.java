package com.dts.rentgameapi.controller.ver2.publish;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.request.LoginFacebookRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver2.impl.LoginSocialServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/login-social")
public class LoginSocialController extends BaseController {

    @Autowired
    private LoginSocialServiceImplVer2 loginSocialServiceImplVer2;
    @PostMapping("/facebook")
    public BaseResponse loginFaceBook(@RequestBody LoginFacebookRequest request) {
        logger.info("Login FaceBook request  =>{}",request);

        BaseResponse response = null;

        response=loginSocialServiceImplVer2.loginFacebook(request);

        logger.info("Login FaceBook response  =>{}", response);
        return response;
    }
}
