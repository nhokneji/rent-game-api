package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.request.CreateShopRequset;
import com.dts.rentgameapi.domain.request.UpdateShopRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.ShopServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Rin-DTS
 */
@Service
public class ShopServiceImplVer2 extends BaseService implements ShopServiceVer2 {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public BaseResponse checkShopName(JwtUser jwtUser) {
        BaseResponse response = new BaseResponse();
        try {
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
            if (shopEntity == null) {
                response.setFailed("Bạn chưa tạo shop");
                return response;
            }
            response.setSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return response;
    }


    @Override
    public BaseResponse createShop(CreateShopRequset requset, JwtUser jwtUser) {
        SingleItemResponse<String> response = new SingleItemResponse<>();
        try {
            if (!requset.validate())
                response.setFailed();
            else {
                TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
                if (userEntity.getBalance() < requset.getBalance()) {
                    response.setFailed("Bạn không đủ tiền để mở shop. Vui lòng nạp thêm tiền.");
                    return response;
                }
                if (shopRepo.existsByAlias(requset.getAlias())) {
                    response.setFailed("Alias đã tồn tại");
                    return response;
                }
                TblShopEntity shopEntity = new TblShopEntity();
                shopEntity.setAlias(requset.getAlias());
                shopEntity.setBalance(requset.getBalance());
                shopEntity.setCreatedTime(getCurrentTimestamp());
                shopEntity.setDescription(requset.getDescription());
                shopEntity.setFacebookLink(requset.getFacebook_link());
                shopEntity.setIconPath(requset.getLogo());
                shopEntity.setLinkShop(requset.getLink_shop());
                shopEntity.setPhone(requset.getPhone());
                shopEntity.setSlogan(requset.getSlogan());
                shopEntity.setShopName(requset.getShop_name());
                shopEntity.setUserId(userEntity.getUserId());
                shopRepo.save(shopEntity);
                response.setSuccess("OK");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return response;
    }

    @Override
    public BaseResponse update(UpdateShopRequest request, JwtUser jwtUser) {
        SingleItemResponse<Boolean> response = new SingleItemResponse<>();
        try {
            if (!request.validate())
                response.setFailed();
            else {
                TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
                TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
                if (shopEntity == null) {
                    response.setResult(null, "Bạn chưa tạo shop");
                    return response;
                }
                shopEntity.setAlias(request.getAlias());
                shopEntity.setCreatedTime(getCurrentTimestamp());
                shopEntity.setDescription(request.getDescription());
                shopEntity.setFacebookLink(request.getFacebook_link());
                shopEntity.setIconPath(request.getLogo());
                shopEntity.setLinkShop(request.getLink_shop());
                shopEntity.setPhone(request.getPhone());
                shopEntity.setSlogan(request.getSlogan());
                shopEntity.setShopName(request.getShop_name());
                shopEntity.setUserId(userEntity.getUserId());
                shopRepo.save(shopEntity);
                response.setSuccess(true);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return response;
    }

    @Override
    public BaseResponse findGameAccountByShop(JwtUser retrieveJwtUser) {
        return null;
    }
}
