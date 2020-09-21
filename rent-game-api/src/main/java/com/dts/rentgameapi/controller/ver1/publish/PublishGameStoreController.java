package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.GameStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/gamestores")
public class PublishGameStoreController {
    @Autowired
    private GameStoreServiceImpl gameStoreServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = gameStoreServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/games/{store_id}")
    public BaseResponse getGames(@PathVariable Integer store_id,
                                 @RequestParam Integer start,
                                 @RequestParam Integer limit) {
        BaseResponse response = null;
        try {
            response = gameStoreServiceImpl.getListGameByStoreId(store_id, start, limit);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping
    public BaseResponse getAll() {
        BaseResponse response = null;
        try {
            response = gameStoreServiceImpl.findAll();
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
