package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

/**
 * @author Rin-DTS
 */
@ToString
@Getter
@Setter
public class Category {
    private int id;
    private String name;
    private String desciption;
    private String image;
}
