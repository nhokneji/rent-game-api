package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.dto.ver1.Shop;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.ver1.impl.CashoutHistoryServiceImpl;
import com.dts.rentgameapi.service.ver1.impl.ShopServiceImpl;
import com.dts.rentgameapi.service.ver1.impl.UserRentGameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/shops")
public class ShopController {

    @Autowired
    private JwtValidator jwtValidator;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ShopRepo shopRepo;

    @Autowired
    private ShopServiceImpl shopServiceImpl;
    @Autowired
    private UserRentGameInfoService gameInfoService;

    @Autowired
    private CashoutHistoryServiceImpl cashoutHistoryServiceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestBody Shop shop,
                               @RequestHeader HttpHeaders header) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        JwtUser jwtUser = jwtValidator.validate(token);
        BaseResponse response = null;
        try {
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
            if (shopEntity != null)
                response.setFailed("Bạn đã có một shop không thể tạo thêm shop");
            else {
                shop.setUserId(userEntity.getUserId());

                response = shopServiceImpl.saveShop(shop);
            }
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @GetMapping
    public BaseResponse findById(@RequestHeader HttpHeaders header) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        BaseResponse response = null;
        // gameInfoService.test();
        try {
            JwtUser jwtUser = jwtValidator.validate(token);

            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            response = shopServiceImpl.findShopByUserId(userEntity.getUserId());
            // TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
//            if (shopEntity == null)
//                response = shopServiceImpl.findById(-1);
//            else {
//                response = shopServiceImpl.findById(shopEntity.getId());
//            }
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/cashout-history")
    public BaseResponse cashout(@RequestHeader HttpHeaders header,
                                @RequestParam Integer start,
                                @RequestParam Integer limit) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        BaseResponse response = null;
        try {
            JwtUser jwtUser = jwtValidator.validate(token);
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
            if (start < 0) {
                start = 0;
                limit = 100;
                response = shopServiceImpl.cashoutHistoryByPage(shopEntity.getId(), start, limit);
            } else
                response = shopServiceImpl.cashoutHistoryByPage(shopEntity.getId(), start, limit);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping("/rent-history")
    public BaseResponse getRentHistory(@RequestHeader HttpHeaders header,
                                       @RequestParam Integer start,
                                       @RequestParam Integer limit) {
        String token = header.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        BaseResponse response = null;
        try {
            JwtUser jwtUser = jwtValidator.validate(token);
            TblUserEntity userEntity = userRepo.findByUsername(jwtUser.getUsername());
            TblShopEntity shopEntity = shopRepo.findByUserId(userEntity.getUserId());
            if (shopEntity == null) {
                response=new BaseResponse();
                response.setFailed("Bạn chưa tạo shop");
                return response;
            }
            if (start < 0) {
                start = 0;
                limit = 100;
                response = shopServiceImpl.rentHistoryByPage(shopEntity.getId(), start, limit);
            } else
                response = shopServiceImpl.rentHistoryByPage(shopEntity.getId(), start, limit);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

}
