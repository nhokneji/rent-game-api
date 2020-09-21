package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_vip", schema = "ezplay", catalog = "")
public class TblVipEntity {
    private int vipId;
    private Double minAmount;
    private String vipName;

    @Id
    @Column(name = "vip_id")
    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
    }

    @Basic
    @Column(name = "min_amount")
    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    @Basic
    @Column(name = "vip_name")
    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblVipEntity that = (TblVipEntity) o;
        return vipId == that.vipId &&
                Objects.equals(minAmount, that.minAmount) &&
                Objects.equals(vipName, that.vipName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vipId, minAmount, vipName);
    }
}
