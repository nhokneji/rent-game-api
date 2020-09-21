package com.dts.rentgameapi.domain.response;

import com.dts.rentgameapi.domain.dto.ver1.RentHistory;
import com.dts.rentgameapi.domain.response.base.GetListResponse;

/**
 * @author Rin-DTS
 */
public class ListRentHistoryResponse extends GetListResponse<RentHistory> {

    @Override
    public String toString() {
        return "ListRentHistoryResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
