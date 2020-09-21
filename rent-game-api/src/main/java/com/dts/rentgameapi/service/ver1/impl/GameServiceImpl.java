package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.mapping.UserRentGameInfoMapping;
import com.dts.rentgameapi.domain.dto.ver1.Game;
import com.dts.rentgameapi.domain.dto.ver1.GameDetail;
import com.dts.rentgameapi.domain.dto.ver1.GameDownload;
import com.dts.rentgameapi.domain.dto.ver1.GamePlaying;
import com.dts.rentgameapi.domain.entity.*;
import com.dts.rentgameapi.domain.response.ListDetailGameResponse;
import com.dts.rentgameapi.domain.response.ListGameDownloadResponse;
import com.dts.rentgameapi.domain.response.ListGameResponse;
import com.dts.rentgameapi.domain.response.ListUserGameInfoResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;
import com.dts.rentgameapi.repo.*;
import com.dts.rentgameapi.repo.custom.UserGameInfoCustomRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.GameService;
import com.dts.rentgameapi.utils.GameBeanUtil;
import com.dts.rentgameapi.utils.GameDownloadBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Rin-DTS
 */
@Service
public class GameServiceImpl extends BaseService implements GameService {

    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserGameInfoRepo userGameInfoRepo;
    @Autowired
    private UserGameInfoCustomRepo userGameInfoCustomRepo;
    @Autowired
    private GameBeanUtil gameBeanUtil;

    @Autowired
    private GameDownloadRepo gameDownloadRepo;

    @Autowired
    private GameDownloadBeanUtil gameDownloadBeanUtil;

    @Autowired
    private GameAccountRepo gameAccountRepo;

    @Autowired
    private RentHistoryRepo rentHistoryRepo;

