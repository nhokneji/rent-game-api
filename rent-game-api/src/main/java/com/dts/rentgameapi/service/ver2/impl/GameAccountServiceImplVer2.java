package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.domain.entity.TblGameAccountEntity;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.dto.mapping.DetailGameAccountMapping;
import com.dts.rentgameapi.domain.request.CreateGameAccountRequest;
import com.dts.rentgameapi.domain.request.DeleteRequest;
import com.dts.rentgameapi.domain.request.UpdateGameAccountRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.GetListResponse;
import com.dts.rentgameapi.repo.GameAccountRepo;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.repo.custom.GameAccountCustomRepo;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.GameAccountServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Service
public class GameAccountServiceImplVer2 extends BaseService implements GameAccountServiceVer2 {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private GameAccountCustomRepo gameAccountCustomRepo;
    @Autowired
    private GameAccountRepo gameAccountRepo;

    @Override
    public BaseResponse findGameAccountByJwtUser(JwtUser jwtUser, int start, int limit) {
        GetListResponse<DetailGameAccountMapping> response = new GetListResponse<>();
        List<DetailGameAccountMapping> gameAccountEntities = new ArrayList<>();
        long total = 0;
        try {
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            if (userRepo.existsByUsername(jwtUser.getUsername()) == null)
                response.setResult(null, total, "Người dùng không tồn tại");
            else {
                TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
                if (shopEntity == null)
                    response.setResult(null, total, "Bạn chưa tạo shop");
                else {
                    gameAccountEntities = gameAccountCustomRepo.findGameAccountByShopId(shopEntity.getId(), start, limit);
                    total = gameAccountRepo.countByShopId(shopEntity.getId());
                    response.setSuccess(gameAccountEntities, total);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed("Server Error");
        }
        return response;
    }

    @Override
    public BaseResponse create(JwtUser jwtUser, CreateGameAccountRequest request) {
        BaseResponse response = new BaseResponse();
        if (!request.validate()) {
            response.setFailed("Params invalid");
            return response;
        }
        try {
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            if (userRepo.existsByUsername(jwtUser.getUsername()) == null)
                response.setFailed("Người dùng không tồn tại");
            else {
                TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
                if (shopEntity == null)
                    response.setFailed("Bạn chưa tạo shop");
                else {
                    TblGameAccountEntity entity = new TblGameAccountEntity();
                    entity.setAccount(request.getAccount());
                    entity.setPassword(request.getPassword());
                    entity.setCreatedTime(getCurrentTimestamp());
                    entity.setLastUpdateTime(getCurrentTimestamp());
                    entity.setStatus(0);
                    entity.setRentTime(new Timestamp(request.getRentTime()));
                    entity.setRentCount(0);
                    entity.setGameId(request.getGameId());
                    entity.setShopId(shopEntity.getId());
                    entity.setExpireTime(new Timestamp(request.getExpireTime()));
                    entity.setPrice(request.getPrice());
                    entity.setDescription(request.getDescription());
                    gameAccountRepo.save(entity);
                    response.setSuccess();
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed("Server Error");
        }
        return response;
    }

    @Override
    public BaseResponse update(JwtUser jwtUser, UpdateGameAccountRequest request) {
        BaseResponse response = new BaseResponse();
        if (!request.validate()) {
            response.setFailed("Params invalid");
            return response;
        }
        try {
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            if (userRepo.existsByUsername(jwtUser.getUsername()) == null)
                response.setFailed("Người dùng không tồn tại");
            else {
                TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
                if (shopEntity == null)
                    response.setFailed("Bạn chưa tạo shop");
                else {
                    TblGameAccountEntity entity = gameAccountRepo.findById(request.getAcc_id()).get();
                    if (entity == null)
                        response.setFailed("Không tìm thấy accout này.");
                    else {
                        if (entity.getStatus() == 1)//1 la dang cho thue
                            response.setFailed("Tài khoản này đang cho thuê không thể đổi thông tin. Vui lòng thử lại sau.");
                        else {
                            entity.setPassword(request.getPassword());
                            entity.setLastUpdateTime(getCurrentTimestamp());
                            entity.setPrice(request.getPrice());
                            entity.setDescription(request.getDescription());
                            gameAccountRepo.save(entity);
                            response.setSuccess();
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed("Server Error");
        }
        return response;
    }

    @Override
    public BaseResponse findById(Integer id) {
        return null;
    }

    @Override
    public BaseResponse delete(DeleteRequest request) {
        BaseResponse response = new BaseResponse();
        try {
            TblGameAccountEntity gameAccountEntity = gameAccountRepo.findById(request.getId()).get();
            if (gameAccountEntity == null)
                response.setItemNotFound();
            else {
                gameAccountRepo.delete(gameAccountEntity);
                response.setSuccess();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return response;
    }
}
