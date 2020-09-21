package com.dts.rentgameapi.controller.ver2.auth;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver2.impl.RentHistoryServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/v2/rent-history")
public class RentGameHistoryControllerVer2 extends BaseController {
    @Autowired
    private RentHistoryServiceImplVer2 rentHistoryServiceImplVer2;

    @GetMapping("/aggrevate")
    public BaseResponse aggrevateGameMoney(@RequestParam("status") Integer status,
                                           @RequestHeader HttpHeaders httpHeaders) {
        BaseResponse response;
        logger.info("Aggrevate Game money with status = {}", status);
        response = rentHistoryServiceImplVer2.aggrevate(status, retrieveJwtUser(httpHeaders));
        logger.info("Aggrevate Game money response :{}", response);
        return response;

    }

    @GetMapping("/game-accounts")
    public BaseResponse rentGameByShop(@RequestParam("start") Integer start,
                                       @RequestParam("limit") Integer limit,
                                       @RequestHeader HttpHeaders httpHeaders) {
        BaseResponse response;
        logger.info("Rent Game History by shop  ");
        response = rentHistoryServiceImplVer2.rentGameHistoryByShop( retrieveJwtUser(httpHeaders),start,limit);
        logger.info("Rent Game History  by shop :{}", response);
        return response;

    }

}
