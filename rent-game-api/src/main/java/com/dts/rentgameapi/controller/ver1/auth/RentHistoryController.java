package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.RentHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/rent-history")
public class RentHistoryController {


    @Autowired
    private RentHistoryServiceImpl rentHistoryServiceImpl;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestParam("shopId") Integer shopId,
                               @RequestParam("gameId") Integer gameId,
                               @RequestHeader HttpHeaders httpHeader) {
        String token = httpHeader.get("Rin-Author").toString();
        BaseResponse response = new BaseResponse();
        token = token.substring(1, token.length() - 1);
        try {
            response = rentHistoryServiceImpl.create(token, shopId, gameId);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/get")
    public BaseResponse getRentHistoryByShop(@RequestParam("from") Integer from,
                                             @RequestParam("shopId") Integer shopId,
                                             @RequestParam("to") Integer to) {
        BaseResponse response = null;
        if (from != null && to != null && from <= to) {
            try {
                response = rentHistoryServiceImpl.findByShopIdRangePart(shopId, from, to);
            } catch (Exception e) {
                response.setFailed(e.getMessage());
            }
        } else
            response.setFailed("param invalid");
        return response;
    }

    @GetMapping("/user")
    public BaseResponse getRentHistory(@RequestHeader HttpHeaders httpHeader,
                                       @RequestParam Integer start,
                                       @RequestParam Integer limit) {
        String token = httpHeader.get("Rin-Author").toString();
        BaseResponse response = new BaseResponse();
        token = token.substring(1, token.length() - 1);

        if (start != null && limit != null) {
            try {
                response = rentHistoryServiceImpl.findRentGameHistory(token, start, limit);
            } catch (Exception e) {
                response.setFailed(e.getMessage());
            }
        } else
            response.setFailed("param invalid");
        return response;
    }
}
