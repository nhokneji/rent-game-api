package com.dts.rentgameapi.service.ver2;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.jwt.JwtUser;

/**
 * @author Rin-DTS
 */
public interface ChargeServiceVer2 {
    BaseResponse findChargeHistoryByUser(JwtUser retrieveJwtUser, int start, int limit,String sort);
}
