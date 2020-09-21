package com.dts.rentgameapi.controller.ver2.auth;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.request.CreateShopRequset;
import com.dts.rentgameapi.domain.request.UpdateProfileRequest;
import com.dts.rentgameapi.domain.request.UpdateShopRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver2.ShopServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/v2/shops")
public class ShopControllerVer2 extends BaseController {

    @Autowired
    private ShopServiceVer2 shopServiceVer2;


    @GetMapping("/exist")
    public BaseResponse existShopName(@RequestHeader HttpHeaders header) {
        logger.info(" exist shop ");
        BaseResponse response = null;
        response = shopServiceVer2.checkShopName(retrieveJwtUser(header));
        logger.info("exist shop name response :{}", response);
        return response;
    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse create(@RequestBody CreateShopRequset requset,
                               @RequestHeader HttpHeaders header) {
        logger.info(" create request ={}", requset);
        BaseResponse response = null;
        response = shopServiceVer2.createShop(requset, retrieveJwtUser(header));
        logger.info("create shop response :{}", response);
        return response;

    }


    @PutMapping
    public BaseResponse update(@RequestBody UpdateShopRequest request,
                               @RequestHeader HttpHeaders header) {
        logger.info("update shop request ={}", request);
        BaseResponse response = null;
        response = shopServiceVer2.update(request, retrieveJwtUser(header));
        logger.info("update shop response :{}", response);
        return response;
    }


    @GetMapping("/game-accounts")
    public BaseResponse findGameAccountByShopId(@RequestHeader HttpHeaders header) {
        logger.info("Find game account by shop ");
        BaseResponse response = null;
        response = shopServiceVer2.findGameAccountByShop(retrieveJwtUser(header));
        logger.info("Find game account by shop :{}", response);
        return response;
    }
}
