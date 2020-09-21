package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.dto.ver1.GameDownload;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.GameDownloadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/games/download")
public class GameDownloadController {

    @Autowired
    private GameDownloadServiceImpl gameDownloadServiceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestBody GameDownload gameDownload) {
        BaseResponse response = null;
        try {
            response = gameDownloadServiceImpl.saveGameDownload(gameDownload);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
