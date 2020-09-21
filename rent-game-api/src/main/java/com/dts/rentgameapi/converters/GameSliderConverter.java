package com.dts.rentgameapi.converters;

import com.dts.rentgameapi.domain.dto.ver2.GameSlider;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class GameSliderConverter implements Converter<TblGameEntity, GameSlider> {

    @Autowired
    private ModelMapper mapper;
    @Override
    public GameSlider convert(TblGameEntity tblGameEntity) {
        return mapper.map(tblGameEntity,GameSlider.class);
    }
}
