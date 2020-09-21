package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver1.impl.ChargeHistoryServiceImpl;
import com.dts.rentgameapi.service.ver1.impl.GameServiceImpl;
import com.dts.rentgameapi.service.ver1.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private JwtValidator jwtValidator;

    @Autowired
    private ChargeHistoryServiceImpl chargeHistoryServiceImpl;

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @GetMapping("/info")
    @ResponseBody
    public BaseResponse getUserInfo(
            @RequestHeader HttpHeaders header) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = null;
        try {
            response = userServiceImpl.findByUsername(jwtUser.getUsername());
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @GetMapping("/charge-history/{user_id}")
    public BaseResponse getChargeHistoryUser(@RequestParam("from") Integer from,
                                             @RequestParam("to") Integer to,
                                             @RequestHeader HttpHeaders header) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = null;
        try {
            response = chargeHistoryServiceImpl.findByUserId(jwtUser.getUsername(), from, to);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/charge-historys")
    public BaseResponse getChargeHistoryByUserPage(@RequestHeader HttpHeaders header,
                                                   @RequestParam Integer start,
                                                   @RequestParam Integer limit) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = null;
        try {
            response = chargeHistoryServiceImpl.findByUserIdPages(jwtUser.getUsername(), start, limit);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }



    @GetMapping("/getlistgame")
    public BaseResponse getListGameByUser(@RequestHeader HttpHeaders header,
                                          @RequestParam Integer start,
                                          @RequestParam Integer limit,
                                          @RequestParam Integer store_id) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = null;
        try {
            response = gameServiceImpl.findMyGamesByPages(jwtUser.getUsername(), start, limit,store_id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @GetMapping("/game/playing")
    public BaseResponse getGame(@RequestHeader HttpHeaders header) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = null;
        try {
            response = gameServiceImpl.findGamePlaying(jwtUser.getUsername());
            response.setSuccess();
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete/{username}")
    public String delete(@PathVariable String username) {
        return "redirect:/users";
    }

    @PutMapping("/update/{username}")
    public String update(@PathVariable String username) {
        return "redirect:/users/" + username;
    }

}
