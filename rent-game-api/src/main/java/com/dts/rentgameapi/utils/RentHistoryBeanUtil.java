package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.RentHistory;
import com.dts.rentgameapi.domain.entity.TblRentHistoryEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class RentHistoryBeanUtil implements IDataConvert<RentHistory, TblRentHistoryEntity> {
//    @Autowired
//    private ShopDaoImpl shopDaoImpl;
//
//    @Autowired
//    private GameAccountDaoImpl gameAccountDaoImpl;

    @Override
    public RentHistory entity2Dto(TblRentHistoryEntity entity) {
        RentHistory dto = new RentHistory();
        dto.setId(entity.getId());
        dto.setAccountId(entity.getAccountId());
        dto.setShopId(entity.getShopId());
        dto.setAmount(entity.getAmount());
        dto.setRentUser(entity.getRentUser());
        dto.setStartTime(entity.getStartTime());
        dto.setStopTime(entity.getStopTime());
        dto.setPart(entity.getPart());
        dto.setUserId(entity.getUserId());
        dto.setStatus(entity.getStatus());
        dto.setGame(entity.getGame());
        dto.setDuration(entity.getDuration());
        dto.setGameId(entity.getGameId());
        return dto;
    }

    @Override
    public TblRentHistoryEntity dto2Entity(RentHistory dto) {
        TblRentHistoryEntity entity = new TblRentHistoryEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setShopId(dto.getUserId());
        entity.setAmount(dto.getAmount());
        entity.setRentUser(dto.getRentUser());
        entity.setStartTime(dto.getStartTime());
        entity.setStopTime(dto.getStopTime());
        entity.setPart(dto.getPart());
        entity.setRentUser(dto.getRentUser());
        entity.setAccountId(dto.getAccountId());
        entity.setStatus(dto.getStatus());
        entity.setGame(dto.getGame());
        entity.setGameId(dto.getGameId());
        entity.setDuration(dto.getDuration());
        return entity;
    }
}
