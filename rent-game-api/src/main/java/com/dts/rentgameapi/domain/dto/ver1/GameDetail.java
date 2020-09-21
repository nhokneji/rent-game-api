package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
@ToString
public class GameDetail {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer categoryId;
    private Integer providerId;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private Integer playCount;
    private String image;
    private String thumbImage;
    private String gameIdentity;
    private String linkDown;
    private Integer publish;
    private Double version;
    private Double price;

}
