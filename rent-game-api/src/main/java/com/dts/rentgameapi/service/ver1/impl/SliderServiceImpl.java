package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.Slider;
import com.dts.rentgameapi.domain.entity.TblSliderEntity;
import com.dts.rentgameapi.domain.dto.mapping.GameSliderMapping;
import com.dts.rentgameapi.domain.response.ListGameSliderResponse;
import com.dts.rentgameapi.domain.response.SliderResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.SliderRepo;
import com.dts.rentgameapi.repo.custom.GameSliderRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.SliderService;
import com.dts.rentgameapi.utils.SliderBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class SliderServiceImpl extends BaseService implements SliderService {
    @Autowired
    private SliderRepo sliderRepo;

    @Autowired
    private SliderBeanUtil sliderBeanUtil;

    @Autowired
    private GameSliderRepo gameSliderRepo;


    @Override
    public BaseResponse findById(Integer id) {
        SliderResponse response = new SliderResponse();
        Slider slider = null;
        try {
            TblSliderEntity sliderEntity = sliderRepo.findById(id).get();
            slider = sliderBeanUtil.entity2Dto(sliderEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (slider == null)
            response.setItemNotFound();
        else
            response.setSuccess(slider);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveSilder(Slider slider) {
        TblSliderEntity re = null;
        try {
            TblSliderEntity entity = sliderBeanUtil.dto2Entity(slider);
            re = sliderRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (re == null)
            response.setResult(false, "Not save ");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse updateSlider(Slider slider) {
        TblSliderEntity result = null;
        try {
            TblSliderEntity entity = sliderBeanUtil.dto2Entity(slider);
            result = sliderRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (result == null)
            response.setResult(false, "Not update ");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse findAll() {
        List<GameSliderMapping> sliders = gameSliderRepo.findAll();
        ListGameSliderResponse response = new ListGameSliderResponse();
        if (sliders == null)
            response.setResult(sliders, 0);
        else
            response.setResult(sliders, sliders.size());
        return response;
    }
}
