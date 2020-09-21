package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.GameAccount;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

/**
 * @author Rin-DTS
 */
public interface GameAccountService {
    BaseResponse findById(Integer id);

    BaseResponse saveGameAccount(GameAccount gameAccount);

    BaseResponse updateGameAccount(GameAccount gameAccount);

    BaseResponse findAll();
}
