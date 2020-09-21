package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_cashout_history", schema = "ezplay", catalog = "")
public class TblCashoutHistoryEntity {
    private int id;
    private double amount;
    private Integer part;
    private int result;
    private Double lastBalance;
    private Timestamp createdTime;
    private int status;
    private Integer shopId;
    private double afterBalance;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
    @Column(name = "result")
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Basic
    @Column(name = "last_balance")
    public Double getLastBalance() {
        return lastBalance;
    }

    public void setLastBalance(Double lastBalance) {
        this.lastBalance = lastBalance;
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
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    @Column(name = "after_balance")
    public double getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(double afterBalance) {
        this.afterBalance = afterBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblCashoutHistoryEntity entity = (TblCashoutHistoryEntity) o;
        return id == entity.id &&
                Double.compare(entity.amount, amount) == 0 &&
                result == entity.result &&
                status == entity.status &&
                Double.compare(entity.afterBalance, afterBalance) == 0 &&
                Objects.equals(part, entity.part) &&
                Objects.equals(lastBalance, entity.lastBalance) &&
                Objects.equals(createdTime, entity.createdTime) &&
                Objects.equals(shopId, entity.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, part, result, lastBalance, createdTime, status, shopId, afterBalance);
    }
}
