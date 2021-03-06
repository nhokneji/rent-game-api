package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Rin-DTS
 */
@ToString
@Getter
@Setter
public class News {
    private int id;
    private String title;
    private String content;
    private String thumbImage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date createdTime;
    private Integer publish;
    private Integer isHot;
    private String sliceImage;
}
