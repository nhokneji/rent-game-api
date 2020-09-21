package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.CashoutHistory;
import com.dts.rentgameapi.domain.dto.ver1.RentHistory;
import com.dts.rentgameapi.domain.dto.ver1.Shop;
import com.dts.rentgameapi.domain.entity.TblCashoutHistoryEntity;
import com.dts.rentgameapi.domain.entity.TblRentHistoryEntity;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.response.ListCashoutHistoryResponse;
import com.dts.rentgameapi.domain.response.ListRentHistoryResponse;
import com.dts.rentgameapi.domain.response.ShopResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.CashoutHistoryRepo;
import com.dts.rentgameapi.repo.RentHistoryRepo;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.ShopService;
import com.dts.rentgameapi.utils.CashOutHistoryBeanUtil;
import com.dts.rentgameapi.utils.RentHistoryBeanUtil;
import com.dts.rentgameapi.utils.ShopBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class ShopServiceImpl extends BaseService implements ShopService {

    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private ShopBeanUtil shopBeanUtil;


    @Autowired
    private CashOutHistoryBeanUtil cashOutHistoryBeanUtil;

    @Autowired
    private CashoutHistoryRepo cashoutHistoryRepo;

    @Autowired
    private RentHistoryRepo rentHistoryRepo;

    @Autowired
    private RentHistoryBeanUtil rentHistoryBeanUtil;


//    public BaseResponse findByUserId(Integer user_id)
//    {
//        ShopResponse response = new ShopResponse();
//        if (user_id == -1) {
//            response.setItemNotFound();
//            return response;
//        }
//        Shop shop = null;
//        try {
//            TblShopEntity shopEntity = shopRepo.findByUserId(user_id);
//            shop = shopBeanUtil.entity2Dto(shopEntity);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        if (shop == null)
//            response.setItemNotFound();
//        else
//            response.setSuccess(shop);
//        return response;
//    }
//

    @Override
    public BaseResponse findById(Integer id) {
        ShopResponse response = new ShopResponse();
        if (id == -1) {
            response.setItemNotFound();
            return response;
        }
        Shop shop = null;
        try {
            TblShopEntity shopEntity = shopRepo.findById(id).get();
            shop = shopBeanUtil.entity2Dto(shopEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (shop == null)
            response.setItemNotFound();
        else
            response.setSuccess(shop);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveShop(Shop shop) {
        TblShopEntity re = null;
        try {
            TblShopEntity entity = shopBeanUtil.dto2Entity(shop);
            re = shopRepo.save(entity);
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
    public BaseResponse updateShop(Shop shop) {
        TblShopEntity result = null;
        try {
            TblShopEntity entity = shopBeanUtil.dto2Entity(shop);
            result = shopRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (result == null)
            response.setResult(false, "Not update shop");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse findAll() {
        return null;
    }

    public BaseResponse cashoutHistoryByPage(Integer shop_id, Integer start, Integer limit) {
        ListCashoutHistoryResponse response = new ListCashoutHistoryResponse();
        List<CashoutHistory> result = new ArrayList<>();
        List<TblCashoutHistoryEntity> entities;
        long total = 0;
        try {
            entities = cashoutHistoryRepo.findByShopIdPages(shop_id, start, limit);

            entities.forEach(tblCashoutHistoryEntity -> result.add(cashOutHistoryBeanUtil.entity2Dto(tblCashoutHistoryEntity)));
            total = cashoutHistoryRepo.countByShopId(shop_id);
        } catch (Exception e) {
            response.setResult(result, total, e.getMessage());
            return response;
        }
        response.setResult(result, total);
        return response;
    }

    public BaseResponse rentHistoryByPage(Integer shop_id, Integer start, Integer limit) {
        ListRentHistoryResponse response = new ListRentHistoryResponse();
        List<RentHistory> result = new ArrayList<>();
        List<TblRentHistoryEntity> entities;
        long total = 0;
        try {
            entities = rentHistoryRepo.findByShopIdPages(shop_id, start, limit);
            entities.forEach(tblRentHistoryEntity -> result.add(rentHistoryBeanUtil.entity2Dto(tblRentHistoryEntity)));
            total = rentHistoryRepo.countByShopId(shop_id);
        } catch (Exception e) {
            response.setResult(result, total, e.getMessage());
            return response;
        }
        response.setResult(result, total);
        return response;
    }

    public BaseResponse findShopByUserId(int userId) {
        ShopResponse response = new ShopResponse();
        Shop shop = null;
        try {
            TblShopEntity shopEntity = shopRepo.findByUserId(userId);
            shop = shopBeanUtil.entity2Dto(shopEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (shop == null)
            response.setItemNotFound();
        else
            response.setSuccess(shop);
        return response;
    }
}
