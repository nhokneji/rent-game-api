package com.dts.rentgameapi.domain.dto.ver2;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class GameSlider {
    private Integer id;
    private String name;
    private String desciption;
    private String image;
    private String thumbImage;

    @Override
    public String toString() {
        return "GameSliderMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desciption='" + desciption + '\'' +
                ", image='" + image + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                '}';
    }
}
