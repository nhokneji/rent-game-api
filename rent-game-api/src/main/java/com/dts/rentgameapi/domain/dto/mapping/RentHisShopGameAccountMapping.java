package com.dts.rentgameapi.domain.dto.mapping;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@Setter
@Getter
public class RentHisShopGameAccountMapping {
    private Integer id;
    private Integer account_id;
    private double amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date start_time;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private Date stop_time;
    private Integer part;
    private String rent_user;
    private Integer shop_id;
    private Integer user_id;
    private Integer status;
    private String game;
    private Integer game_id;
    private Integer duration;
    private String account;


    public RentHisShopGameAccountMapping(Integer id, Integer account_id, double amount, Date start_time, Date stop_time, Integer part, String rent_user, Integer shop_id, Integer user_id, Integer status, String game, Integer game_id, Integer duration, String account) {
        this.id = id;
        this.account_id = account_id;
        this.amount = amount;
        this.start_time = start_time;
        this.stop_time = stop_time;
        this.part = part;
        this.rent_user = rent_user;
        this.shop_id = shop_id;
        this.user_id = user_id;
        this.status = status;
        this.game = game;
        this.game_id = game_id;
        this.duration = duration;
        this.account = account;
    }

    @Override
    public String toString() {
        return "RentHisShopGameAccountMapping{" +
                "id=" + id +
                ", account_id=" + account_id +
                ", amount=" + amount +
                ", start_time=" + start_time +
                ", stop_time=" + stop_time +
                ", part=" + part +
                ", rent_user='" + rent_user + '\'' +
                ", shop_id=" + shop_id +
                ", user_id=" + user_id +
                ", status=" + status +
                ", game='" + game + '\'' +
                ", game_id=" + game_id +
                ", duration=" + duration +
                ", account='" + account + '\'' +
                '}';
    }
}
