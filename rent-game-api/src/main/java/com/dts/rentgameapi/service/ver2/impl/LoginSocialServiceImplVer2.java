package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.RentConstant;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.request.LoginFacebookRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.LoginResponse;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.JwtGenerator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.LoginSocialServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Rin-DTS
 */
@Service
public class LoginSocialServiceImplVer2 extends BaseService implements LoginSocialServiceVer2 {
    @Autowired
    private UserRepo userRepo;

    @Override
    public BaseResponse loginFacebook(LoginFacebookRequest request) {
        LoginResponse response = new LoginResponse();
        JwtGenerator jwtGenerator = new JwtGenerator();
        try {
            TblUserEntity userEntity = userRepo.findByUsername(request.getIdentity());
            JwtUser jwtUser = new JwtUser();
            jwtUser.setUsername(request.getIdentity());
            jwtUser.setPassword(RentConstant.FACEBOOK_PASSWORD);
            String token = jwtGenerator.generate(jwtUser);
            if (userEntity == null) {
                userEntity = new TblUserEntity();
                userEntity.setType(TblUserEntity.Type.FACEBOOK.getTypeValue());
                userEntity.setDisplayName(request.getName());
                userEntity.setUsername(request.getIdentity());
                userEntity.setLastUpdateTime(getCurrentTimestamp());
                userEntity.setCreateTime(getCurrentTimestamp());
                userEntity.setLastLoginTime(getCurrentTimestamp());
                userEntity.setAvatar(request.getAvatar());
                userEntity.setBalance(0);
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String passwordEncode = passwordEncoder.encode(RentConstant.FACEBOOK_PASSWORD);
                userEntity.setPassword(passwordEncode);
                userEntity.setToken(token);
                userEntity.setLevel(1);
            } else {
                if (!userEntity.getDisplayName().equals(request.getName())) {
                    userEntity.setDisplayName(request.getName());
                    userEntity.setLastUpdateTime(getCurrentTimestamp());
                }
                if (!userEntity.getAvatar().equals(request.getAvatar())) {
                    userEntity.setAvatar(request.getAvatar());
                    userEntity.setLastUpdateTime(getCurrentTimestamp());
                }
                userEntity.setToken(token);
                userEntity.setLastLoginTime(getCurrentTimestamp());
            }
            userRepo.save(userEntity);
            response.setSuccess(token);
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setFailed("Server Error");
        }
        return response;
    }
}
