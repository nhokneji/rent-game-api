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
public class RentHistory {
    private Integer id;
    private Integer accountId;
    private double amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp stopTime;
    private Integer part;
    private String rentUser;
    private Integer shopId;
    private Integer userId;
    private Integer status;
    private String game;
    private Integer gameId;
    private Integer duration;


    public enum Status {
        ENABLE(0),//dang thue
        DISABLE(1);//thu xong
        private int status;

        Status(int status) {
            this.status = status;
        }

        public static RentHistory.Status getStatus(int type) {
            for (RentHistory.Status status : RentHistory.Status.values()) {
                if (status.status == type) {
                    return status;
                }
            }
            return null;
        }

        public int getValue() {
            return status;
        }
    }

}
