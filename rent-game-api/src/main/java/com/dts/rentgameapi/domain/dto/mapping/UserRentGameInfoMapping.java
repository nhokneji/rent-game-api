package com.dts.rentgameapi.domain.dto.mapping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class UserRentGameInfoMapping {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer categoryId;
    private Integer playCount;
    private Integer providerId;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private String image;
    private String thumbImage;
    private String gameIdentity;
    private Integer gameStatus;

    public UserRentGameInfoMapping(Integer id, String name, Integer storeId, Integer categoryId, Integer playCount, Integer providerId, Integer downloadCount, String desciption, Integer rate, String image, String thumbImage, String gameIdentity, Integer gameStatus) {
        this.id = id;
        this.name = name;
        this.storeId = storeId;
        this.categoryId = categoryId;
        this.playCount = playCount;
        this.providerId = providerId;
        this.downloadCount = downloadCount;
        this.desciption = desciption;
        this.rate = rate;
        this.image = image;
        this.thumbImage = thumbImage;
        this.gameIdentity = gameIdentity;
        this.gameStatus = gameStatus;
    }

    @Override
    public String toString() {
        return "UserRentGameInfoMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", storeId=" + storeId +
                ", categoryId=" + categoryId +
                ", playCount=" + playCount +
                ", providerId=" + providerId +
                ", downloadCount=" + downloadCount +
                ", desciption='" + desciption + '\'' +
                ", rate=" + rate +
                ", image='" + image + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                ", gameIdentity='" + gameIdentity + '\'' +
                ", gameStatus=" + gameStatus +
                '}';
    }

}
