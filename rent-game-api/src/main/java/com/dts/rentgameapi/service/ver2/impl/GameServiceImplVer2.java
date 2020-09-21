package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.RentConstant;
import com.dts.rentgameapi.converters.GameFromConveter;
import com.dts.rentgameapi.converters.GameOwnerConveter;
import com.dts.rentgameapi.converters.GameSliderConverter;
import com.dts.rentgameapi.domain.dto.mapping.GameDetailMapping;
import com.dts.rentgameapi.domain.dto.mapping.GameFormMapping;
import com.dts.rentgameapi.domain.dto.mapping.GameOwnerPlayedMapping;
import com.dts.rentgameapi.domain.dto.ver2.GameOwner;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.GetListResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;
import com.dts.rentgameapi.repo.GameAccountRepo;
import com.dts.rentgameapi.repo.GameRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.repo.custom.GameCustomRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.GameServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImplVer2 extends BaseService implements GameServiceVer2 {

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private GameCustomRepo gameCustomRepo;

    @Autowired
    private GameAccountRepo gameAccountRepo;

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private GameFromConveter gameFromConveter;

    @Autowired
    private GameOwnerConveter gameOwnerConveter;

    @Autowired
    private GameSliderConverter gameSliderConverter;


    @Override
    public BaseResponse findGameFormByOffset(String sortDirection, Integer start, Integer limit, Integer store_id, Integer category_id) {
        GetListResponse<com.dts.rentgameapi.domain.dto.ver2.GameForm> response = new GetListResponse<>();
        try {
            long total = 0;
            List<TblGameEntity> gameEntities = null;
            gameEntities = gameCustomRepo.findGames(start, limit, sortDirection, store_id, category_id);
            List<com.dts.rentgameapi.domain.dto.ver2.GameForm> gameForms = new ArrayList<>();
            if (gameEntities != null && gameEntities.size() > 0) {
                for (TblGameEntity gameEntity : gameEntities) {
                    Double price = gameAccountRepo.findMinPrice(gameEntity.getId());
                    if (price == null)
                        price = 0.0;
                    com.dts.rentgameapi.domain.dto.ver2.GameForm gameForm = gameFromConveter.convert(gameEntity);
                    gameForm.setPrice(price);
                    gameForms.add(gameForm);
                }
            }
            if (store_id > 0 && category_id > 0) {
                total = gameRepo.countByStoreIdAndCategoryId(store_id, category_id);
            } else if (store_id > 0) {
                total = gameRepo.countByStoreId(store_id);
            } else if (category_id > 0) {
                total = gameRepo.countByCategoryId(category_id);
            } else
                total = gameRepo.count();
            response.setResult(gameForms, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed();
        }
        return response;
    }

    @Override
    public BaseResponse findGamesOwnerByOffset(String sortDirection, Integer start, Integer limit, String user_name, Integer store_id, Integer category_id) {
        GetListResponse<GameOwner> response = new GetListResponse<>();
        try {
            //int pageSize = appConfig.getConfiguration().getIntProperty("SIZE_GAME", 10, "RENTGAME");
            // int skips = RentUtil.callSkips(start, limit);
            long total = 0;
            TblUserEntity user = userRepo.findByUsername(user_name);
            if (user == null)
                response.setFailed("user not exist");
            else {
                List<GameOwnerPlayedMapping> gameEntities = gameCustomRepo.findGamesOwner(user.getUserId(), start, limit, sortDirection, store_id, category_id);
                List<GameOwner> gameOwners = new ArrayList<>();
                if (gameEntities != null && gameEntities.size() > 0) {
                    for (GameOwnerPlayedMapping ownerPlayed : gameEntities) {
                        Double price = gameAccountRepo.findMinPrice(ownerPlayed.getId());
                        if (price == null)
                            price = 0.0;
                        GameOwner gameOwner = gameOwnerConveter.convert(ownerPlayed);
                        gameOwner.setPrice(price);
                        gameOwners.add(gameOwner);
                    }
                }
                if (store_id > 0 && category_id > 0) {
                    total = gameRepo.countByStoreIdAndCategoryId(store_id, category_id);
                } else if (store_id > 0) {
                    total = gameRepo.countByStoreId(store_id);
                } else if (category_id > 0) {
                    total = gameRepo.countByCategoryId(category_id);
                } else
                    total = gameRepo.count();
                response.setResult(gameOwners, total);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed();
        }
        return response;
    }

    @Override
    public BaseResponse findById(Integer id) {
        SingleItemResponse<GameDetailMapping> response = new SingleItemResponse<>();
        GameDetailMapping detail = null;
        try {
            detail = gameCustomRepo.findById(id);
            Double price = gameAccountRepo.findMinPrice(detail.getId());
            if (price == null)
                price = 0.0;
            detail.setPrice(price);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (detail == null)
            response.setItemNotFound();
        else
            response.setSuccess(detail);
        return response;
    }


    public BaseResponse getTopGames(int type, int limit) {
        GetListResponse<com.dts.rentgameapi.domain.dto.ver2.GameForm> response = new GetListResponse<>();
        try {
            // int pageSize = appConfig.getConfiguration().getIntProperty("TOP_GAME_SIZE", 6, "RENTGAME");
            List<GameFormMapping> gameFormEntities = null;
            if (type == RentConstant.TOP_PLAY)
                gameFormEntities = gameCustomRepo.findByTopPlay(limit);
            else if (type == RentConstant.TOP_NEWEST)
                gameFormEntities = gameCustomRepo.findByTopNewest(limit);
            else if (type == RentConstant.TOP_HIRE)
                gameFormEntities = gameCustomRepo.findByTopNewest(limit);
            List<com.dts.rentgameapi.domain.dto.ver2.GameForm> gameForms = new ArrayList<>();
            long total = 0;
            if (gameFormEntities != null && gameFormEntities.size() > 0) {
                for (GameFormMapping gameEntity : gameFormEntities) {
                    Double price = gameAccountRepo.findMinPrice(gameEntity.getId());
                    if (price == null)
                        price = 0.0;
                    com.dts.rentgameapi.domain.dto.ver2.GameForm gameForm = gameFromConveter.convert(gameEntity);
                    gameForm.setPrice(price);
                    gameForms.add(gameForm);
                }
                total = gameForms.size();
            }
            response.setResult(gameForms, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed();
        }
        return response;

    }
}
