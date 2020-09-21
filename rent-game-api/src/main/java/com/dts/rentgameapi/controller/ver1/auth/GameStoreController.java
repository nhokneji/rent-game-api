package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.dto.ver1.GameStore;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.GameStoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/gamestores")
public class GameStoreController {
    @Autowired
    private GameStoreServiceImpl gameStoreServiceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestBody GameStore gameStore) {
        BaseResponse response = null;
        try {
            response = gameStoreServiceImpl.saveGameStore(gameStore);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


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
}
