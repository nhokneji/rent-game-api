package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.Game;
import com.dts.rentgameapi.domain.dto.ver1.GameStore;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import com.dts.rentgameapi.domain.entity.TblGameStoreEntity;
import com.dts.rentgameapi.domain.response.GameStoreResponse;
import com.dts.rentgameapi.domain.response.ListGameResponse;
import com.dts.rentgameapi.domain.response.ListGameStoreResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.GameRepo;
import com.dts.rentgameapi.repo.GameStoreRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.GameStoreService;
import com.dts.rentgameapi.utils.GameBeanUtil;
import com.dts.rentgameapi.utils.GameStoreBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class GameStoreServiceImpl extends BaseService implements GameStoreService {
    @Autowired
    private GameStoreRepo gameStoreRepo;

    @Autowired
    private GameStoreBeanUtil gameStoreBeanUtil;

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private GameBeanUtil gameBeanUtil;


    @Override
    public BaseResponse findById(Integer id) {
        GameStoreResponse response = new GameStoreResponse();
        GameStore gameStore = null;
        try {
            TblGameStoreEntity providerEntity = gameStoreRepo.findById(id).get();
            gameStore = gameStoreBeanUtil.entity2Dto(providerEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (gameStore == null)
            response.setItemNotFound();
        else
            response.setSuccess(gameStore);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveGameStore(GameStore gameStore) {
        TblGameStoreEntity re = null;
        try {
            TblGameStoreEntity entity = gameStoreBeanUtil.dto2Entity(gameStore);
            re = gameStoreRepo.save(entity);
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
    public BaseResponse updateGameStore(GameStore gameStore) {
        TblGameStoreEntity result = null;
        try {
            TblGameStoreEntity entity = gameStoreBeanUtil.dto2Entity(gameStore);
            result = gameStoreRepo.save(entity);
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
        Iterator<TblGameStoreEntity> gameStoreEntityIterator = gameStoreRepo.findAll().iterator();
        List<GameStore> users = new ArrayList<>();
        gameStoreEntityIterator.forEachRemaining(tblUserEntity -> {
            users.add(gameStoreBeanUtil.entity2Dto(tblUserEntity));
        });
        ListGameStoreResponse response = new ListGameStoreResponse();
        response.setResult(users, users.size());
        return response;
    }


    public BaseResponse getListGameByStoreId(Integer store_id, Integer start, Integer limit) {
        ListGameResponse response = new ListGameResponse();
        List<Game> result = new ArrayList<>();
        List<TblGameEntity> gameEntities = new ArrayList<>();
        long total = 0;
        try {
            gameEntities = gameRepo.findGamesByStoreId(store_id, start, limit);

            gameEntities.forEach(tblGameEntity ->
                    result.add(gameBeanUtil.entity2Dto(tblGameEntity)));
            total = gameRepo.countByStoreId(store_id);
        } catch (Exception e) {
            response.setResult(result, total, e.getMessage());
            return response;
        }
        if (result == null) {
            response.setSuccess(result, total);
        } else {
            response.setSuccess(result, total);
        }
        return response;
    }
}
