package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.Vip;
import com.dts.rentgameapi.domain.dto.ver1.ChargeHistory;
import com.dts.rentgameapi.domain.entity.TblChargeHistoryEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.request.ChargeRequest;
import com.dts.rentgameapi.domain.response.ChargeHistoryResponse;
import com.dts.rentgameapi.domain.response.ListChargeHistoryResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.ChargeHistoryRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.ChargeHistoryService;
import com.dts.rentgameapi.utils.ChargeHistoryBeanUtil;
import com.dts.rentgameapi.utils.RentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Rin-DTS
 */
@Service
public class ChargeHistoryServiceImpl extends BaseService implements ChargeHistoryService {

    @Autowired
    private ChargeHistoryRepo chargeHistoryRepo;

    @Autowired
    private ChargeHistoryBeanUtil chargeHistoryBeanUtil;

    @Autowired
    private UserRepo userRepo;

    @Override
    public BaseResponse findById(Integer id) {
        ChargeHistoryResponse response = new ChargeHistoryResponse();
        ChargeHistory chargeHistory = null;
        try {
            TblChargeHistoryEntity entity = chargeHistoryRepo.findById(id).get();
            chargeHistory = chargeHistoryBeanUtil.entity2Dto(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (chargeHistory == null)
            response.setItemNotFound();
        else
            response.setSuccess(chargeHistory);
        return response;

    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {

//        ListChargeHistoryResponse response = new ListChargeHistoryResponse();
//        try {
//            Object[] objects = chargeHistoryDaoImpl.findByProperty(property, sortExpression, sortDirection, offset, limit, null);
//            List<ChargeHistoryDTO> chargeHistoryDTOS = new ArrayList<>();
//            for (ChargeHistoryEntity item : (List<ChargeHistoryEntity>) objects[1]) {
//                ChargeHistoryDTO chargeHistoryDTO = chargeHistoryBeanUtil.entity2Dto(item);
//                chargeHistoryDTOS.add(chargeHistoryDTO);
//            }
//
//            response.setResult(chargeHistoryDTOS, (Integer) objects[0]);
//        } catch (Exception e) {
//            response.setFailed(e.getMessage());
//        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse saveChargeHistory(ChargeRequest request) {
        SimpleResponse response = new SimpleResponse();
        Random rd = new Random();
        ChargeHistory chargeHistory = new ChargeHistory();
        TblChargeHistoryEntity re = null;
        try {
            if (rd.nextBoolean()) {
                response.setResult(false, "Thẻ nạp sai vui lòng kiểm tra lại");
                return response;
            }

            TblUserEntity userEntity = userRepo.findByUsername(request.getUsername());
            if (userEntity == null) {
                response.setResult(false, "Không tìm thấy người dùng :" + request.getUsername());
                return response;
            }
            chargeHistory.setType(request.getType());
            chargeHistory.setCardCode(request.getCardCode());
            chargeHistory.setExplains(request.getExplains());
            chargeHistory.setSerial(request.getSerial());
            chargeHistory.setUserId(userEntity.getUserId());
            TblChargeHistoryEntity chargeHistoryEntity = chargeHistoryBeanUtil.dto2Entity(chargeHistory);
            chargeHistoryEntity.setPart(RentUtil.buildPart(new Date()));
            String trans_id = RentUtil.buildTransId(new Date(), request.getUsername());
            userEntity.setBalance(userEntity.getBalance() + 20000);
            userEntity.setVip(Vip.getVip(userEntity.getTotalAmount()));
            userRepo.save(userEntity);
            chargeHistoryEntity.setTransId(trans_id);
            chargeHistoryEntity.setResult(1);
            chargeHistoryEntity.setValue(20000.0);
            chargeHistoryEntity.setTransactionTime(getCurrentTimestamp());
            re = chargeHistoryRepo.save(chargeHistoryEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (re == null)
            response.setResult(false, "Lỗi Server vui lòng thử lại sau.");
        else {
            response.setSuccess(true);
            response.setMessage("Bạn đã nạp thành công 20K.");
        }
        return response;
    }

    @Override
    public BaseResponse updateChargeHistory(ChargeHistory chargeHistory) {
        TblChargeHistoryEntity result = null;
        try {
            TblChargeHistoryEntity entity = chargeHistoryBeanUtil.dto2Entity(chargeHistory);
            result = chargeHistoryRepo.save(entity);
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

    public BaseResponse findByUserId(String username, Integer from, Integer to) {
        ListChargeHistoryResponse response = new ListChargeHistoryResponse();
        List<ChargeHistory> rentHistories = new ArrayList<>();
        try {
            int user_id = userRepo.findByUsername(username).getUserId();
            List<TblChargeHistoryEntity> chargeHistoryEntities = chargeHistoryRepo.findByUserIdPartBetween(user_id, from, to);
            chargeHistoryEntities.forEach(tblChargeHistoryEntity -> rentHistories.add(chargeHistoryBeanUtil.entity2Dto(tblChargeHistoryEntity)));
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        response.setResult(rentHistories, rentHistories.size());
        return response;
    }

    public BaseResponse findByUserIdPages(String username, Integer start, Integer limit) {
        ListChargeHistoryResponse response = new ListChargeHistoryResponse();
        List<ChargeHistory> chargeHistories = new ArrayList<>();
        long total = 0;
        try {
            int user_id = userRepo.findByUsername(username).getUserId();
            List<TblChargeHistoryEntity> chargeHistoryEntities = chargeHistoryRepo.findByUSerIDAndPages(user_id, start, limit);
            chargeHistoryEntities.forEach(tblChargeHistoryEntity -> chargeHistories.add(chargeHistoryBeanUtil.entity2Dto(tblChargeHistoryEntity)));
            total = chargeHistoryRepo.countByUserId(user_id);
        } catch (Exception e) {
            response.setResult(chargeHistories, total, e.getMessage());
            return response;
        }
        if (chargeHistories == null) {
            response.setSuccess(chargeHistories, total);
        } else {
            response.setSuccess(chargeHistories, total);
        }
        return response;
    }

//    public BaseResponse findIntervalDate(Integer from, Integer to, Integer user_id) {
//        ListChargeHistoryResponse response = new ListChargeHistoryResponse();
//        try {
//            Object[] objects = chargeHistoryDaoImpl.findIntervalDate(from, to, user_id);
//            List<ChargeHistoryDTO> chargeHistoryDTOS = new ArrayList<>();
//            for (ChargeHistoryEntity item : (List<ChargeHistoryEntity>) objects[1]) {
//                ChargeHistoryDTO chargeHistoryDTO = chargeHistoryBeanUtil.entity2Dto(item);
//                chargeHistoryDTOS.add(chargeHistoryDTO);
//            }
//            response.setResult(chargeHistoryDTOS, (Integer) objects[0]);
//        } catch (Exception e) {
//            response.setFailed(e.getMessage());
//        }
//
//        return response;
//    }
}
