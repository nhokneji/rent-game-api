package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_notice", schema = "ezplay", catalog = "")
public class TblNoticeEntity {
    private int id;
    private String title;
    private String content;
    private Timestamp createdTime;
    private Timestamp expireTime;
    private Integer publish;
    private Timestamp publishTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    @Column(name = "expire_time")
    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    @Basic
    @Column(name = "publish")
    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    @Basic
    @Column(name = "publish_time")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblNoticeEntity that = (TblNoticeEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(expireTime, that.expireTime) &&
                Objects.equals(publish, that.publish) &&
                Objects.equals(publishTime, that.publishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createdTime, expireTime, publish, publishTime);
    }
}
