package com.dts.rentgameapi.converters;

import com.dts.rentgameapi.domain.dto.mapping.GameFormMapping;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameFromConveter implements Converter<TblGameEntity, com.dts.rentgameapi.domain.dto.ver2.GameForm> {


    @Autowired
    private ModelMapper mapper;

    @Override
    public com.dts.rentgameapi.domain.dto.ver2.GameForm convert(TblGameEntity tblGameEntity) {
        com.dts.rentgameapi.domain.dto.ver2.GameForm gameForm=mapper.map(tblGameEntity, com.dts.rentgameapi.domain.dto.ver2.GameForm.class);
        return gameForm;
    }


    public com.dts.rentgameapi.domain.dto.ver2.GameForm convert(GameFormMapping gameFormEntity) {
        com.dts.rentgameapi.domain.dto.ver2.GameForm gameForm=mapper.map(gameFormEntity, com.dts.rentgameapi.domain.dto.ver2.GameForm.class);
        return gameForm;
    }
}
