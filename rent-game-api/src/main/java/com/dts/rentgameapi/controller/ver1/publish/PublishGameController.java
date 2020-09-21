package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.GameDownloadServiceImpl;
import com.dts.rentgameapi.service.ver1.impl.GameServiceImpl;
import com.dts.rentgameapi.service.ver1.impl.UserRentGameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/games")
public class PublishGameController {

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @Autowired
    private GameDownloadServiceImpl gameDownloadServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = gameServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping
    public BaseResponse findAll(@RequestParam Integer start,
                                @RequestParam Integer limit) {
        BaseResponse response = null;
        // service.getGamesByPage();
        try {
            if (start < 0)
                start = 0;
            if (start < 0)
                response = gameServiceImpl.findAll();
            else {
                response = gameServiceImpl
                        .findByPages(start, limit);
            }
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @Autowired
    private UserRentGameInfoService service;


    @GetMapping("/downloads/{game_id}")
    public BaseResponse getGames(@PathVariable Integer game_id,
                                 @RequestParam Integer start,
                                 @RequestParam Integer limit) {
        BaseResponse response = null;

        try {
            if (start == -1) {
                response = gameServiceImpl.getAllLinkDownload(game_id);
            } else
                response = gameServiceImpl.getLinkDownloadByPages(game_id, start, limit);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
