package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.GameStore;
import com.dts.rentgameapi.domain.entity.TblGameStoreEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class GameStoreBeanUtil implements IDataConvert<GameStore, TblGameStoreEntity> {

    @Override
    public GameStore entity2Dto(TblGameStoreEntity entity) {
        GameStore dto = new GameStore();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDesciption(entity.getDesciption());
        return dto;
    }

    @Override
    public TblGameStoreEntity dto2Entity(GameStore dto) {
        TblGameStoreEntity entity = new TblGameStoreEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDesciption(dto.getDesciption());
        return entity;
    }
}
