package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.GameDownload;
import com.dts.rentgameapi.domain.entity.TblGameDownloadEntity;
import com.dts.rentgameapi.domain.response.GameDownloadResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.GameDownloadRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.GameDownloadService;
import com.dts.rentgameapi.utils.GameDownloadBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class GameDownloadServiceImpl extends BaseService implements GameDownloadService {

    @Autowired
    private GameDownloadRepo gameDownloadRepo;

    @Autowired
    private GameDownloadBeanUtil gameDownloadBeanUtil;

    @Override
    public BaseResponse findById(Integer id) {
        GameDownloadResponse response = new GameDownloadResponse();
        GameDownload gameDownload = null;
        try {
            TblGameDownloadEntity entity = gameDownloadRepo.findById(id).get();
            gameDownload = gameDownloadBeanUtil.entity2Dto(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (gameDownload == null)
            response.setItemNotFound();
        else
            response.setSuccess(gameDownload);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveGameDownload(GameDownload gameDownload) {
        TblGameDownloadEntity re = null;
        try {
            TblGameDownloadEntity entity = gameDownloadBeanUtil.dto2Entity(gameDownload);
            re = gameDownloadRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (re == null)
            response.setResult(false, "Not save ");
        else
            response.setSuccess(true);
        return response;

    }

    @Override
    public BaseResponse updateGameDownload(GameDownload gameDownload) {
        TblGameDownloadEntity result = null;
        try {
            TblGameDownloadEntity entity = gameDownloadBeanUtil.dto2Entity(gameDownload);
            result = gameDownloadRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (result == null)
            response.setResult(false, "Not update");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse findAll() {
        return null;
    }
}
