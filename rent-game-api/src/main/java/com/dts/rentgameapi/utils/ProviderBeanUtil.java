package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.Provider;
import com.dts.rentgameapi.domain.entity.TblProviderEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class ProviderBeanUtil implements IDataConvert<Provider, TblProviderEntity> {

    @Override
    public Provider entity2Dto(TblProviderEntity entity) {
        Provider dto = new Provider();
        dto.setId(entity.getId());
        dto.setProviderName(entity.getProviderName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    @Override
    public TblProviderEntity dto2Entity(Provider dto) {
        TblProviderEntity entity = new TblProviderEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        entity.setProviderName(dto.getProviderName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
