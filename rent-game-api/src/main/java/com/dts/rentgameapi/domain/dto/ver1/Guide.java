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
@Setter
@Getter
public class Guide {
    private int guideId;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date createdTime;
    private Integer status;

}
