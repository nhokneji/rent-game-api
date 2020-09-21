package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@ToString
@Setter
@Getter
public class ActionHistory {
    private int id;
    private Integer action;
    private String ip;
    private Integer result;
    private Integer part;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp actionTime;
    private String userName;
    private User user;
}
