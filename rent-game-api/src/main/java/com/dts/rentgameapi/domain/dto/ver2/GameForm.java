package com.dts.rentgameapi.domain.dto.ver2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameForm {
    private Integer id;
    private String name;
    private Integer downloadCount;
    private String desciption;
    private Integer rate;
    @JsonProperty("shopId")
    private Integer shop_id;
    private Integer playCount;
    private String image;
    private Double price;
    private String thumbImage;

    @Override
    public String toString() {
        return "GameFormMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", downloadCount=" + downloadCount +
                ", desciption='" + desciption + '\'' +
                ", rate=" + rate +
                ", shop_id=" + shop_id +
                ", playCount=" + playCount +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", thumbImage='" + thumbImage + '\'' +
                '}';
    }
}
