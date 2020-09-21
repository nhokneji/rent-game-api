package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_user_game_info", schema = "ezplay", catalog = "")
@IdClass(TblUserGameInfoEntityPK.class)
public class TblUserGameInfoEntity {
    private int userId;
    private int gameId;
    private int status;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "game_id")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblUserGameInfoEntity that = (TblUserGameInfoEntity) o;
        return userId == that.userId &&
                gameId == that.gameId &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, gameId, status);
    }
}
