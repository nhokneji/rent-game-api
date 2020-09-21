package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
@ToString
public class GameStore {
    private Integer id;
    private String name;
    private String desciption;
}