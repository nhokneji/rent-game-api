package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.GameDownload;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface GameDownloadService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveGameDownload(GameDownload gameDownload);

    BaseResponse updateGameDownload(GameDownload gameDownload);

    BaseResponse findAll();
}
