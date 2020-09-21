package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.GameStore;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface GameStoreService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveGameStore(GameStore gameStore);

    BaseResponse updateGameStore(GameStore gameStore);

    BaseResponse findAll();
}
