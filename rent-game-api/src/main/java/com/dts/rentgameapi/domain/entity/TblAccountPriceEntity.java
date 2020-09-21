package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_account_price", schema = "ezplay", catalog = "")
public class TblAccountPriceEntity {
    private int id;
    private Integer acountId;
    private Integer price;
    private Integer duration;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "acount_id")
    public Integer getAcountId() {
        return acountId;
    }

    public void setAcountId(Integer acountId) {
        this.acountId = acountId;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblAccountPriceEntity that = (TblAccountPriceEntity) o;
        return id == that.id &&
                Objects.equals(acountId, that.acountId) &&
                Objects.equals(price, that.price) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, acountId, price, duration);
    }
}
