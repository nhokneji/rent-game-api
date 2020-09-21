package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/provider")
public class PublishProviderController {
    @Autowired
    private ProviderServiceImpl providerServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = providerServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @GetMapping("/games/{pro_id}")
    public BaseResponse getGames(@PathVariable Integer pro_id,
                                 @RequestParam Integer start,
                                 @RequestParam Integer limit) {
        BaseResponse response = null;
        try {
            if (start == -1) {
                response=providerServiceImpl.findAllGame(pro_id);
            } else {
                response = providerServiceImpl.getListGameByPages(pro_id, start, limit);
            }
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
