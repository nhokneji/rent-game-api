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
public class Provider {
    private Integer id;
    private String providerName;
    private String address;
    private String phone;

}
