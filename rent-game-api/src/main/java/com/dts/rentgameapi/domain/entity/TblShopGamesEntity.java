package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_shop_games", schema = "ezplay", catalog = "")
@IdClass(TblShopGamesEntityPK.class)
public class TblShopGamesEntity {
    private int shopId;
    private int gameId;

    @Id
    @Column(name = "shop_id")
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Id
    @Column(name = "game_id")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblShopGamesEntity that = (TblShopGamesEntity) o;
        return shopId == that.shopId &&
                gameId == that.gameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, gameId);
    }
}
