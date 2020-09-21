package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.GameAccount;
import com.dts.rentgameapi.domain.entity.TblGameAccountEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class GameAccountBeanUtil implements IDataConvert<GameAccount, TblGameAccountEntity> {


    @Override
    public GameAccount entity2Dto(TblGameAccountEntity entity) {
        GameAccount dto = new GameAccount();
        dto.setId(entity.getId());
        dto.setGameId(entity.getGameId());
        dto.setAccount(entity.getAccount());
        dto.setPassword(entity.getPassword());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setLastUpdateTime(entity.getLastUpdateTime());
        dto.setStatus(entity.getStatus());
        dto.setRentTime(entity.getRentTime());
        dto.setRentCount(entity.getRentCount());
        dto.setAccount(entity.getAccount());
        dto.setExpireTime(entity.getExpireTime());
        dto.setShopId(entity.getShopId());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    @Override
    public TblGameAccountEntity dto2Entity(GameAccount dto) {
        TblGameAccountEntity entity = new TblGameAccountEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        else
            entity.setId(0);
        entity.setAccount(dto.getAccount());
        entity.setPassword(dto.getPassword());
        entity.setCreatedTime(dto.getCreatedTime());
        entity.setLastUpdateTime(dto.getLastUpdateTime());
        entity.setStatus(dto.getStatus());
        if (dto.getStatus()==null)
            entity.setStatus(0);
        entity.setRentTime(dto.getRentTime());
        entity.setRentCount(dto.getRentCount());
        if (dto.getRentCount()==null)
            entity.setRentCount(0);
        entity.setGameId(dto.getGameId());
        entity.setShopId(dto.getShopId());
        entity.setExpireTime(dto.getExpireTime());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
