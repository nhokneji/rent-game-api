package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.RentHistory;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface RentHistoryService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveRentHistory(RentHistory rentHistory);

    BaseResponse updateRentHistory(RentHistory rentHistory);

    BaseResponse findAll();
}
