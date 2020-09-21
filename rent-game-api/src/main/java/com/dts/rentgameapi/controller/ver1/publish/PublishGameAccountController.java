package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.GameAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/games/account")
public class PublishGameAccountController {


    @Autowired
    private GameAccountServiceImpl gameAccountServiceImpl;


    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = gameAccountServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/shop/{shop_id}")
    public BaseResponse findByShopId(@PathVariable Integer shop_id,
                                     @RequestParam Integer start,
                                     @RequestParam Integer limit) {
        BaseResponse response = null;
        try {
            if (start == -1) {
                response = gameAccountServiceImpl.findAllByShopId(shop_id);
            } else {
                response = gameAccountServiceImpl.findByShopIdAndPages(shop_id, start, limit);
            }
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/game/{game_id}")
    public BaseResponse findByGameId(@PathVariable Integer game_id,
                                     @RequestParam Integer start,
                                     @RequestParam Integer limit) {
        BaseResponse response = null;
        try {
            if (start == -1) {
                response = gameAccountServiceImpl.findAllByGameId(game_id);
            } else {
                response = gameAccountServiceImpl.findByGameIdAndPages(game_id, start, limit);
            }
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @GetMapping("/game-shop")
    public BaseResponse findByGameIdAndShopId(@RequestParam("game_id") Integer game_id,
                                              @RequestParam("shop_id") Integer shop_id,
                                              @RequestParam Integer start,
                                              @RequestParam Integer limit) {
        BaseResponse response = null;
        try {
            if (game_id != null && shop_id != null && start != null && limit != null) {
                if (start == -1) {

                } else {
                    response=gameAccountServiceImpl.findByGameIdAndShopIdPages(game_id,shop_id,start,limit);
                }
            } else
                response.setFailed("param invalid");
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

}
