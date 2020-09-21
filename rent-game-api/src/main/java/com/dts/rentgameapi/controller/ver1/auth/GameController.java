package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.dto.ver1.Game;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver1.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/games")
public class GameController {

    @Autowired
    private JwtValidator jwtValidator;
    @Autowired
    private GameServiceImpl gameServiceImpl;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestBody Game game) {
        BaseResponse response = null;
        try {
            response = gameServiceImpl.saveGame(game);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @GetMapping
    public BaseResponse findAll(
            @RequestHeader HttpHeaders header) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        BaseResponse response = null;
        // service.getGamesByPage();
        try {
            JwtUser jwtUser = jwtValidator.validate(token);
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            response = gameServiceImpl.findAll(userEntity.getUserId());
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
