package com.dts.rentgameapi.domain.dto.mapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class DetailGameAccountMapping {
    private int id;
    private int gameId;
    private String name;
    private String password;
    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date rentTime;
    private int rentCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date expireTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date createdTime;
    private String account;
    private double price;

    public DetailGameAccountMapping(int id, int gameId, String name, String password, int status, Date rentTime, int rentCount, Date expireTime, Date createdTime, String account, double price) {
        this.id = id;
        this.gameId = gameId;
        this.name = name;
        this.password = password;
        this.status = status;
        this.rentTime = rentTime;
        this.rentCount = rentCount;
        this.expireTime = expireTime;
        this.createdTime = createdTime;
        this.account = account;
        this.price = price;
    }

    @Override
    public String toString() {
        return "DetailGameAccountMapping{" +
                "gameId=" + gameId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", rentTime=" + rentTime +
                ", rentCount=" + rentCount +
                ", expireTime=" + expireTime +
                ", account='" + account + '\'' +
                ", price=" + price +
                '}';
    }
}
