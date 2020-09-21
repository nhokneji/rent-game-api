package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.Slider;
import com.dts.rentgameapi.domain.entity.TblSliderEntity;
import com.dts.rentgameapi.repo.SliderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class SliderBeanUtil implements IDataConvert<Slider, TblSliderEntity> {


    @Autowired
    private SliderRepo sliderRepo;

    @Autowired
    private GameBeanUtil gameBeanUtil;


    @Override
    public Slider entity2Dto(TblSliderEntity entity) {
        Slider dto = new Slider();
        dto.setId(entity.getId());
        dto.setGameId(entity.getGameId());

        return dto;
    }

    @Override
    public TblSliderEntity dto2Entity(Slider dto) {
        TblSliderEntity entity = new TblSliderEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        entity.setGameId(dto.getGameId());
        return entity;
    }
}
