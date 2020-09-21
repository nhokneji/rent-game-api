package com.dts.rentgameapi.controller.ver2.auth;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver2.impl.ChargeServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/v2/charge-history")
public class ChargeHistoryControllerVer2 extends BaseController {

    @Autowired
    private ChargeServiceImplVer2 chargeServiceImplVer2;

    @GetMapping
    public BaseResponse findChargeHistoryByUser(@RequestHeader HttpHeaders httpHeaders,
                                                @RequestParam("start") int start,
                                                @RequestParam("limit") int limit,
                                                @RequestParam("sort") String sort) {
        BaseResponse response;
        logger.info("Get charge history by user");
        response = chargeServiceImplVer2.findChargeHistoryByUser(retrieveJwtUser(httpHeaders), start, limit,sort);
        logger.info("Get charge history by user response : {}", response);
        return response;
    }

}
