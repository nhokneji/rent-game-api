package com.dts.rentgameapi.service.ver2.impl;

import com.dts.rentgameapi.domain.dto.ver1.User;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.domain.request.UpdatePasswordRequest;
import com.dts.rentgameapi.domain.request.UpdateProfileRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver2.UserServiceVer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Rin-DTS (Nguyễn Văn Đức 57TH4)
 */
@Service
public class UserServiceImplVer2 extends BaseService implements UserServiceVer2 {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtValidator jwtValidator;


    @Override
    public BaseResponse updateProfile(UpdateProfileRequest request, HttpHeaders headers) {
        SingleItemResponse<Boolean> response = new SingleItemResponse<>();
        try {
            String token = headers.get("Rin-Author").toString();
            token = token.substring(1, token.length() - 1);
            JwtUser jwtUser = jwtValidator.validate(token);
            TblUserEntity user = userRepo.findByUsername(jwtUser.getUsername());
            if (user == null)
                response.setResult(null, "Không tìm thấy user");
            else {
                if (user.getType() == TblUserEntity.Type.APP.getTypeValue()) {
                    user.setMoblie(request.getMoblie());
                    user.setEmail(request.getEmail());
                    user.setAvatar(request.getAvatar());
                    user.setDisplayName(request.getDisplay_name());
                    userRepo.save(user);
                    response.setSuccess(true);
                } else {
                    response.setResult(null, "Đây là tài khoản mạng xã hội không thể cập nhật thông tin bằng cách này.");
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setResult(null, "Server Error");
        }
        return response;
    }

    public BaseResponse updatePassword(UpdatePasswordRequest request, HttpHeaders headers) {
        SingleItemResponse<Boolean> response = new SingleItemResponse<>();
        try {
            String token = headers.get("Rin-Author").toString();
            token = token.substring(1, token.length() - 1);
            JwtUser jwtUser = jwtValidator.validate(token);
            TblUserEntity user = userRepo.findByUsername(jwtUser.getUsername());
            if (user == null)
                response.setResult(null, "Không tìm thấy user");
            else {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                if (!passwordEncoder.matches(request.getOld_password(), user.getPassword())) {
                    response.setResult(null, "Mật khẩu không đúng");
                    return response;
                }
                String passwordEncode = passwordEncoder.encode(request.getNew_password());
                user.setPassword(passwordEncode);
                userRepo.save(user);
                response.setSuccess(true);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
            response.setResult(null, "Server Error");
        }
        return response;
    }
}
