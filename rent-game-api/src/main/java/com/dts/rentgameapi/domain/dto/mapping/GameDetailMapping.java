package com.dts.rentgameapi.domain.dto.mapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class GameDetailMapping {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer categoryId;
    private Integer providerId;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private String image;
    private String thumbImage;
    private String gameIdentity;
    private String linkVideo;
    private Integer playCount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date updatedAt;
    private Integer shopId;
    private String shopName;
    private String alias;
    private Double price;


    public GameDetailMapping(Integer id, String name, Integer storeId, Integer categoryId, Integer providerId, Integer downloadCount, String desciption, Integer rate, String image, String thumbImage, String gameIdentity, String linkVideo, Integer playCount, Date createdAt, Date updatedAt, Integer shopId, String shopName, String alias) {
        this.id = id;
        this.name = name;
        this.storeId = storeId;
        this.categoryId = categoryId;
        this.providerId = providerId;
        this.downloadCount = downloadCount;
        this.desciption = desciption;
        this.rate = rate;
        this.image = image;
        this.thumbImage = thumbImage;
        this.gameIdentity = gameIdentity;
        this.linkVideo = linkVideo;
        this.playCount = playCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.shopId = shopId;
        this.shopName = shopName;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "GameDetailMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", storeId=" + storeId +
                ", categoryId=" + categoryId +
                ", providerId=" + providerId +
                ", downloadCount=" + downloadCount +
                ", desciption='" + desciption + '\'' +
                ", rate=" + rate +
                ", image='" + image + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                ", gameIdentity='" + gameIdentity + '\'' +
                ", linkVideo='" + linkVideo + '\'' +
                ", playCount=" + playCount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", alias='" + alias + '\'' +
                ", price=" + price +
                '}';
    }
}
