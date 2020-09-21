package com.dts.rentgameapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
public class TblUserGameInfoEntityPK implements Serializable {
    private int userId;
    private int gameId;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        TblUserGameInfoEntityPK that = (TblUserGameInfoEntityPK) o;
        return userId == that.userId &&
                gameId == that.gameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gameId);
    }
}
