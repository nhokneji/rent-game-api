package com.dts.rentgameapi.domain.dto.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Rin-DTS
 */
@Setter
@Getter
public class GameAggregateMoneyMapping {
    @JsonProperty("game_name")
    private String game;
    private Integer game_id;
    private Integer total_amount;
    private Integer total_duration;

    public GameAggregateMoneyMapping(String game, Integer game_id, Integer total_amount, Integer total_duration) {
        this.game = game;
        this.game_id = game_id;
        this.total_amount = total_amount;
        this.total_duration = total_duration;
    }

    @Override
    public String toString() {
        return "GameAggregateMoneyMapping{" +
                "game='" + game + '\'' +
                ", game_id=" + game_id +
                ", total_amount=" + total_amount +
                ", total_duration=" + total_duration +
                '}';
    }
}
