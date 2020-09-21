package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.StopRentGame;
import com.dts.rentgameapi.domain.dto.ver1.User;
import com.dts.rentgameapi.domain.entity.TblGameAccountEntity;
import com.dts.rentgameapi.domain.entity.TblRentHistoryEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.response.ListUserResponse;
import com.dts.rentgameapi.domain.response.UserResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;
import com.dts.rentgameapi.repo.GameAccountRepo;
import com.dts.rentgameapi.repo.RentHistoryRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.UserService;
import com.dts.rentgameapi.utils.UserBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Rin-DTS
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GameAccountRepo gameAccountRepo;


    @Autowired
    private RentHistoryRepo rentHistoryRepo;

    @Autowired
    private UserBeanUtil userBeanUtil;

    @Override
    public BaseResponse findById(Integer username) {
        UserResponse response = new UserResponse();
        User user = null;
        try {
            TblUserEntity entity = userRepo.findById(username).get();
            user = userBeanUtil.entity2Dto(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (user == null)
            response.setItemNotFound();
        else
            response.setSuccess(user);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveUser(User user) {
        TblUserEntity re = null;
        try {
            TblUserEntity entity = userBeanUtil.dto2Entity(user);
            re = userRepo.save(entity);
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
    public BaseResponse updateUser(User user) {
        TblUserEntity result = null;
        try {
            TblUserEntity entity = userBeanUtil.dto2Entity(user);
            result = userRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (result == null)
            response.setResult(false, "Not update ");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse findAll() {
        Iterator<TblUserEntity> userEntities = userRepo.findAll().iterator();
        List<User> users = new ArrayList<>();
        userEntities.forEachRemaining(tblUserEntity -> {
            users.add(userBeanUtil.entity2Dto(tblUserEntity));
        });
        ListUserResponse response = new ListUserResponse();
        response.setResult(users, users.size());
        return response;
    }


    public BaseResponse findByUsername(String username) {
        UserResponse response = new UserResponse();
        User user = null;
        try {
            TblUserEntity entity = userRepo.findByUsername(username);
            user = userBeanUtil.entity2Dto(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (user == null)
            response.setItemNotFound();
        else
            response.setSuccess(user);
        return response;
    }

    @Transactional(rollbackFor = Exception.class)
    public BaseResponse stopRentGame(Integer user_id) {
        SingleItemResponse<StopRentGame> response = new SingleItemResponse<>();
        StopRentGame stopRentGame = new StopRentGame();
        try {
            TblUserEntity userEntity = userRepo.findById(user_id).get();
            if (userEntity == null) {
                response.setItemNotFound("User not exist");
                return response;
            } else {
                TblRentHistoryEntity entity1 = rentHistoryRepo.findByUserAndId(user_id);
                if (entity1 == null) {
                    response.setItemNotFound("Không tìm thấy accout của user này");
                    return response;
                }
                TblGameAccountEntity gameAccountEntity = gameAccountRepo.findById(entity1.getAccountId()).get();
                double price = gameAccountEntity.getPrice();
                int minutes = (int) Math.ceil((new Date().getTime() - entity1.getStartTime().getTime()) / (1000 * 60));
                if (minutes == 0)
                    minutes = 1;
                int payment = (int) (price / 60 * minutes);
                userEntity.setBalance(userEntity.getBalance() - payment);
                if (userEntity.getBalance() < 0)
                    userEntity.setBalance(0);
                gameAccountEntity.setStatus(0);
                entity1.setStatus(1);//1 da thanh toan
                entity1.setAmount((double) payment);//1 da thanh toan
                entity1.setStopTime(getCurrentTimestamp());//1 da thanh toan
                entity1.setDuration(entity1.getDuration() + minutes);
                rentHistoryRepo.save(entity1);
                gameAccountRepo.save(gameAccountEntity);
                userRepo.save(userEntity);
                stopRentGame.setAmount(payment);
                stopRentGame.setMinutes(minutes);
                stopRentGame.setPrice(price);
                stopRentGame.setStatus(1);
                response.setSuccess(stopRentGame);
            }
        } catch (Exception e) {
            logger.error("Error", e);
            stopRentGame.setAmount(0);
            stopRentGame.setMinutes(0);
            stopRentGame.setPrice(0.0);
            stopRentGame.setStatus(0);
            response.setItem(stopRentGame);
            response.setFailed("Server Error");
        }
        return response;

    }
}
