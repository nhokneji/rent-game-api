package com.dts.rentgameapi.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class CreateGameAccountRequest {
    @JsonProperty("game_id")
    private Integer gameId;
    private String account;
    private String password;
    @JsonProperty("rent_time")
    private Long rentTime;
    @JsonProperty("expire_time")
    private Long expireTime;
    private Double price;
    private String description;

    public boolean validate() {
        if (gameId == null || account == null || price == null || expireTime == null || description == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CreateGameAccountRequest{" +
                "gameId=" + gameId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", rentTime=" + rentTime +
                ", description=" + description +
                ", expireTime=" + expireTime +
                ", price=" + price +
                '}';
    }
}
