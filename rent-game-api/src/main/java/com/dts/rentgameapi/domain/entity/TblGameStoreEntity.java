package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_game_store", schema = "ezplay", catalog = "")
public class TblGameStoreEntity {
    private int id;
    private String name;
    private String desciption;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "desciption")
    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblGameStoreEntity that = (TblGameStoreEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(desciption, that.desciption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desciption);
    }
}
