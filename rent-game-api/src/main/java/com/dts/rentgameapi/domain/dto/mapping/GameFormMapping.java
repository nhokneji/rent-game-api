package com.dts.rentgameapi.domain.dto.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class GameFormMapping {
    private Integer id;
    private String name;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private Integer shopId;
    private Integer playCount;
    private String image;
    private String thumbImage;

    public GameFormMapping(Integer id, String name, Integer downloadCount, String desciption, Integer rate, Integer shopId, Integer playCount, String image, String thumbImage) {
        this.id = id;
        this.name = name;
        this.downloadCount = downloadCount;
        this.desciption = desciption;
        this.rate = rate;
        this.shopId = shopId;
        this.playCount = playCount;
        this.image = image;
        this.thumbImage = thumbImage;
    }

    @Override
    public String toString() {
        return "GameFormMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", downloadCount=" + downloadCount +
                ", desciption='" + desciption + '\'' +
                ", rate=" + rate +
                ", shopId=" + shopId +
                ", playCount=" + playCount +
                ", image='" + image + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                '}';
    }
}
