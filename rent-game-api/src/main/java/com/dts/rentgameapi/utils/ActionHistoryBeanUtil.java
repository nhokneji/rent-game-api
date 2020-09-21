package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.ActionHistory;
import com.dts.rentgameapi.domain.entity.TblActionHistoryEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component

public class ActionHistoryBeanUtil implements IDataConvert<ActionHistory, TblActionHistoryEntity> {
    @Override
    public ActionHistory entity2Dto(TblActionHistoryEntity entity) {
        ActionHistory dto = new ActionHistory();
        dto.setId(entity.getId());
        dto.setAction(entity.getAction());
        dto.setActionTime(entity.getActionTime());
        dto.setResult(entity.getResult());
        //  dto.setUserEntity(entity.getAction_history_user());
        dto.setIp(entity.getIp());
        dto.setPart(entity.getPart());
        return dto;
    }

    @Override
    public TblActionHistoryEntity dto2Entity(ActionHistory dto) {
        TblActionHistoryEntity entity = new TblActionHistoryEntity();
        entity.setId(dto.getId());
        entity.setAction(dto.getAction());
        entity.setActionTime(dto.getActionTime());
        entity.setResult(dto.getResult());
        // entity.setAction_history_user(dto.getUserEntity());
        entity.setIp(dto.getIp());
        entity.setPart(dto.getPart());
        return entity;
    }

}
