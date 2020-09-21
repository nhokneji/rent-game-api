package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_game_download", schema = "ezplay", catalog = "")
public class TblGameDownloadEntity {
    private int id;
    private Integer gameId;
    private String link;
    private Integer publish;
    private Double version;

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

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "publish")
    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    @Basic
    @Column(name = "version")
    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblGameDownloadEntity that = (TblGameDownloadEntity) o;
        return id == that.id &&
                Objects.equals(gameId, that.gameId) &&
                Objects.equals(link, that.link) &&
                Objects.equals(publish, that.publish) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameId, link, publish, version);
    }
}
