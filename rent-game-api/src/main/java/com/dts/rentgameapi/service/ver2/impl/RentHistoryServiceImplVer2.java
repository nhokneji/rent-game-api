package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.domain.dto.mapping.GameAggregateMoneyMapping;
import com.dts.rentgameapi.domain.dto.mapping.RentHisShopGameAccountMapping;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.GetListResponse;
import com.dts.rentgameapi.repo.RentHistoryRepo;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.repo.custom.RentGameHistoryCustomRepo;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.RentHistoryServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Service
public class RentHistoryServiceImplVer2 extends BaseService implements RentHistoryServiceVer2 {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private RentHistoryRepo rentHistoryRepo;

    @Autowired
    private RentGameHistoryCustomRepo rentGameHistoryCustomRepo;

    @Override
    public BaseResponse aggrevate(Integer status, JwtUser jwtUser) {
        GetListResponse<GameAggregateMoneyMapping> response = new GetListResponse<>();
        List<GameAggregateMoneyMapping> gameAggregateMonies = new ArrayList<>();
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
                    gameAggregateMonies = rentGameHistoryCustomRepo.aggregateMoney(shopEntity.getId(), status);
                    total = gameAggregateMonies.size();
                    response.setSuccess(gameAggregateMonies, total);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed("Server Error");
        }
        return response;
    }

    @Override
    public BaseResponse rentGameHistoryByShop(JwtUser jwtUser, Integer start, Integer limit) {
        GetListResponse<RentHisShopGameAccountMapping> response = new GetListResponse<>();
        List<RentHisShopGameAccountMapping> shopGameAccountEntities = new ArrayList<>();
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
                    shopGameAccountEntities = rentGameHistoryCustomRepo.rentGameByShopId(shopEntity.getId(), start, limit);
                    total = rentHistoryRepo.countByShopId(shopEntity.getId());
                    response.setSuccess(shopGameAccountEntities, total);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed("Server Error");
        }
        return response;
    }
}
