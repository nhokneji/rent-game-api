package com.dts.rentgameapi.controller.ver2.publish;

import com.dts.rentgameapi.controller.BaseController;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver2.impl.GameServiceImplVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/games")
public class PublishGameControllerVer2 extends BaseController {

    @Autowired
    private GameServiceImplVer2 gameServiceImplVer2;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        logger.info("Find game by id request id = {}", id);
        response = gameServiceImplVer2.findById(id);
        logger.info("Find game by id response:{}", response);
        return response;
    }

    @GetMapping
    public BaseResponse getAllGames(@RequestParam("start") int start,
                                    @RequestParam("limit") int limit,
                                    @RequestParam("store_id") int store_id,
                                    @RequestParam("category_id") int category_id,
                                    @RequestParam("sort") String sort) {
        logger.info("Get All games request start ={},limit={},store_id={},category_id={}", start, limit, store_id, category_id);
        BaseResponse response = gameServiceImplVer2.findGameFormByOffset(sort, start, limit, store_id, category_id);
        logger.info("Get all games response:{}", response);
        return response;
    }

    @GetMapping("/top")
    public BaseResponse getTopGames(@RequestParam("type") int type,
                                    @RequestParam("limit") int limit) {
        logger.info("Get top games type={}, limit={}", type, limit);
        BaseResponse response = gameServiceImplVer2.getTopGames(type, limit);
        logger.info("Get top games response:{}", response);
        return response;
    }


}
