package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.Game;
import com.dts.rentgameapi.domain.dto.ver1.Provider;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import com.dts.rentgameapi.domain.entity.TblProviderEntity;
import com.dts.rentgameapi.domain.response.ListGameResponse;
import com.dts.rentgameapi.domain.response.ProviderResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.GameRepo;
import com.dts.rentgameapi.repo.ProviderRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.ProviderService;
import com.dts.rentgameapi.utils.GameBeanUtil;
import com.dts.rentgameapi.utils.ProviderBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class ProviderServiceImpl extends BaseService implements ProviderService {
    @Autowired
    private ProviderRepo providerRepo;
    @Autowired
    private ProviderBeanUtil providerBeanUtil;

    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private GameBeanUtil gameBeanUtil;
    @Override
    public BaseResponse findById(Integer id) {
        ProviderResponse response = new ProviderResponse();
        Provider provider = null;
        try {
            TblProviderEntity providerEntity = providerRepo.findById(id).get();
            provider = providerBeanUtil.entity2Dto(providerEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (provider == null)
            response.setItemNotFound();
        else
            response.setSuccess(provider);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveProvide(Provider provider) {
        TblProviderEntity re = null;
        try {
            TblProviderEntity entity = providerBeanUtil.dto2Entity(provider);
            re = providerRepo.save(entity);
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
    public BaseResponse updateProvide(Provider provider) {
        TblProviderEntity result = null;
        try {
            TblProviderEntity entity = providerBeanUtil.dto2Entity(provider);
            result = providerRepo.save(entity);
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

    public BaseResponse findAllGame(Integer pro_id) {
        ListGameResponse response = new ListGameResponse();
        List<TblGameEntity> result = new ArrayList<>();
        List<Game> games = new ArrayList<>();
        long total = 0;
        try {
            result = gameRepo.findAllByProviderId(pro_id);
            result.forEach(tblGameEntity -> {
                games.add(gameBeanUtil.entity2Dto(tblGameEntity));
            });
            total=result.size();
        } catch (Exception e) {
            response.setResult(games, total, e.getMessage());
            return response;
        }
        if (result == null) {
            response.setSuccess(games, total);
        } else {
            response.setSuccess(games, total);
        }
        return response;

    }

    public BaseResponse getListGameByPages(Integer pro_id, Integer start, Integer limit) {
        ListGameResponse response = new ListGameResponse();
        List<TblGameEntity> result = new ArrayList<>();
        List<Game> games = new ArrayList<>();
        long total = 0;
        try {
            result = gameRepo.findGamesByProviderId(pro_id, start, limit);
            result.forEach(tblGameEntity -> {
                games.add(gameBeanUtil.entity2Dto(tblGameEntity));
            });
            total=gameRepo.countByProviderId(pro_id);
        } catch (Exception e) {
            response.setResult(games, total, e.getMessage());
            return response;
        }
        if (result == null) {
            response.setSuccess(games, total);
        } else {
            response.setSuccess(games, total);
        }
        return response;
    }
}
