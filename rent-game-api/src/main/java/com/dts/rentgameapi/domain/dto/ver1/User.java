package com.dts.rentgameapi.domain.dto.ver1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String email;
    private String moblie;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp lastLoginTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Timestamp lastUpdateTime;
    private Integer level;
    private Integer vip;
    private Double balance;
    private Double totalAmount;
    private Integer playCount;
    private Integer status;
    private Integer refrenceId;
    private String accessToken;
    private String validToken;
    private String token;
    private Integer shopId;
    private String shopName;
    private String avatar;
    private String display_name;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", moblie='" + moblie + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", level=" + level +
                ", vip=" + vip +
                ", balance=" + balance +
                ", totalAmount=" + totalAmount +
                ", playCount=" + playCount +
                ", status=" + status +
                ", refrenceId=" + refrenceId +
                ", accessToken='" + accessToken + '\'' +
                ", validToken='" + validToken + '\'' +
                ", token='" + token + '\'' +
                ", shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", display_name='" + display_name + '\'' +
                '}';
    }
}
