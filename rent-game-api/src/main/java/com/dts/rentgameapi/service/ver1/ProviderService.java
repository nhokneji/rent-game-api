package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.Provider;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface ProviderService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveProvide(Provider provider);

    BaseResponse updateProvide(Provider provider);

    BaseResponse findAll();
}
