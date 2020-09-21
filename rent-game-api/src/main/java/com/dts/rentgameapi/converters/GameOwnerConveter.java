package com.dts.rentgameapi.converters;

import com.dts.rentgameapi.domain.dto.ver2.GameOwner;
import com.dts.rentgameapi.domain.dto.mapping.GameOwnerPlayedMapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameOwnerConveter implements Converter<GameOwnerPlayedMapping, GameOwner> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public GameOwner convert(GameOwnerPlayedMapping tblGameEntity) {
        GameOwner gameOwner = mapper.map(tblGameEntity,GameOwner.class);
        if (tblGameEntity.getStatus() == null)
            gameOwner.setStatus(0);
        else
            gameOwner.setStatus(tblGameEntity.getStatus());
        return gameOwner;
    }
}
