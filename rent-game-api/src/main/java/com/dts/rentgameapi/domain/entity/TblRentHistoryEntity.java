package com.dts.rentgameapi.domain.entity;

import com.dts.rentgameapi.domain.dto.mapping.RentHisShopGameAccountMapping;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_rent_history", schema = "ezplay", catalog = "")
@SqlResultSetMappings(
        {
                @SqlResultSetMapping(name = "RentHisShopGameAccountMapping",
                        classes = @ConstructorResult(
                                targetClass = RentHisShopGameAccountMapping.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "account_id", type = Integer.class),
                                        @ColumnResult(name = "amount", type = Double.class),
                                        @ColumnResult(name = "start_time", type = Timestamp.class),
                                        @ColumnResult(name = "stop_time", type = Timestamp.class),
                                        @ColumnResult(name = "part", type = Integer.class),
                                        @ColumnResult(name = "rent_user", type = String.class),
                                        @ColumnResult(name = "shop_id", type = Integer.class),
                                        @ColumnResult(name = "user_id", type = Integer.class),
                                        @ColumnResult(name = "status", type = Integer.class),
                                        @ColumnResult(name = "game", type = String.class),
                                        @ColumnResult(name = "game_id", type = Integer.class),
                                        @ColumnResult(name = "duration", type = Integer.class),
                                        @ColumnResult(name = "account", type = String.class)
                                }
                        ))
        })
public class TblRentHistoryEntity {
    private int id;
    private Integer accountId;
    private Double amount;
    private Timestamp startTime;
    private Timestamp stopTime;
    private Integer part;
    private String rentUser;
    private Integer shopId;
    private Integer userId;
    private int status;
    private String game;
    private int gameId;
    private int duration;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "stop_time")
    public Timestamp getStopTime() {
        return stopTime;
    }

    public void setStopTime(Timestamp stopTime) {
        this.stopTime = stopTime;
    }

    @Basic
    @Column(name = "part")
    public Integer getPart() {
        return part;
    }

    public void setPart(Integer part) {
        this.part = part;
    }

    @Basic
    @Column(name = "rent_user")
    public String getRentUser() {
        return rentUser;
    }

    public void setRentUser(String rentUser) {
        this.rentUser = rentUser;
    }

    @Basic
    @Column(name = "shop_id")
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Column(name = "game")
    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
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
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblRentHistoryEntity that = (TblRentHistoryEntity) o;
        return id == that.id &&
                status == that.status &&
                gameId == that.gameId &&
                duration == that.duration &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(stopTime, that.stopTime) &&
                Objects.equals(part, that.part) &&
                Objects.equals(rentUser, that.rentUser) &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, amount, startTime, stopTime, part, rentUser, shopId, userId, status, game, gameId, duration);
    }
}
