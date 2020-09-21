package com.dts.rentgameapi.controller.ver2.auth;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.request.UpdatePasswordRequest;
import com.dts.rentgameapi.domain.request.UpdateProfileRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver1.impl.UserServiceImpl;
import com.dts.rentgameapi.service.ver2.impl.UserServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS (Nguyễn Văn Đức 57TH4)
 */
@RestController
@RequestMapping("/auth/api/v2/users")
public class UserControllerVer2 extends BaseController {

    @Autowired
    private UserServiceImplVer2 userServiceImplVer2;

    @PutMapping
    public BaseResponse update(@RequestBody UpdateProfileRequest request,
                               @RequestHeader HttpHeaders header) {
        BaseResponse response = null;
        logger.info("update user profile request ={}", request);
        response = userServiceImplVer2.updateProfile(request, header);
        logger.info("update user profile response :{}", response);
        return response;
    }



    @PostMapping("update-password")
    public BaseResponse updatePassword(@RequestBody UpdatePasswordRequest request,
                               @RequestHeader HttpHeaders header) {
        BaseResponse response = null;
        logger.info("update user password request ={}", request);
        response = userServiceImplVer2.updatePassword(request, header);
        logger.info("update user password response :{}", response);
        return response;
    }

}
