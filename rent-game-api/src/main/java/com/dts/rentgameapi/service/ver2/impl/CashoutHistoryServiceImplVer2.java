package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.domain.entity.TblCashoutHistoryEntity;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.request.CashoutRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.repo.CashoutHistoryRepo;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.CashoutHistoryServiceVer2;
import com.dts.rentgameapi.utils.RentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Rin-DTS
 */
@Service
public class CashoutHistoryServiceImplVer2 extends BaseService implements CashoutHistoryServiceVer2  {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private CashoutHistoryRepo cashoutHistoryRepo;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BaseResponse cashout(CashoutRequest request, JwtUser jwtUser) {
        BaseResponse response = new BaseResponse();
        try {

            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            if (userEntity == null) {
                response.setFailed("Người dùng  không tồn tại.");
                return response;
            }
            TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
            if (shopEntity == null) {
                response.setFailed("Bạn chưa tạo shop.");
                return response;
            }

            TblCashoutHistoryEntity cashoutHistoryEntity = new TblCashoutHistoryEntity();
            if (shopEntity.getBalance() >= request.getAmount()) {
                double lastbalance = shopEntity.getBalance();
                shopEntity.setBalance(shopEntity.getBalance() - request.getAmount());
                cashoutHistoryEntity.setShopId(shopEntity.getId());
                cashoutHistoryEntity.setPart(RentUtil.buildPart(new Date()));
                cashoutHistoryEntity.setLastBalance(lastbalance);
                cashoutHistoryEntity.setAmount(request.getAmount());
                TblShopEntity up = shopRepo.save(shopEntity);
                if (up != null)
                    cashoutHistoryEntity.setResult(1);
                else
                    cashoutHistoryEntity.setResult(0);
                cashoutHistoryEntity.setCreatedTime(getCurrentTimestamp());
                cashoutHistoryEntity.setStatus(1);
                cashoutHistoryEntity.setAfterBalance(shopEntity.getBalance());
                cashoutHistoryRepo.save(cashoutHistoryEntity);
                response.setSuccess();
            } else
                response.setFailed("Bạn không đủ tiền");
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }
}
