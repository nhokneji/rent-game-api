package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.GameDownload;
import com.dts.rentgameapi.domain.entity.TblGameDownloadEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class GameDownloadBeanUtil implements IDataConvert<GameDownload, TblGameDownloadEntity> {

    @Override
    public GameDownload entity2Dto(TblGameDownloadEntity entity) {
        GameDownload dto = new GameDownload();
        dto.setId(entity.getId());
        dto.setGameId(entity.getGameId());
        dto.setLink(entity.getLink());
        dto.setPublish(entity.getPublish());
        dto.setVersion(entity.getVersion());
        return dto;
    }

    @Override
    public TblGameDownloadEntity dto2Entity(GameDownload dto) {
        TblGameDownloadEntity entity = new TblGameDownloadEntity();
        if (dto.getId() != null)
            entity.setId(dto.getId());
        entity.setGameId(dto.getGameId());
        entity.setLink(dto.getLink());
        entity.setPublish(dto.getPublish());
        entity.setVersion(dto.getVersion());
        return entity;
    }
}
