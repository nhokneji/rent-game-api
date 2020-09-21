package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.domain.dto.mapping.RentChargeHistoryEntity;
import com.dts.rentgameapi.domain.dto.ver1.ChargeHistory;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.GetListResponse;
import com.dts.rentgameapi.repo.ChargeHistoryRepo;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.repo.custom.ChargeHistoryCustomRepo;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.ChargeServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Service
public class ChargeServiceImplVer2 extends BaseService implements ChargeServiceVer2 {
    @Autowired
    private ChargeHistoryCustomRepo chargeHistoryCustomRepo;

    @Autowired
    private ChargeHistoryRepo chargeHistoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public BaseResponse findChargeHistoryByUser(JwtUser jwtUser, int start, int limit, String sort) {
        GetListResponse<RentChargeHistoryEntity> response = new GetListResponse<>();
        List<RentChargeHistoryEntity> rentChargeHistoryMappings = new ArrayList<>();
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
                    rentChargeHistoryMappings = chargeHistoryCustomRepo.findRentChargeHistoryByUser(limit, start, sort, userEntity.getUserId());
                     total = chargeHistoryRepo.countByUserId(userEntity.getUserId());
                    response.setSuccess(rentChargeHistoryMappings, total);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed("Server Error");
        }
        return response;
    }
}
