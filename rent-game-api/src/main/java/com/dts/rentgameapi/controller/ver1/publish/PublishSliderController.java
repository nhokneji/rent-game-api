package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.SliderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/api/sliders")
public class PublishSliderController {
    @Autowired
    private SliderServiceImpl sliderServiceImpl;

    @GetMapping
    public BaseResponse findAll() {
        BaseResponse response = null;
        try {
            response = sliderServiceImpl.findAll();
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
