package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.Slider;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public interface SliderService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveSilder(Slider slider);

    BaseResponse updateSlider(Slider slider);

    BaseResponse findAll();
}
