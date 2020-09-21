package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.AffiliateCashoutHistory;
import com.dts.rentgameapi.domain.entity.TblAffiliateCashoutHistoryEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class AffCashOutHistoryBeanUtil implements IDataConvert<AffiliateCashoutHistory, TblAffiliateCashoutHistoryEntity> {

    @Override
    public AffiliateCashoutHistory entity2Dto(TblAffiliateCashoutHistoryEntity entity) {
        AffiliateCashoutHistory dto = new AffiliateCashoutHistory();
        dto.setId(entity.getId());
        dto.setAffiliateId(entity.getAffiliateId());
        dto.setAmount(entity.getAmount());
        dto.setResult(entity.getResult());
        dto.setCreatedTime(entity.getCreatedTime());
        return dto;
    }

    @Override
    public TblAffiliateCashoutHistoryEntity dto2Entity(AffiliateCashoutHistory dto) {
        TblAffiliateCashoutHistoryEntity entity = new TblAffiliateCashoutHistoryEntity();
        entity.setAffiliateId(dto.getAffiliateId());
       // entity.setAffiliateEntity(dto.getAffiliateEntity());
        entity.setAmount(dto.getAmount());
        entity.setResult(dto.getResult());
        entity.setCreatedTime(dto.getCreatedTime());
        return entity;
    }
}
