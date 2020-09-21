package com.dts.rentgameapi.domain.dto.ver1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author Rin-DTS
 */
@ToString
@Getter
@Setter
public class GameDownload implements Comparable<GameDownload> {
    private Integer id;
    private Integer gameId;
    private String link;
    private Integer publish;
    private Double version;


    @Override
    public int hashCode() {
        return Objects.hash(id, gameId, link, publish, version);
    }

    @Override
    public int compareTo(GameDownload gameDownload) {
        if (gameDownload.version == version)
            return 0;
        else if (gameDownload.version > version)
            return 1;
        else
            return -1;
    }
}