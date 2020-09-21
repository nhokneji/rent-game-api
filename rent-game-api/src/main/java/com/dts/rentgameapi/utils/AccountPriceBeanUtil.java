package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.AccountPrice;
import com.dts.rentgameapi.domain.entity.TblAccountPriceEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class AccountPriceBeanUtil implements IDataConvert<AccountPrice, TblAccountPriceEntity> {

    @Override
    public AccountPrice entity2Dto(TblAccountPriceEntity entity) {
        AccountPrice dto = new AccountPrice();
        dto.setAcountId(entity.getAcountId());
        // dto.setGameAccountEntity(entity.getGameAccountEntity());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        return dto;
    }

    @Override
    public TblAccountPriceEntity dto2Entity(AccountPrice dto) {
        TblAccountPriceEntity entity = new TblAccountPriceEntity();
        entity.setAcountId(dto.getAcountId());
        //   entity.setGameAccountEntity(dto.getGameAccountEntity());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        return entity;
    }
}
