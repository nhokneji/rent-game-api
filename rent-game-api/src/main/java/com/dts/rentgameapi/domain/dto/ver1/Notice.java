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
public class Notice {
    private int id;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy hh:MM:ss")
    private Date createdTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy hh:MM:ss")
    private Date expireTime;
    private Integer publish;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy hh:MM:ss")
    private Date publishTime;

}