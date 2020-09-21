package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.CashoutHistory;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface CashOutHistoryService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveCashoutHistory(CashoutHistory cashoutHistory);

    BaseResponse updateCashoutHistory(CashoutHistory cashoutHistory);

    BaseResponse findAll();

    BaseResponse cashout(CashoutHistory cashOutRequest);
}
