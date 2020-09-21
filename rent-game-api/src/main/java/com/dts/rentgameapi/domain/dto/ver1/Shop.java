package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
@ToString
public class Shop {
    private int id;
    private String shopName;
    private String alias;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp createdTime;
    private Double balance;
    private Integer userId;
    private String facebookLink;
    private String iconPath;
    private String linkShop;
    private String slogan;
    private String description;
    private String phone;
}