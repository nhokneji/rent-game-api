package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author Rin-DTS
 */
@ToString
@Getter
@Setter
public class ChargeHistory {
    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp transactionTime;
    private Double value;
    private Integer result;
    private String explains;
    private Integer type;
    private String serial;
    private String cardCode;
    private String transId;
    private Integer part;
    private Integer userId;

}
