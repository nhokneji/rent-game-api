package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.dto.ver1.CashoutHistory;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.CashoutHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/cashout")
public class CashOutHistoryController {
    @Autowired
    private CashoutHistoryServiceImpl cashoutHistoryServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = cashoutHistoryServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @PostMapping("/cashout-money")
    public BaseResponse cashoutMoney(@RequestBody CashoutHistory cashoutHistory) {
        BaseResponse response = null;
        try {
            response = cashoutHistoryServiceImpl.cashout(cashoutHistory);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
