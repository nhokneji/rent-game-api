package com.dts.rentgameapi.service.ver2;

import com.dts.rentgameapi.domain.request.CreateShopRequset;
import com.dts.rentgameapi.domain.request.UpdateShopRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.security.jwt.JwtUser;
import org.springframework.http.HttpHeaders;

/**
 * @author Rin-DTS
 */
public interface ShopServiceVer2 {
    BaseResponse checkShopName(JwtUser jwtUser);
    BaseResponse createShop(CreateShopRequset requset, JwtUser jwtUser);

    BaseResponse update(UpdateShopRequest request, JwtUser header);

    BaseResponse findGameAccountByShop(JwtUser retrieveJwtUser);
}
