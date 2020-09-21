package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.CashoutHistory;
import com.dts.rentgameapi.domain.entity.TblCashoutHistoryEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class CashOutHistoryBeanUtil implements IDataConvert<CashoutHistory, TblCashoutHistoryEntity> {



    @Override
    public CashoutHistory entity2Dto(TblCashoutHistoryEntity entity) {
        CashoutHistory dto = new CashoutHistory();
        dto.setId(entity.getId());
        dto.setShopId(entity.getShopId());
        dto.setAmount(entity.getAmount());
        dto.setResult(entity.getResult());
        dto.setLastBalance(entity.getLastBalance());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setPart(entity.getPart());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public TblCashoutHistoryEntity dto2Entity(CashoutHistory dto) {
        TblCashoutHistoryEntity entity = new TblCashoutHistoryEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        else
            entity.setId(0);
        // ShopEntity shopEntity = shopDaoImpl.findById(dto.getShopId());
        // entity.setCashoutHistoryShop(shopEntity);
        entity.setAmount(dto.getAmount());
        entity.setResult(dto.getResult());
        entity.setLastBalance(dto.getLastBalance());
        entity.setCreatedTime(dto.getCreatedTime());
        entity.setPart(dto.getPart());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
