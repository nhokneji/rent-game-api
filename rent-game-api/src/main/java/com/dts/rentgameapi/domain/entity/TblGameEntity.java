package com.dts.rentgameapi.domain.entity;

import com.dts.rentgameapi.domain.dto.mapping.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_game", schema = "ezplay", catalog = "")
@SqlResultSetMappings(
        {
                @SqlResultSetMapping(name = "GameOwnerPlayedMapping",
                classes = @ConstructorResult(
                        targetClass = GameOwnerPlayedMapping.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "download_count", type = Integer.class),
                                @ColumnResult(name = "desciption", type = String.class),
                                @ColumnResult(name = "rate", type = Integer.class),
                                @ColumnResult(name = "shop_id", type = Integer.class),
                                @ColumnResult(name = "play_count", type = Integer.class),
                                @ColumnResult(name = "image", type = String.class),
                                @ColumnResult(name = "thumb_image", type = String.class),
                                @ColumnResult(name = "status", type = Integer.class)
                        }
                )),


                @SqlResultSetMapping(name = "GameAggregateMoneyEntityMapping",
                        classes = @ConstructorResult(
                                targetClass = GameAggregateMoneyMapping.class,
                                columns = {
                                        @ColumnResult(name = "game", type = String.class),
                                        @ColumnResult(name = "game_id", type = Integer.class),
                                        @ColumnResult(name = "total_amount", type = Integer.class),
                                        @ColumnResult(name = "total_duration", type = Integer.class),
                                }
                        )),

                @SqlResultSetMapping(name = "GameDetailMapping",
                        classes = @ConstructorResult(
                                targetClass = GameDetailMapping.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "store_id", type = Integer.class),
                                        @ColumnResult(name = "category_id", type = Integer.class),
                                        @ColumnResult(name = "provider_id", type = Integer.class),
                                        @ColumnResult(name = "download_count", type = Integer.class),
                                        @ColumnResult(name = "desciption", type = String.class),
                                        @ColumnResult(name = "rate", type = Integer.class),
                                        @ColumnResult(name = "image", type = String.class),
                                        @ColumnResult(name = "thumb_image", type = String.class),
                                        @ColumnResult(name = "game_identity", type = String.class),
                                        @ColumnResult(name = "link_video", type = String.class),
                                        @ColumnResult(name = "play_count", type = Integer.class),
                                        @ColumnResult(name = "created_at", type = Timestamp.class),
                                        @ColumnResult(name = "updated_at", type = Timestamp.class),
                                        @ColumnResult(name = "shop_id", type = Integer.class),
                                        @ColumnResult(name = "shop_name", type = String.class),
                                        @ColumnResult(name = "alias", type = String.class)
                                }
                        )),

                @SqlResultSetMapping(name = "GameFormMapping",
                        classes = @ConstructorResult(
                                targetClass = GameFormMapping.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "download_count", type = Integer.class),
                                        @ColumnResult(name = "desciption", type = String.class),
                                        @ColumnResult(name = "rate", type = Integer.class),
                                        @ColumnResult(name = "shop_id", type = Integer.class),
                                        @ColumnResult(name = "play_count", type = Integer.class),
                                        @ColumnResult(name = "image", type = String.class),
                                        @ColumnResult(name = "thumb_image", type = String.class)
                                }
                        )),


                @SqlResultSetMapping(name = "UserRentGameInfoMapping",
                        classes = @ConstructorResult(
                                targetClass = UserRentGameInfoMapping.class,
                                columns = {
                                        @ColumnResult(name = "id", type = Integer.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "store_id", type = Integer.class),
                                        @ColumnResult(name = "category_id", type = Integer.class),
                                        @ColumnResult(name = "play_count", type = Integer.class),
                                        @ColumnResult(name = "provider_id", type = Integer.class),
                                        @ColumnResult(name = "download_count", type = Integer.class),
                                        @ColumnResult(name = "desciption", type = String.class),
                                        @ColumnResult(name = "rate", type = Integer.class),
                                        @ColumnResult(name = "image", type = String.class),
                                        @ColumnResult(name = "thumb_image", type = String.class),
                                        @ColumnResult(name = "game_identity", type = String.class),
                                        @ColumnResult(name = "game_status", type = Integer.class)
                                }
                        ))
        }
)
public class TblGameEntity {
    private int id;
    private String name;
    private Integer storeId;
    private Integer categoryId;
    private Integer providerId;
    private int downloadCount;
    private String desciption;
    private int rate;
    private String image;
    private String thumbImage;
    private String gameIdentity;
    private int playCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String linkVideo;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "store_id")
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "provider_id")
    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Basic
    @Column(name = "download_count")
    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Basic
    @Column(name = "desciption")
    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Basic
    @Column(name = "rate")
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "thumb_image")
    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    @Basic
    @Column(name = "game_identity")
    public String getGameIdentity() {
        return gameIdentity;
    }

    public void setGameIdentity(String gameIdentity) {
        this.gameIdentity = gameIdentity;
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
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "link_video")
    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblGameEntity that = (TblGameEntity) o;
        return id == that.id &&
                downloadCount == that.downloadCount &&
                rate == that.rate &&
                playCount == that.playCount &&
                Objects.equals(name, that.name) &&
                Objects.equals(storeId, that.storeId) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(providerId, that.providerId) &&
                Objects.equals(desciption, that.desciption) &&
                Objects.equals(image, that.image) &&
                Objects.equals(thumbImage, that.thumbImage) &&
                Objects.equals(gameIdentity, that.gameIdentity) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(linkVideo, that.linkVideo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, storeId, categoryId, providerId, downloadCount, desciption, rate, image, thumbImage, gameIdentity, playCount, createdAt, updatedAt, linkVideo);
    }
}
