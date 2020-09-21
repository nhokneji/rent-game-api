package com.dts.rentgameapi.service.ver2;

import com.dts.rentgameapi.domain.request.CashoutRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.jwt.JwtUser;

/**
 * @author Rin-DTS
 */
public interface CashoutHistoryServiceVer2 {
    BaseResponse cashout(CashoutRequest request, JwtUser jwtUser);
}
