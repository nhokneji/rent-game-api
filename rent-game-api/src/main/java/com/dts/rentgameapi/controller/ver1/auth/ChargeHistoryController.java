package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.request.ChargeRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.ChargeHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/charge-history")
public class ChargeHistoryController {

    @Autowired
    private ChargeHistoryServiceImpl chargeHistoryServiceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestBody ChargeRequest request) {
        BaseResponse response = null;
        try {
            response = chargeHistoryServiceImpl.saveChargeHistory(request);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/get")
    public BaseResponse getChargeHistoryUser(@RequestParam("from") Integer from,
                                             @RequestParam("to") Integer to) {
        BaseResponse response = null;
        if (from != null && to != null && from <= to) {
            try {
              //  response = chargeHistoryServiceImpl.findIntervalDate(from, to, -1);
            } catch (Exception e) {
                response.setFailed(e.getMessage());
            }
        } else
            response.setFailed("param invalid");
        return response;
    }
}
