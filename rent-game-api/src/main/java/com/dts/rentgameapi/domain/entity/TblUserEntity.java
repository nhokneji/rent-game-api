package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_user", schema = "ezplay", catalog = "")
public class TblUserEntity {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String moblie;
    private Timestamp createTime;
    private Timestamp lastLoginTime;
    private Timestamp lastUpdateTime;
    private int level;
    private int vip;
    private double balance;
    private double totalAmount;
    private int playCount;
    private int status;
    private Integer refrenceId;
    private String accessToken;
    private String validToken;
    private String token;
    private String avatar;
    private String displayName;
    private int type;

    public enum Type {
        OTHER("other", 0),
        APP("app", 1),
        FACEBOOK("facebook", 2);

        private String typeName;
        private int typeValue;

        Type(String typeName, int typeValue) {
            this.typeName = typeName;
            this.typeValue = typeValue;
        }

        public static Type getType(String name) {
            for (Type type : Type.values()) {
                if (type.typeName.equals(name)) {
                    return type;
                }
            }
            return null;
        }

        public String getTypeName() {
            return typeName;
        }

        public int getTypeValue() {
            return typeValue;
        }
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "moblie")
    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "last_update_time")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "vip")
    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "total_amount")
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    @Column(name = "play_count")
    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "refrence_id")
    public Integer getRefrenceId() {
        return refrenceId;
    }

    public void setRefrenceId(Integer refrenceId) {
        this.refrenceId = refrenceId;
    }

    @Basic
    @Column(name = "access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Basic
    @Column(name = "valid_token")
    public String getValidToken() {
        return validToken;
    }

    public void setValidToken(String validToken) {
        this.validToken = validToken;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblUserEntity that = (TblUserEntity) o;
        return userId == that.userId &&
                level == that.level &&
                vip == that.vip &&
                Double.compare(that.balance, balance) == 0 &&
                Double.compare(that.totalAmount, totalAmount) == 0 &&
                playCount == that.playCount &&
                status == that.status &&
                type == that.type &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(moblie, that.moblie) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastLoginTime, that.lastLoginTime) &&
                Objects.equals(lastUpdateTime, that.lastUpdateTime) &&
                Objects.equals(refrenceId, that.refrenceId) &&
                Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(validToken, that.validToken) &&
                Objects.equals(token, that.token) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(displayName, that.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, email, moblie, createTime, lastLoginTime, lastUpdateTime, level, vip, balance, totalAmount, playCount, status, refrenceId, accessToken, validToken, token, avatar, displayName, type);
    }
}
