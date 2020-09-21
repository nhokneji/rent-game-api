package com.dts.rentgameapi.controller.ver2.auth;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver2.impl.GameServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api/v2/games")
public class GameControllerVer2 extends BaseController {

    @Autowired
    private GameServiceImplVer2 gameServiceImplVer2;

    @Autowired
    private JwtValidator jwtValidator;
    @GetMapping
    public BaseResponse getAllGames(@RequestParam("start") int start,
                                    @RequestParam("limit") int limit,
                                    @RequestParam("store_id") int store_id,
                                    @RequestParam("category_id") int category_id,
                                    @RequestParam("sort") String sort,
                                    @RequestHeader HttpHeaders header) {
        logger.info("Get All games");
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = gameServiceImplVer2.findGamesOwnerByOffset(sort,start,limit,jwtUser.getUsername(),store_id,category_id);
        logger.info("Get all games response:{}", response);
        return response;
    }
}
