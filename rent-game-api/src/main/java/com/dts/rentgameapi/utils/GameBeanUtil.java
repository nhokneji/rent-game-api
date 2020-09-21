package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.Game;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@Component
public class GameBeanUtil implements IDataConvert<Game, TblGameEntity> {
//    @Autowired
//    private CategoryDaoImpl categoryDaoImpl;
//
//    @Autowired
//    private GameStoreDaoImpl gameStoreDaoImpl;
//
//    @Autowired
//    private ProviderDaoImpl providerDaoImpl;

    @Override
    public Game entity2Dto(TblGameEntity entity) {
        Game dto = new Game();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRate(entity.getRate());
        dto.setDesciption(entity.getDesciption());
        dto.setImage(entity.getImage());
        dto.setDownloadCount(entity.getDownloadCount());
        dto.setThumbImage(entity.getThumbImage());
        dto.setGameIdentity(entity.getGameIdentity());
        dto.setStoreId(entity.getStoreId());
        dto.setProviderId(entity.getProviderId());
        dto.setCategoryId(entity.getCategoryId());
        dto.setPlayCount(entity.getPlayCount());
        return dto;
    }


    @Override
    public TblGameEntity dto2Entity(Game dto) {
        TblGameEntity entity = new TblGameEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setDesciption(dto.getDesciption());
        entity.setImage(dto.getImage());
        entity.setDownloadCount(dto.getDownloadCount());
        entity.setThumbImage(dto.getThumbImage());
        entity.setGameIdentity(dto.getGameIdentity());
        entity.setCategoryId(dto.getCategoryId());
        entity.setProviderId(dto.getProviderId());
        entity.setStoreId(dto.getStoreId());
        entity.setPlayCount(dto.getPlayCount());
        entity.setCreatedAt(new Timestamp(new Date().getTime()));
        entity.setUpdatedAt(new Timestamp(new Date().getTime()));
        return entity;
    }
}
