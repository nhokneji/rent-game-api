package com.dts.rentgameapi.domain.entity;

import com.dts.rentgameapi.domain.dto.mapping.RentChargeHistoryEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_charge_history", schema = "ezplay", catalog = "")
//@SqlResultSetMappings(
//        @SqlResultSetMapping(name = "RentChargeHistoryEntity",
//                classes = @ConstructorResult(
//                        targetClass = RentChargeHistoryEntity.class,
//                        columns = {
//                                @ColumnResult(name = "id"),
//                                @ColumnResult(name = "transaction_time"),
//                                @ColumnResult(name = "value"),
//                                @ColumnResult(name = "explains"),
//                                @ColumnResult(name = "serial"),
//                                @ColumnResult(name = "user_id"),
//                                @ColumnResult(name = "display_name")
//                        }
//                ))
//)
public class TblChargeHistoryEntity {
    private int id;
    private Timestamp transactionTime;
    private double value;
    private Integer result;
    private String explains;
    private int type;
    private String serial;
    private String cardCode;
    private String transId;
    private int part;
    private Integer userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transaction_time")
    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Basic
    @Column(name = "value")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "result")
    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Basic
    @Column(name = "explains")
    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "serial")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "card_code")
    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    @Basic
    @Column(name = "trans_id")
    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    @Basic
    @Column(name = "part")
    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblChargeHistoryEntity that = (TblChargeHistoryEntity) o;
        return id == that.id &&
                Double.compare(that.value, value) == 0 &&
                type == that.type &&
                part == that.part &&
                Objects.equals(transactionTime, that.transactionTime) &&
                Objects.equals(result, that.result) &&
                Objects.equals(explains, that.explains) &&
                Objects.equals(serial, that.serial) &&
                Objects.equals(cardCode, that.cardCode) &&
                Objects.equals(transId, that.transId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionTime, value, result, explains, type, serial, cardCode, transId, part, userId);
    }
}
