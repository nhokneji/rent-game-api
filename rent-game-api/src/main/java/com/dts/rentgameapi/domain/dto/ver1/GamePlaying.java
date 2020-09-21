package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
@ToString
public class GamePlaying {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer categoryId;
    private Integer providerId;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private Double price;
    private Integer playCount;
    private String image;
    private String thumbImage;
    private String gameIdentity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date startTime;
}
