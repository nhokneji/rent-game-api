package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class StopRentGame {
    private Integer minutes;
    private Double price;
    private double amount;
    private Integer status;
}
