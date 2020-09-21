package com.dts.rentgameapi.domain.entity;

import com.dts.rentgameapi.domain.dto.mapping.DetailGameAccountMapping;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_game_account", schema = "ezplay", catalog = "")
@SqlResultSetMapping(name = "DetailGameAccountEntityMapping",
        classes = @ConstructorResult(
                targetClass = DetailGameAccountMapping.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "game_id", type = Integer.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "password", type = String.class),
                        @ColumnResult(name = "status", type = Integer.class),
                        @ColumnResult(name = "rent_time", type = Timestamp.class),
                        @ColumnResult(name = "rent_count", type = Integer.class),
                        @ColumnResult(name = "expire_time", type = Timestamp.class),
                        @ColumnResult(name = "created_time", type = Timestamp.class),
                        @ColumnResult(name = "account", type = String.class),
                        @ColumnResult(name = "price", type = Double.class)
                }
        ))

public class TblGameAccountEntity {
    private int id;
    private int gameId;
    private String password;
    private Timestamp createdTime;
    private Timestamp lastUpdateTime;
    private int status;
    private Timestamp rentTime;
    private int rentCount;
    private Timestamp expireTime;
    private String account;
    private int shopId;
    private double price;
    private String description;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "game_id")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
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
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "rent_time")
    public Timestamp getRentTime() {
        return rentTime;
    }

    public void setRentTime(Timestamp rentTime) {
        this.rentTime = rentTime;
    }

    @Basic
    @Column(name = "rent_count")
    public int getRentCount() {
        return rentCount;
    }

    public void setRentCount(int rentCount) {
        this.rentCount = rentCount;
    }

    @Basic
    @Column(name = "expire_time")
    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "shop_id")
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblGameAccountEntity that = (TblGameAccountEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                status == that.status &&
                rentCount == that.rentCount &&
                shopId == that.shopId &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(password, that.password) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(lastUpdateTime, that.lastUpdateTime) &&
                Objects.equals(rentTime, that.rentTime) &&
                Objects.equals(expireTime, that.expireTime) &&
                Objects.equals(account, that.account) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameId, password, createdTime, lastUpdateTime, status, rentTime, rentCount, expireTime, account, shopId, price, description);
    }
}