    @Override
    public BaseResponse findById(Integer id) {
        SingleItemResponse<GameDetail> response = new SingleItemResponse<>();
        GameDetail detail = new GameDetail();
        Game game = null;
        try {
            TblGameEntity providerEntity = gameRepo.findById(id).get();
            game = gameBeanUtil.entity2Dto(providerEntity);
            List<TblGameDownloadEntity> entities = gameDownloadRepo.findByGameId(game.getId());
            List<GameDownload> downloads = new ArrayList<>();
            entities.forEach(tblGameDownloadEntity ->
                    downloads.add(gameDownloadBeanUtil.entity2Dto(tblGameDownloadEntity)));
            detail.setId(game.getId());
            detail.setCategoryId(game.getCategoryId());
            detail.setDesciption(game.getDesciption());
            detail.setRate(game.getRate());
            detail.setName(game.getName());
            detail.setImage(game.getImage());
            detail.setThumbImage(game.getThumbImage());
            detail.setPlayCount(game.getPlayCount());
            detail.setDownloadCount(game.getDownloadCount());
            detail.setGameIdentity(game.getGameIdentity());
            detail.setProviderId(game.getProviderId());
            //detail.setStatus(game.getStatus());
            detail.setStoreId(game.getStoreId());
            Collections.sort(downloads);
            detail.setLinkDown(downloads.get(0).getLink());
            detail.setPublish(downloads.get(0).getPublish());
            detail.setVersion(downloads.get(0).getVersion());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (game == null)
            response.setItemNotFound();
        else
            response.setSuccess(detail);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveGame(Game game) {
        TblGameEntity re = null;
        try {
            TblGameEntity entity = gameBeanUtil.dto2Entity(game);
            re = gameRepo.save(entity);
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
    public BaseResponse updateGame(Game game) {
        TblGameEntity result = null;
        try {
            TblGameEntity entity = gameBeanUtil.dto2Entity(game);
            result = gameRepo.save(entity);
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
        Iterator<TblGameEntity> gameEntityIterator = gameRepo.findAll().iterator();
        List<Game> games = new ArrayList<>();
        gameEntityIterator.forEachRemaining(tblGameEntity -> {
            games.add(gameBeanUtil.entity2Dto(tblGameEntity));
        });
        ListGameResponse response = new ListGameResponse();
        response.setResult(games, games.size());
        return response;
    }


    public BaseResponse findAll(Integer user_id) {
        Iterator<TblGameEntity> gameEntityIterator = gameRepo.findAll().iterator();
        List<Game> games = new ArrayList<>();
        // List<TblUserGameInfoEntity> userGameInfoEntities=userGameInfoRepo.findById()
        TblUserGameInfoEntityPK id = new TblUserGameInfoEntityPK();

        gameEntityIterator.forEachRemaining(tblGameEntity -> {
            id.setUserId(user_id);
            id.setGameId(tblGameEntity.getId());
            Game game = gameBeanUtil.entity2Dto(tblGameEntity);
            if (userGameInfoRepo.existsById(id)) {
                game.setStatus(1);
            } else {
                game.setStatus(0);
            }
            games.add(game);
        });
        ListGameResponse response = new ListGameResponse();
        response.setResult(games, games.size());
        return response;
    }

    public BaseResponse findByPages(Integer start, Integer limit) {
        ListDetailGameResponse response = new ListDetailGameResponse();
        List<GameDetail> result = new ArrayList<>();
        List<TblGameEntity> gameEntities = new ArrayList<>();
        long total = 0L;
        try {
            gameEntities = gameRepo.findGamesByPagesDesc(start, limit);
            gameEntities.forEach(tblGameEntity -> {
                Game game = gameBeanUtil.entity2Dto(tblGameEntity);
                List<TblGameDownloadEntity> entities = gameDownloadRepo.findByGameId(game.getId());
                List<GameDownload> downloads = new ArrayList<>();
                entities.forEach(tblGameDownloadEntity ->
                        downloads.add(gameDownloadBeanUtil.entity2Dto(tblGameDownloadEntity)));
                GameDetail detail = new GameDetail();
                detail.setId(game.getId());
                detail.setCategoryId(game.getCategoryId());
                detail.setDesciption(game.getDesciption());
                detail.setRate(game.getRate());
                detail.setName(game.getName());
                detail.setImage(game.getImage());
                detail.setThumbImage(game.getThumbImage());
                detail.setPlayCount(game.getPlayCount());
                detail.setDownloadCount(game.getDownloadCount());
                detail.setGameIdentity(game.getGameIdentity());
                detail.setProviderId(game.getProviderId());
                detail.setStoreId(game.getStoreId());
                double price = gameAccountRepo.findMinPrice(game.getId());
                detail.setPrice(price);
                Collections.sort(downloads);
                detail.setLinkDown(downloads.get(0).getLink());
                detail.setPublish(downloads.get(0).getPublish());
                detail.setVersion(downloads.get(0).getVersion());
                result.add(detail);
            });
            total = gameRepo.count();
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

    public BaseResponse getAllLinkDownload(Integer game_id) {
        ListGameDownloadResponse response = new ListGameDownloadResponse();
        List<GameDownload> gameDownloads = new ArrayList<>();
        List<TblGameDownloadEntity> entities = null;
        try {
            entities = gameDownloadRepo.findByGameId(game_id);
            entities.forEach(tblGameDownloadEntity -> gameDownloads.add(gameDownloadBeanUtil.entity2Dto(tblGameDownloadEntity)));
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

    public BaseResponse getLinkDownloadByPages(Integer game_id, Integer start, Integer limit) {
        ListGameDownloadResponse response = new ListGameDownloadResponse();
        List<GameDownload> gameDownloads = new ArrayList<>();
        List<TblGameDownloadEntity> entities = null;
        long total = 0;
        try {
            entities = gameDownloadRepo.findByGameId(game_id);
            entities.forEach(tblGameDownloadEntity -> gameDownloads.add(gameDownloadBeanUtil.entity2Dto(tblGameDownloadEntity)));
            total = gameDownloadRepo.countByGameId(game_id);
        } catch (Exception e) {
            response.setResult(gameDownloads, total, e.getMessage());
            return response;
        }
        if (gameDownloads == null) {
            response.setSuccess(gameDownloads, total);
        } else {
            response.setSuccess(gameDownloads, total);
        }
        return response;
    }

    public BaseResponse findMyGamesByPages(String username, Integer start, Integer limit, Integer store_id) {

        ListUserGameInfoResponse response = new ListUserGameInfoResponse();
        List<TblGameEntity> gameEntities = null;
        List<UserRentGameInfoMapping> userGameInfoEntities = null;
        long total = 0L;
        try {
            int user_id = userRepo.findByUsername(username).getUserId();
            userGameInfoEntities = userGameInfoCustomRepo.findByGameStore(store_id, start, limit);
            List<Integer> ids = new ArrayList<>();
            userGameInfoEntities.forEach(userRentGameInfo ->
                    ids.add(userRentGameInfo.getId()));
            gameEntities = gameRepo.findGamesByStoreId(store_id, start, limit);
            Iterator<TblGameEntity> iterator = gameEntities.iterator();
            while (iterator.hasNext()) {
                TblGameEntity gameEntity = iterator.next();
                if (ids.contains(gameEntity.getId()))
                    iterator.remove();
            }
            List<UserRentGameInfoMapping> userRentGameInfos = new ArrayList<>();
            gameEntities.forEach(tblGameEntity ->
            {
                UserRentGameInfoMapping userRentGameInfo = new UserRentGameInfoMapping(null,null,null,null,null,null,null,null,null,null,null,null,null);
                userRentGameInfo.setCategoryId(tblGameEntity.getCategoryId());
                userRentGameInfo.setDesciption(tblGameEntity.getDesciption());
                userRentGameInfo.setDownloadCount(tblGameEntity.getDownloadCount());
                userRentGameInfo.setGameIdentity(tblGameEntity.getGameIdentity());
                userRentGameInfo.setGameStatus(0);
                userRentGameInfo.setId(tblGameEntity.getId());
                userRentGameInfo.setRate(tblGameEntity.getRate());
                userRentGameInfo.setProviderId(tblGameEntity.getProviderId());
                userRentGameInfo.setStoreId(tblGameEntity.getStoreId());
                userRentGameInfo.setThumbImage(tblGameEntity.getThumbImage());
                userRentGameInfo.setImage(tblGameEntity.getImage());
                userRentGameInfo.setName(tblGameEntity.getName());
                userRentGameInfo.setPlayCount(tblGameEntity.getPlayCount());
                userRentGameInfos.add(userRentGameInfo);
            });

            userGameInfoEntities.addAll(userRentGameInfos);
            total = gameRepo.count();
        } catch (Exception e) {
            response.setResult(userGameInfoEntities, total, e.getMessage());
            return response;
        }
        if (userGameInfoEntities == null) {
            response.setSuccess(userGameInfoEntities, total);
        } else {
            response.setSuccess(userGameInfoEntities, total);
        }
        return response;


    }

    public BaseResponse findGamePlaying(String username) {
        SingleItemResponse<GamePlaying> response = new SingleItemResponse<>();
        try {
            int user_id = userRepo.findByUsername(username).getUserId();
            TblRentHistoryEntity rentHistoryEntity = rentHistoryRepo.findByUserAndId(user_id);
            TblGameAccountEntity accountEntity = gameAccountRepo.findById(rentHistoryEntity.getAccountId()).get();
            if (accountEntity != null) {
                TblGameEntity gameEntity = gameRepo.findById(accountEntity.getGameId()).get();
                if (gameEntity != null) {
                    GamePlaying game = new GamePlaying();
                    game.setCategoryId(gameEntity.getCategoryId());
                    game.setDesciption(gameEntity.getDesciption());
                    game.setId(gameEntity.getId());
                    game.setProviderId(gameEntity.getProviderId());
                    game.setStartTime(rentHistoryEntity.getStartTime());
                    game.setGameIdentity(gameEntity.getGameIdentity());
                    game.setDownloadCount(gameEntity.getDownloadCount());
                    game.setPlayCount(gameEntity.getPlayCount());
                    game.setImage(gameEntity.getImage());
                    game.setRate(gameEntity.getRate());
                    game.setName(gameEntity.getName());
                    game.setThumbImage(gameEntity.getThumbImage());
                    game.setStoreId(gameEntity.getStoreId());
                    game.setPrice(accountEntity.getPrice());
                    response.setItem(game);
                }
            } else {
                response.setItemNotFound();
            }
        } catch (Exception e) {
            logger.error("Error", e);
            response.setItemNotFound();
        }
        return response;
    }


}
