package com.dts.rentgameapi.service.ver2;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.jwt.JwtUser;

/**
 * @author Rin-DTS
 */
public interface RentHistoryServiceVer2 {
    BaseResponse aggrevate(Integer status, JwtUser retrieveJwtUser);

    BaseResponse rentGameHistoryByShop(JwtUser retrieveJwtUser, Integer start, Integer limit);
}
