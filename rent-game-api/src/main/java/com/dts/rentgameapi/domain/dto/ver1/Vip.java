package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
@ToString
public class Vip {
    private int vipId;
    private String vipName;
    private Double minAmount;
}
