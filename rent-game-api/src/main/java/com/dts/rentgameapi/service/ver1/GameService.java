package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.Game;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface GameService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveGame(Game game);

    BaseResponse updateGame(Game game);

    BaseResponse findAll();
}
