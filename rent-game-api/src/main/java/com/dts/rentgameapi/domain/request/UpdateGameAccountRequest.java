package com.dts.rentgameapi.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Setter
@Getter
public class UpdateGameAccountRequest {
    private Integer acc_id;
    private String password;
    @JsonProperty("rent_time")
    private Long rentTime;
    @JsonProperty("expire_time")
    private Long expireTime;
    private Double price;
    private String description;

    public boolean validate() {
        if (acc_id == null || price == null || expireTime == null || description == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UpdateGameAccountRequest{" +
                "acc_id=" + acc_id +
                ", password='" + password + '\'' +
                ", rentTime=" + rentTime +
                ", expireTime=" + expireTime +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
