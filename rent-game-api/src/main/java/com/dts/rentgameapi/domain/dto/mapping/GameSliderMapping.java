package com.dts.rentgameapi.domain.dto.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rin-DTS
 */

@Getter
@Setter
public class GameSliderMapping implements Serializable {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("store_id")
    private Integer store_id;

    @JsonProperty("category_id")
    private Integer category_id;

    @JsonProperty("provider_id")
    private Integer provider_id;

    @JsonProperty("download_count")
    private Integer download_count;

    @JsonProperty("desciption")
    private String desciption;

    @JsonProperty("rate")
    private Integer rate;

    @JsonProperty("play_count")
    private Integer play_count;

    @JsonProperty("image")
    private String image;

    @JsonProperty("thumb_image")
    private String thumb_image;

    @JsonProperty("game_identity")
    private String game_identity;

    @JsonProperty("slider_id")
    private Integer slider_id;

    public GameSliderMapping(Integer id, String name, Integer store_id, Integer category_id, Integer provider_id, Integer download_count, String desciption, Integer rate, Integer play_count, String image, String thumb_image, String game_identity, Integer slider_id) {
        this.id = id;
        this.name = name;
        this.store_id = store_id;
        this.category_id = category_id;
        this.provider_id = provider_id;
        this.download_count = download_count;
        this.desciption = desciption;
        this.rate = rate;
        this.play_count = play_count;
        this.image = image;
        this.thumb_image = thumb_image;
        this.game_identity = game_identity;
        this.slider_id = slider_id;
    }

    @Override
    public String toString() {
        return "GameSliderMapping{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", store_id=" + store_id +
                ", category_id=" + category_id +
                ", provider_id=" + provider_id +
                ", download_count=" + download_count +
                ", desciption='" + desciption + '\'' +
                ", rate=" + rate +
                ", play_count=" + play_count +
                ", image='" + image + '\'' +
                ", thumb_image='" + thumb_image + '\'' +
                ", game_identity='" + game_identity + '\'' +
                ", slider_id=" + slider_id +
                '}';
    }
}
