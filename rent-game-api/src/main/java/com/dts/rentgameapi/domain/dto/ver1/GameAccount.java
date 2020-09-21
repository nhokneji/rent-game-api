package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class GameAccount {
    private Integer id;
    private Integer gameId;
    private String account;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp createdTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp lastUpdateTime;
    private Integer status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp rentTime;
    private Integer rentCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp expireTime;
    private Integer shopId;
    private Double price;
    private String description;

    @Override
    public String toString() {
        return "GameAccount{" +
                "id=" + id +
                ", gameId=" + gameId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", createdTime=" + createdTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", status=" + status +
                ", rentTime=" + rentTime +
                ", rentCount=" + rentCount +
                ", expireTime=" + expireTime +
                ", shopId=" + shopId +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
