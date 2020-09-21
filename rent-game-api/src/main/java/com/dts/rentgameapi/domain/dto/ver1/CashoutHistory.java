package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author Rin-DTS
 */
@Setter
@Getter
@ToString
public class CashoutHistory {
    private Integer id;
    private double amount;
    private Integer part;
    private Integer result;
    private double lastBalance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp createdTime;
    private Integer path;
    private Integer status;
    private Integer shopId;
}
