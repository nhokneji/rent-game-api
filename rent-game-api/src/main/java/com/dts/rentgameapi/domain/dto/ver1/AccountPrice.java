package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rin-DTS
 */
@ToString
@Getter
@Setter
public class AccountPrice {
    private int id;
    private Integer acountId;
    private Integer price;
    private Integer duration;
}
