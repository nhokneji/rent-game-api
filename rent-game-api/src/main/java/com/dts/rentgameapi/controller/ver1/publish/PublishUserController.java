package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver1.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class PublishUserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private JwtValidator jwtValidator;

    @GetMapping("/shops")
    @ResponseBody
    public BaseResponse getUserInfo(
            @RequestHeader HttpHeaders header) {

        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = null;
        try {
            /// response = userServiceImpl.getShopByUser(jwtUser.getUsername());
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @PostMapping("/stop-rent-game")
    @ResponseBody
    public BaseResponse stopRentGame(
            @RequestParam Integer user_id) {
        BaseResponse response = null;
        try {
             response = userServiceImpl.stopRentGame(user_id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

}
