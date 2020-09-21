package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rin-DTS
 */
@Setter
@Getter
@ToString
public class Affiliate {
    private int id;
    private Integer balance;
    private Integer userId;
    private User user;
}
