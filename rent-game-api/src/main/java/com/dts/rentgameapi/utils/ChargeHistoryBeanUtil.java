package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.ChargeHistory;
import com.dts.rentgameapi.domain.entity.TblChargeHistoryEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class ChargeHistoryBeanUtil implements IDataConvert<ChargeHistory, TblChargeHistoryEntity> {


    @Override
    public ChargeHistory entity2Dto(TblChargeHistoryEntity entity) {
        ChargeHistory dto = new ChargeHistory();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setTransactionTime(entity.getTransactionTime());
        dto.setValue(entity.getValue());
        dto.setResult(entity.getResult());
        dto.setExplains(entity.getExplains());
        dto.setType(entity.getType());
        dto.setSerial(entity.getSerial());
        dto.setCardCode(entity.getCardCode());
        dto.setTransId(entity.getTransId());
        dto.setPart(entity.getPart());
        return dto;
    }


    @Override
    public TblChargeHistoryEntity dto2Entity(ChargeHistory dto) {
        TblChargeHistoryEntity entity = new TblChargeHistoryEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        else
            entity.setId(0);
        entity.setUserId(dto.getUserId());
        entity.setTransactionTime(dto.getTransactionTime());
        entity.setValue(dto.getValue());
        entity.setResult(dto.getResult());
        entity.setExplains(dto.getExplains());
        entity.setType(dto.getType());
        entity.setSerial(dto.getSerial());
        entity.setCardCode(dto.getCardCode());
        entity.setTransId(dto.getTransId());
        entity.setPart(dto.getPart());
        return entity;
    }
}
