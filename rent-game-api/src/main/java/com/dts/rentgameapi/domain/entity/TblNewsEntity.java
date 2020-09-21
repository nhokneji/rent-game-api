package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_news", schema = "ezplay", catalog = "")
public class TblNewsEntity {
    private int id;
    private String title;
    private String content;
    private Integer publish;
    private Timestamp createdTime;
    private Integer isHot;
    private String sliceImage;
    private String thumbImage;

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
    @Column(name = "publish")
    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
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
    @Column(name = "is_hot")
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    @Basic
    @Column(name = "slice_image")
    public String getSliceImage() {
        return sliceImage;
    }

    public void setSliceImage(String sliceImage) {
        this.sliceImage = sliceImage;
    }

    @Basic
    @Column(name = "thumb_image")
    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblNewsEntity that = (TblNewsEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(publish, that.publish) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(isHot, that.isHot) &&
                Objects.equals(sliceImage, that.sliceImage) &&
                Objects.equals(thumbImage, that.thumbImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, publish, createdTime, isHot, sliceImage, thumbImage);
    }
}
