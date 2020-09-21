package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

/**
 * @author Rin-DTS
 */
@ToString
@Setter
@Getter
public class Game {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer categoryId;
    private Integer providerId;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private Integer playCount;
    private Integer status;
    private String image;
    private String thumbImage;
    private String gameIdentity;
}
