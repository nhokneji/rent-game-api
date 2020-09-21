package com.dts.rentgameapi.domain.dto.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class GameOwnerPlayedMapping {
    private Integer id;
    private String name;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private Integer shopId;
    private Integer playCount;
    private String image;
    private String thumbImage;
    private Integer status;

    public GameOwnerPlayedMapping(Integer id, String name, Integer downloadCount, String desciption, Integer rate, Integer shopId, Integer playCount, String image, String thumbImage, Integer status) {
        this.id = id;
        this.name = name;
        this.downloadCount = downloadCount;
        this.desciption = desciption;
        this.rate = rate;
        this.shopId = shopId;
        this.playCount = playCount;
        this.image = image;
        this.thumbImage = thumbImage;
        this.status = status;
    }

    @Override
    public String toString() {
        return "GameOwnerPlayedMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", downloadCount=" + downloadCount +
                ", desciption='" + desciption + '\'' +
                ", rate=" + rate +
                ", shopId=" + shopId +
                ", playCount=" + playCount +
                ", image='" + image + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                ", status=" + status +
                '}';
    }
}
