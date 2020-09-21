package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.GameDownloadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/games/download")
public class PublishGameDownloadController {

    @Autowired
    private GameDownloadServiceImpl gameDownloadServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse finById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = gameDownloadServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
