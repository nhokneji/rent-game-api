package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_action_history", schema = "ezplay", catalog = "")
public class TblActionHistoryEntity {
    private int id;
    private Integer action;
    private String ip;
    private int result;
    private Integer part;
    private Timestamp actionTime;
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
    @Column(name = "action")
    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    @Basic
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
    @Column(name = "part")
    public Integer getPart() {
        return part;
    }

    public void setPart(Integer part) {
        this.part = part;
    }

    @Basic
    @Column(name = "action_time")
    public Timestamp getActionTime() {
        return actionTime;
    }

    public void setActionTime(Timestamp actionTime) {
        this.actionTime = actionTime;
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
        TblActionHistoryEntity that = (TblActionHistoryEntity) o;
        return id == that.id &&
                result == that.result &&
                Objects.equals(action, that.action) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(part, that.part) &&
                Objects.equals(actionTime, that.actionTime) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, ip, result, part, actionTime, userId);
    }
}
