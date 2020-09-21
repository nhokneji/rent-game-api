package com.dts.rentgameapi.controller.ver2.auth;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.request.CreateGameAccountRequest;
import com.dts.rentgameapi.domain.request.DeleteRequest;
import com.dts.rentgameapi.domain.request.UpdateGameAccountRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver2.impl.GameAccountServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/v2/game-account")
public class GameAccountControllerVer2 extends BaseController {

    @Autowired
    private GameAccountServiceImplVer2 gameAccountServiceImplVer2;

    @GetMapping
    public BaseResponse findGameAccountByShopId(@RequestHeader HttpHeaders httpHeaders,
                                                @RequestParam("start") int start,
                                                @RequestParam("limit") int limit) {
        BaseResponse response;
        logger.info("Get game account by shop ");
        response = gameAccountServiceImplVer2.findGameAccountByJwtUser(retrieveJwtUser(httpHeaders), start, limit);
        logger.info("Get game account by shop  response : {}", response);
        return response;
    }

    @DeleteMapping("/delete")
    public BaseResponse delete(@RequestBody DeleteRequest request) {
        BaseResponse response;
        logger.info("Delete game account  ");
        response = gameAccountServiceImplVer2.delete(request);
        logger.info("Delete game account response : {}", response);
        return response;
    }

    @PostMapping("/create")
    public BaseResponse create(@RequestHeader HttpHeaders httpHeaders,
                               @RequestBody CreateGameAccountRequest request) {
        BaseResponse response;
        logger.info("create game account  request: {} ", request);
        response = gameAccountServiceImplVer2.create(retrieveJwtUser(httpHeaders), request);
        logger.info("create game account  response : {}", response);
        return response;
    }

    @PutMapping("/update")
    public BaseResponse update(@RequestHeader HttpHeaders httpHeaders,
                               @RequestBody UpdateGameAccountRequest request) {
        BaseResponse response;
        logger.info("Update game account  request: {} ", request);
        response = gameAccountServiceImplVer2.update(retrieveJwtUser(httpHeaders), request);
        logger.info("Update game account  response : {}", response);
        return response;
    }
}
