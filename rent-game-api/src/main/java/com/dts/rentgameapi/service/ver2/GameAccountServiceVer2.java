package com.dts.rentgameapi.service.ver2;

import com.dts.rentgameapi.domain.request.CreateGameAccountRequest;
import com.dts.rentgameapi.domain.request.DeleteRequest;
import com.dts.rentgameapi.domain.request.UpdateGameAccountRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.jwt.JwtUser;

/**
 * @author Rin-DTS
 */
public interface GameAccountServiceVer2 {
    BaseResponse findGameAccountByJwtUser(JwtUser jwtUser,int start,int limit);

    BaseResponse create(JwtUser jwtUser, CreateGameAccountRequest request);

    BaseResponse update(JwtUser jwtUser, UpdateGameAccountRequest request);

    BaseResponse findById(Integer id);

    BaseResponse delete(DeleteRequest request);
}
