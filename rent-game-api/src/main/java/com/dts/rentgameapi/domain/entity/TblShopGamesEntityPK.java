package com.dts.rentgameapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
public class TblShopGamesEntityPK implements Serializable {
    private int shopId;
    private int gameId;

    @Column(name = "shop_id")
    @Id
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Column(name = "game_id")
    @Id
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
        TblShopGamesEntityPK that = (TblShopGamesEntityPK) o;
        return shopId == that.shopId &&
                gameId == that.gameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, gameId);
    }
}
