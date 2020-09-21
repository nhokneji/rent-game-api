package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.Vip;
import com.dts.rentgameapi.domain.entity.TblVipEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class VipBeanUtil implements IDataConvert<Vip, TblVipEntity> {

    @Override
    public Vip entity2Dto(TblVipEntity entity) {
        Vip dto = new Vip();
        dto.setVipId(entity.getVipId());
        dto.setVipName(entity.getVipName());
        dto.setMinAmount(entity.getMinAmount());
        return dto;
    }

    @Override
    public TblVipEntity dto2Entity(Vip dto) {
        TblVipEntity entity = new TblVipEntity();
        entity.setVipId(dto.getVipId());
        entity.setVipName(dto.getVipName());
        entity.setMinAmount(dto.getMinAmount());
        return entity;
    }
}
