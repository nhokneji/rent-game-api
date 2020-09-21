package com.dts.rentgameapi.domain.dto.mapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Entity
public class RentChargeHistoryEntity {
    @Id
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    @JsonProperty("created_at")
    private Date transactionTime;

    @JsonProperty("amount")
    private Integer value;

    @JsonProperty("description")
    private String explains;

    private String serial;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("display_name")
    private String displayName;


    @Override
    public String toString() {
        return "RentChargeHistoryEntity{" +
                "id=" + id +
                ", transactionTime=" + transactionTime +
                ", value=" + value +
                ", explains='" + explains + '\'' +
                ", serial='" + serial + '\'' +
                ", userId=" + userId +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
