package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/shops")
public class PublishShopController {
    @Autowired
    private ShopServiceImpl shopServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = shopServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

}
