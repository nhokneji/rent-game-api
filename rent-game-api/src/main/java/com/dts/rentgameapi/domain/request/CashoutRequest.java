package com.dts.rentgameapi.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS (Nguyễn Văn Đức 57TH4)
 */
@Getter
@Setter
public class CashoutRequest {
    private Double amount;

    public boolean validate() {
        if (amount == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CashoutRequest{" +
                "amount=" + amount +
                '}';
    }
}
