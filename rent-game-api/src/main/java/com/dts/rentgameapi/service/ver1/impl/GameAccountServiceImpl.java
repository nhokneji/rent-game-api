package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.GameAccount;
import com.dts.rentgameapi.domain.entity.TblGameAccountEntity;
import com.dts.rentgameapi.domain.response.GameAccountResponse;
import com.dts.rentgameapi.domain.response.ListGameAccountResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.GameAccountRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.GameAccountService;
import com.dts.rentgameapi.utils.GameAccountBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Service
public class GameAccountServiceImpl extends BaseService implements GameAccountService {
    @Autowired
    private GameAccountRepo gameAccountRepo;

    @Autowired
    private GameAccountBeanUtil gameAccountBeanUtil;

    @Override
    public BaseResponse findById(Integer id) {
        GameAccountResponse response = new GameAccountResponse();
        GameAccount gameAccount = null;
        try {
            TblGameAccountEntity entity = gameAccountRepo.findById(id).get();
            gameAccount = gameAccountBeanUtil.entity2Dto(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (gameAccount == null)
            response.setItemNotFound();
        else
            response.setSuccess(gameAccount);
        return response;
    }


    @Override
    public BaseResponse saveGameAccount(GameAccount gameAccount) {
        TblGameAccountEntity re = null;
        try {
            TblGameAccountEntity entity = gameAccountBeanUtil.dto2Entity(gameAccount);
            re = gameAccountRepo.save(entity);
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
    public BaseResponse updateGameAccount(GameAccount gameAccount) {
        TblGameAccountEntity result = null;
        try {
            TblGameAccountEntity entity = gameAccountBeanUtil.dto2Entity(gameAccount);
            result = gameAccountRepo.save(entity);
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
//        List<GameAccountEntity> gameAccountEntities = gameAccountDaoImpl.findAll();
//        List<GameAccountDTO> gameAccountDTOS = new ArrayList<>();
//        for (GameAccountEntity gameAccountEntity : gameAccountEntities) {
//            gameAccountDTOS.add(gameAccountBeanUtil.entity2Dto(gameAccountEntity));
//        }
//        ListGameAccountResponse response = new ListGameAccountResponse();
//        response.setResult(gameAccountDTOS, gameAccountDTOS.size());
//        return response;
        return null;
    }

    public BaseResponse findAllByShopId(Integer shop_id) {
        ListGameAccountResponse response = new ListGameAccountResponse();
        List<GameAccount> gameDownloads = new ArrayList<>();
        List<TblGameAccountEntity> entities = null;
        try {
            entities = gameAccountRepo.findAllByShopId(shop_id);
            entities.forEach(tblGameAccountEntity -> gameDownloads.add(gameAccountBeanUtil.entity2Dto(tblGameAccountEntity)));
        } catch (Exception e) {
            response.setResult(gameDownloads, 0, e.getMessage());
            return response;
        }
        if (gameDownloads == null) {
            response.setSuccess(gameDownloads, gameDownloads.size());
        } else {
            response.setSuccess(gameDownloads, gameDownloads.size());
        }
        return response;
    }

    public BaseResponse findByShopIdAndPages(Integer shop_id, Integer start, Integer limit) {
        ListGameAccountResponse response = new ListGameAccountResponse();
        List<TblGameAccountEntity> result = new ArrayList<>();
        List<GameAccount> games = new ArrayList<>();
        long total = 0;
        try {
            result = gameAccountRepo.findByShopIdAndPages(shop_id, start, limit);
            result.forEach(tblGameAccountEntity -> {
                games.add(gameAccountBeanUtil.entity2Dto(tblGameAccountEntity));
            });
            total=gameAccountRepo.countByShopId(shop_id);
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

    public BaseResponse findAllByGameId(Integer game_id) {
        ListGameAccountResponse response = new ListGameAccountResponse();
        List<GameAccount> gameDownloads = new ArrayList<>();
        List<TblGameAccountEntity> entities = null;
        try {
            entities = gameAccountRepo.findAllByGameId(game_id);
            entities.forEach(tblGameAccountEntity -> gameDownloads.add(gameAccountBeanUtil.entity2Dto(tblGameAccountEntity)));
        } catch (Exception e) {
            response.setResult(gameDownloads, 0, e.getMessage());
            return response;
        }
        if (gameDownloads == null) {
            response.setSuccess(gameDownloads, gameDownloads.size());
        } else {
            response.setSuccess(gameDownloads, gameDownloads.size());
        }
        return response;
    }

    public BaseResponse findByGameIdAndPages(Integer game_id, Integer start, Integer limit) {
        ListGameAccountResponse response = new ListGameAccountResponse();
        List<TblGameAccountEntity> result = new ArrayList<>();
        List<GameAccount> games = new ArrayList<>();
        long total = 0;
        try {
            result = gameAccountRepo.findByGameIdAndPages(game_id, start, limit);
            result.forEach(tblGameAccountEntity -> {
                games.add(gameAccountBeanUtil.entity2Dto(tblGameAccountEntity));
            });
            total=gameAccountRepo.countByGameId(game_id);
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

    public BaseResponse findByGameIdAndShopIdPages(Integer game_id, Integer shop_id, Integer start, Integer limit) {
        ListGameAccountResponse response = new ListGameAccountResponse();
        List<TblGameAccountEntity> result = new ArrayList<>();
        List<GameAccount> games = new ArrayList<>();
        long total = 0;
        try {
            result = gameAccountRepo.findByGameIdAndShopIdPages(game_id,shop_id,start,limit);
            result.forEach(tblGameAccountEntity -> {
                games.add(gameAccountBeanUtil.entity2Dto(tblGameAccountEntity));
            });
            total=gameAccountRepo.countByGameIdAndShopId(game_id,shop_id);
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

//    public BaseResponse getAvaiableAccount(int game_id) {
//        GameAccountResponse response = new GameAccountResponse();
//        try {
//            Map<String, Object> property = new HashMap<>();
//            property.put("game_id", game_id);
//            property.put("status", 0);
//
//            Object[] objects = gameAccountDaoImpl.findByProperty(property, null, null, 0, 1, null);
//            List<GameAccountEntity> gameAccountEntities = (List<GameAccountEntity>) objects[1];
//            if (gameAccountEntities == null || gameAccountEntities.size() <= 0)
//                response.setFailed("het acc");
//            else {
//                GameAccountEntity re = gameAccountEntities.get(0);
//                GameAccountDTO dto = gameAccountBeanUtil.entity2Dto(re);
//                response.setSuccess(dto);
//            }
//        } catch (Exception e) {
//            response.setFailed(e.getMessage());
//        }
//        return response;
//    }
}
