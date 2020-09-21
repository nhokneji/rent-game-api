package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.ChargeHistory;
import com.dts.rentgameapi.domain.request.ChargeRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface ChargeHistoryService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveChargeHistory(ChargeRequest request);

    BaseResponse updateChargeHistory(ChargeHistory chargeHistory);

    BaseResponse findAll();
}
