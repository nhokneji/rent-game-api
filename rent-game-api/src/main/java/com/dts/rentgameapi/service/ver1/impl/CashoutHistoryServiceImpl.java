package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.CashoutHistory;
import com.dts.rentgameapi.domain.entity.TblCashoutHistoryEntity;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.request.CashoutRequest;
import com.dts.rentgameapi.domain.response.CashoutHistoryResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.CashoutHistoryRepo;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.CashOutHistoryService;
import com.dts.rentgameapi.utils.CashOutHistoryBeanUtil;
import com.dts.rentgameapi.utils.RentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class CashoutHistoryServiceImpl extends BaseService implements CashOutHistoryService {
    @Autowired
    private CashoutHistoryRepo cashoutHistoryRepo;

    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CashOutHistoryBeanUtil cashOutHistoryBeanUtil;

    @Override
    public BaseResponse findById(Integer id) {
        CashoutHistoryResponse response = new CashoutHistoryResponse();
        CashoutHistory cashoutHistory = null;
        try {
            TblCashoutHistoryEntity providerEntity = cashoutHistoryRepo.findById(id).get();
            cashoutHistory = cashOutHistoryBeanUtil.entity2Dto(providerEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (cashoutHistory == null)
            response.setItemNotFound();
        else
            response.setSuccess(cashoutHistory);
        return response;

    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
//        ListCashoutHistoryResponse response = new ListCashoutHistoryResponse();
//        try {
//            Object[] objects = cashOutHistoryDaoImpl.findByProperty(property, sortExpression, sortDirection, offset, limit, null);
//            List<CashoutHistoryDTO> cashoutHistoryDTOS = new ArrayList<>();
//            for (CashoutHistoryEntity item : (List<CashoutHistoryEntity>) objects[1]) {
//                CashoutHistoryDTO cashoutHistoryDTO = cashOutHistoryBeanUtil.entity2Dto(item);
//                cashoutHistoryDTOS.add(cashoutHistoryDTO);
//            }
//
//            response.setResult(cashoutHistoryDTOS, (Integer) objects[0]);
//        } catch (Exception e) {
//            response.setFailed(e.getMessage());
//        }
//        return response;
        return null;
    }

    @Override
    public BaseResponse saveCashoutHistory(CashoutHistory cashoutHistory) {
        TblCashoutHistoryEntity result = null;
        try {
            TblCashoutHistoryEntity entity = cashOutHistoryBeanUtil.dto2Entity(cashoutHistory);
            result = cashoutHistoryRepo.save(entity);
        } catch (Exception e) {

        }
        SimpleResponse response = new SimpleResponse();
        if (result == null)
            response.setResult(false, "Not save");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse updateCashoutHistory(CashoutHistory cashoutHistory) {
        TblCashoutHistoryEntity result = null;
        try {
            TblCashoutHistoryEntity entity = cashOutHistoryBeanUtil.dto2Entity(cashoutHistory);
            result = cashoutHistoryRepo.save(entity);
        } catch (Exception e) {

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse cashout(CashoutHistory cashoutHistory) {
        SimpleResponse response = new SimpleResponse();
        try {
            TblCashoutHistoryEntity cashoutHistoryEntity = cashOutHistoryBeanUtil.dto2Entity(cashoutHistory);
            TblShopEntity shopEntity = shopRepo.findById(cashoutHistory.getShopId()).get();
            if (shopEntity == null) {
                response.setResult(false, "Shop not Exist");
                return response;
            }
            if (shopEntity.getBalance() >= cashoutHistory.getAmount()) {
//                double lastbalance = shopEntity.getBalance();
//                shopEntity.setBalance(shopEntity.getBalance() - request.getAmount());
//                cashoutHistoryEntity.setShopId(shopEntity.getId());
//                cashoutHistoryEntity.setPart(RentUtil.buildPart(new Date()));
//                cashoutHistoryEntity.setLastBalance(lastbalance);
//                cashoutHistoryEntity.setAmount(request.getAmount());
//                TblShopEntity up = shopRepo.save(shopEntity);
//                if (up != null)
//                    cashoutHistoryEntity.setResult(1);
//                else
//                    cashoutHistoryEntity.setResult(0);
//                cashoutHistoryEntity.setCreatedTime(new Date());
//                cashoutHistoryEntity.setStatus(1);
//                cashoutHistoryEntity.setAfterBalance(shopEntity.getBalance());

                double lastbalance = shopEntity.getBalance();
                shopEntity.setBalance(shopEntity.getBalance() - cashoutHistory.getAmount());
                cashoutHistoryEntity.setShopId(cashoutHistory.getShopId());
                cashoutHistoryEntity.setPart(RentUtil.buildPart(new Date()));
                cashoutHistoryEntity.setLastBalance(lastbalance);
                cashoutHistoryEntity.setAmount(cashoutHistory.getAmount());
                TblShopEntity up = shopRepo.save(shopEntity);
                cashoutHistoryEntity.setAfterBalance(shopEntity.getBalance());
                if (up != null)
                    cashoutHistoryEntity.setResult(1);
                else
                    cashoutHistoryEntity.setResult(0);
                cashoutHistoryEntity.setStatus(1);
                cashoutHistoryEntity.setCreatedTime(new Timestamp(new Date().getTime()));
                cashoutHistoryRepo.save(cashoutHistoryEntity);
                response.setSuccess(true);
            } else
                response.setResult(false, "Bạn không đủ tiền để rút");
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


//    @Transactional(rollbackFor = Exception.class)
//    public BaseResponse cashout(CashoutRequest request, JwtUser jwtUser) {
//        BaseResponse response = new BaseResponse();
//        try {
//
//            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
//            if (userEntity == null) {
//                response.setFailed("Người dùng  không tồn tại.");
//                return response;
//            }
//            TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
//            if (shopEntity == null) {
//                response.setFailed("Bạn chưa tạo shop.");
//                return response;
//            }
//
//            TblCashoutHistoryEntity cashoutHistoryEntity = new TblCashoutHistoryEntity();
//            if (shopEntity.getBalance() >= request.getAmount()) {
//                double lastbalance = shopEntity.getBalance();
//                shopEntity.setBalance(shopEntity.getBalance() - request.getAmount());
//                cashoutHistoryEntity.setShopId(shopEntity.getId());
//                cashoutHistoryEntity.setPart(RentUtil.buildPart(new Date()));
//                cashoutHistoryEntity.setLastBalance(lastbalance);
//                cashoutHistoryEntity.setAmount(request.getAmount());
//                TblShopEntity up = shopRepo.save(shopEntity);
//                if (up != null)
//                    cashoutHistoryEntity.setResult(1);
//                else
//                    cashoutHistoryEntity.setResult(0);
//                cashoutHistoryEntity.setCreatedTime(new Date());
//                cashoutHistoryRepo.save(cashoutHistoryEntity);
//                response.setSuccess();
//            } else
//                response.setFailed("Bạn không đủ tiền");
//        } catch (Exception e) {
//            response.setFailed(e.getMessage());
//        }
//        return response;
//    }

}
