package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.Shop;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface ShopService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveShop(Shop shop);

    BaseResponse updateShop(Shop shop);

    BaseResponse findAll();
}
