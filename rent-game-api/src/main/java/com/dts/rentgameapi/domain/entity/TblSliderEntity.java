package com.dts.rentgameapi.domain.entity;

import com.dts.rentgameapi.domain.dto.mapping.GameSliderMapping;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_slider", schema = "ezplay", catalog = "")
@SqlResultSetMappings(
        @SqlResultSetMapping(name = "GameSliderMapping",
                classes = @ConstructorResult(
                        targetClass = GameSliderMapping.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "store_id", type = Integer.class),
                                @ColumnResult(name = "category_id", type = Integer.class),
                                @ColumnResult(name = "provider_id", type = Integer.class),
                                @ColumnResult(name = "download_count", type = Integer.class),
                                @ColumnResult(name = "desciption", type = String.class),
                                @ColumnResult(name = "rate", type = Integer.class),
                                @ColumnResult(name = "play_count", type = Integer.class),
                                @ColumnResult(name = "image", type = String.class),
                                @ColumnResult(name = "thumb_image", type = String.class),
                                @ColumnResult(name = "game_identity", type = String.class),
                                @ColumnResult(name = "slider_id", type = Integer.class)
                        }
                ))
)
public class TblSliderEntity {
    private int id;
    private Integer gameId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "game_id")
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblSliderEntity that = (TblSliderEntity) o;
        return id == that.id &&
                Objects.equals(gameId, that.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameId);
    }
}
