package com.dts.rentgameapi.controller.ver2.auth;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.dto.ver1.CashoutHistory;
import com.dts.rentgameapi.domain.request.CashoutRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver1.impl.CashoutHistoryServiceImpl;
import com.dts.rentgameapi.service.ver2.impl.CashoutHistoryServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS (Nguyễn Văn Đức 57TH4)
 */
@RestController
@RequestMapping("/auth/api/v2/cashout")
public class CashOutHistoryControllerVer2 extends BaseController {

    @Autowired
    private CashoutHistoryServiceImplVer2 cashoutHistoryServiceImplVer2;

    @PostMapping
    public BaseResponse cashoutMoney(@RequestBody CashoutRequest request,
                                     @RequestHeader HttpHeaders header) {
        BaseResponse response = null;
        logger.info("Cash out request =>{}",request);
        try {
            response = cashoutHistoryServiceImplVer2.cashout(request,retrieveJwtUser(header));
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        logger.info("Cash out response =>{}",response);
        return response;
    }
}
