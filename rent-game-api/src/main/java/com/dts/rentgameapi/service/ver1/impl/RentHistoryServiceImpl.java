package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.DetailGameAccount;
import com.dts.rentgameapi.domain.dto.ver1.GameAccount;
import com.dts.rentgameapi.domain.dto.ver1.RentHistory;
import com.dts.rentgameapi.domain.entity.*;
import com.dts.rentgameapi.domain.response.ListRentHistoryResponse;
import com.dts.rentgameapi.domain.response.RentHistoryResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;
import com.dts.rentgameapi.repo.*;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.RentHistoryService;
import com.dts.rentgameapi.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class RentHistoryServiceImpl extends BaseService implements RentHistoryService {
    @Autowired
    private RentHistoryRepo rentHistoryRepo;

    @Autowired
    private RentHistoryBeanUtil rentHistoryBeanUtil;


    @Autowired
    private GameAccountRepo gameAccountRepo;

    @Autowired
    private GameAccountBeanUtil gameAccountBeanUtil;


    @Autowired
    private ShopRepo shopRepo;


    @Autowired
    private ShopBeanUtil shopBeanUtil;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private UserBeanUtil userBeanUtil;

    @Autowired
    private JwtValidator jwtValidator;

    @Autowired
    private UserGameInfoRepo userGameInfoRepo;


    @Override
    public BaseResponse findById(Integer id) {
        RentHistoryResponse response = new RentHistoryResponse();
        RentHistory rentHistory = null;
        try {
            TblRentHistoryEntity rentHistoryEntity = rentHistoryRepo.findById(id).get();
            rentHistory = rentHistoryBeanUtil.entity2Dto(rentHistoryEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (rentHistory == null)
            response.setItemNotFound();
        else
            response.setSuccess(rentHistory);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveRentHistory(RentHistory rentHistory) {
        TblRentHistoryEntity re = null;
        try {
            TblRentHistoryEntity entity = rentHistoryBeanUtil.dto2Entity(rentHistory);
            re = rentHistoryRepo.save(entity);
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
    public BaseResponse updateRentHistory(RentHistory rentHistory) {
        TblRentHistoryEntity result = null;
        try {
            TblRentHistoryEntity entity = rentHistoryBeanUtil.dto2Entity(rentHistory);
            result = rentHistoryRepo.save(entity);
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

    @Transactional(rollbackFor = Exception.class)
    public BaseResponse create(String token, Integer shopId, Integer gameId) {
        SingleItemResponse<DetailGameAccount> response = new SingleItemResponse<>();
        RentHistory rentHistory = new RentHistory();
        DetailGameAccount detailGameAccount = new DetailGameAccount();
        GameAccount gameAccount = null;
        try {
            JwtUser jwtUser = jwtValidator.validate(token);
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            if (userEntity == null) {
                response.setResult(null, "Người dùng " + jwtUser.getUsername() + " không tồn tại.");
                return response;
            }
            TblRentHistoryEntity rentHistoryEntity = rentHistoryRepo.findByUserId(userEntity.getUserId());

            if (rentHistoryEntity != null && rentHistoryEntity.getStatus() == 0) //0. chua thanh toan
            {
                TblGameAccountEntity entity = gameAccountRepo.findById(rentHistoryEntity.getAccountId()).get();
                String acc = "";
                if (entity != null)
                    acc = entity.getAccount();

                response.setResult(null, "Bạn chưa thanh toán tiền cho account " + entity.getAccount() + "!!");
                return response;
            }

            if (!shopRepo.existsById(shopId)) {
                response.setResult(null, "Không tìm thấy shop");
                return response;
            }

            TblUserGameInfoEntityPK id = new TblUserGameInfoEntityPK();

            id.setGameId(gameId);
            id.setUserId(userEntity.getUserId());
            TblUserGameInfoEntity userGameInfoEntity = null;
            try {
                userGameInfoEntity = userGameInfoRepo.findById(id).get();
            } catch (Exception e) {

            }
            TblGameEntity gameEntity = null;
            try {
                gameEntity = gameRepo.findById(gameId).get();
            } catch (Exception e) {

            }
            if (gameEntity == null) {
                response.setResult(null, "Không tìm thấy game này");
                return response;
            }

            if (userGameInfoEntity != null) {
                if (userGameInfoEntity.getStatus() == 0) {
                    userGameInfoEntity.setUserId(1);
                    userGameInfoRepo.save(userGameInfoEntity);
                }
            } else {
                userGameInfoEntity = new TblUserGameInfoEntity();
                userGameInfoEntity.setUserId(userEntity.getUserId());
                userGameInfoEntity.setGameId(gameId);
                userGameInfoEntity.setStatus(1);
                userGameInfoRepo.save(userGameInfoEntity);
            }


            TblGameAccountEntity gameAccountEntity = gameAccountRepo.findGameAccountAvaiable(gameId);
            if (gameAccountEntity == null) {
                response.setResult(null, "Hết Account");
                return response;
            }
            if (userEntity.getBalance() < gameAccountEntity.getPrice()) {
                response.setResult(null, "Không đủ tiền để thuê game");
                return response;
            }

            rentHistory.setShopId(shopId);
            rentHistory.setUserId(userEntity.getUserId());
            rentHistory.setAmount(0);
            rentHistory.setPart(RentUtil.buildPart(new Date()));
            rentHistory.setRentUser(userEntity.getDisplayName());
            rentHistory.setStartTime(getCurrentTimestamp());
            rentHistory.setAccountId(gameAccountEntity.getId());
            rentHistory.setStatus(RentHistory.Status.ENABLE.getValue());
            rentHistory.setGame(gameEntity.getName());
            rentHistory.setGameId(gameEntity.getId());
            rentHistory.setDuration(0);
            gameAccountEntity.setStatus(1);
            gameAccountEntity.setRentCount(gameAccountEntity.getRentCount() + 1);
            gameAccountEntity = gameAccountRepo.save(gameAccountEntity);

            gameAccount = gameAccountBeanUtil.entity2Dto(gameAccountEntity);
            TblRentHistoryEntity entity = rentHistoryBeanUtil.dto2Entity(rentHistory);
            rentHistoryRepo.save(entity);
            if (gameEntity.getPlayCount() <= 0)
                gameEntity.setPlayCount(1);
            gameEntity.setPlayCount(gameEntity.getPlayCount() + 1);
            gameRepo.save(gameEntity);

            detailGameAccount.setAccount(gameAccount.getAccount());
            detailGameAccount.setCreatedTime(gameAccount.getCreatedTime());
            detailGameAccount.setExpireTime(gameAccount.getExpireTime());
            detailGameAccount.setGame_identity(gameEntity.getGameIdentity());
            detailGameAccount.setGameId(gameAccount.getGameId());
            detailGameAccount.setLastUpdateTime(gameAccount.getLastUpdateTime());
            detailGameAccount.setPassword(gameAccount.getPassword());
            detailGameAccount.setRentCount(gameAccount.getRentCount());
            detailGameAccount.setPrice(gameAccount.getPrice());
            detailGameAccount.setShopId(gameAccount.getShopId());
            detailGameAccount.setStatus(gameAccount.getStatus());
            detailGameAccount.setRentTime(gameAccount.getRentTime());

        } catch (
                Exception e) {
            response.setResult(null, e.getMessage());
        }
        response.setSuccess(detailGameAccount);
        return response;
    }


    public BaseResponse findRangePart(Integer from, Integer to) {
        ListRentHistoryResponse response = new ListRentHistoryResponse();
        List<RentHistory> rentHistories = new ArrayList<>();
        try {


            List<TblRentHistoryEntity> rentHistoryEntities = rentHistoryRepo.findByPartBetween(from, to);
            rentHistoryEntities.forEach(tblRentHistoryEntity -> rentHistories.add(rentHistoryBeanUtil.entity2Dto(tblRentHistoryEntity)));
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        response.setResult(rentHistories, rentHistories.size());
        return response;
    }

    public BaseResponse findByShopIdRangePart(Integer shopId, Integer from, Integer to) {
        ListRentHistoryResponse response = new ListRentHistoryResponse();
        List<RentHistory> rentHistories = new ArrayList<>();
        try {
            List<TblRentHistoryEntity> rentHistoryEntities = rentHistoryRepo.findByShopIdPartBetween(shopId, from, to);
            rentHistoryEntities.forEach(tblRentHistoryEntity -> rentHistories.add(rentHistoryBeanUtil.entity2Dto(tblRentHistoryEntity)));
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        response.setResult(rentHistories, rentHistories.size());
        return response;
    }

    public BaseResponse findRentGameHistory(String token, Integer start, Integer limit) {
        ListRentHistoryResponse response = new ListRentHistoryResponse();

        JwtUser jwtUser = jwtValidator.validate(token);
        TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
        long total = 0;
        if (userEntity == null) {
            response.setItemNotFound("User not exits");
            return response;
        }
        List<RentHistory> rentHistories = new ArrayList<>();
        try {
            List<TblRentHistoryEntity> rentHistoryEntities = rentHistoryRepo.findByUserId(userEntity.getUserId(), start, limit);
            rentHistoryEntities.forEach(tblRentHistoryEntity -> rentHistories.add(rentHistoryBeanUtil.entity2Dto(tblRentHistoryEntity)));
            total = rentHistoryRepo.countByUserId(userEntity.getUserId());
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        response.setResult(rentHistories, total);
        return response;
    }
}
