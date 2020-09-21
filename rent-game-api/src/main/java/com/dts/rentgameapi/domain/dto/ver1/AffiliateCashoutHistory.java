package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@ToString
@Setter
@Getter
public class AffiliateCashoutHistory {
    private int id;
    private Integer affiliateId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp createdTime;
    private double amount;
    private Integer result;
    private Affiliate affiliate;
}
