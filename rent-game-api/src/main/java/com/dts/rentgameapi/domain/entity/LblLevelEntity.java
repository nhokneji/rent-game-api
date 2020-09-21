package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "lbl_level", schema = "ezplay", catalog = "")
public class LblLevelEntity {
    private int id;
    private int level;
    private int minPlayCount;
    private String lblLevelcol;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "min_play_count")
    public int getMinPlayCount() {
        return minPlayCount;
    }

    public void setMinPlayCount(int minPlayCount) {
        this.minPlayCount = minPlayCount;
    }

    @Basic
    @Column(name = "lbl_levelcol")
    public String getLblLevelcol() {
        return lblLevelcol;
    }

    public void setLblLevelcol(String lblLevelcol) {
        this.lblLevelcol = lblLevelcol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LblLevelEntity that = (LblLevelEntity) o;
        return id == that.id &&
                level == that.level &&
                minPlayCount == that.minPlayCount &&
                Objects.equals(lblLevelcol, that.lblLevelcol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level, minPlayCount, lblLevelcol);
    }
}
