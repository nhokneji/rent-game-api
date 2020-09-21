package com.dts.rentgameapi.domain.dto.ver2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameOwner {
    private Integer id;
    private String name;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    private Integer playCount;
    private Double price;
    private String image;
    private String thumbImage;
    private Integer status;
    private Integer shopId;

    @Override
    public String toString() {
        return "GameOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", downloadCount=" + downloadCount +
                ", desciption='" + desciption + '\'' +
                ", rate=" + rate +
                ", playCount=" + playCount +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                ", status=" + status +
                ", shopId=" + shopId +
                '}';
    }
}
