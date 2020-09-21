package com.dts.rentgameapi.security.login;

import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.repo.CategoryRepo;
import com.dts.rentgameapi.repo.ShopRepo;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.jwt.JwtAuthenticationToken;
import com.dts.rentgameapi.security.jwt.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Rin-DTS
 */
@Component
public class JwtAuthenticationLoginProvider implements AuthenticationProvider {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ShopRepo shopRepo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationLogin authenLogin = (JwtAuthenticationLogin) authentication;
        JwtUserDetails jwtUserDetails = authenLogin.getPrincipal();
        TblUserEntity userEntity = null;

        userEntity = userRepo.findByUsername(jwtUserDetails.getUsername());
        if (userEntity == null) {
            throw new UsernameNotFoundException("Người dùng này không tồn tại. Mật khẩu hoặc passowrd bị sai.");
        }
        if (!new BCryptPasswordEncoder().matches(authenLogin.getCredentials(), userEntity.getPassword())) {
            throw new AuthenticationServiceException("Mật khẩu sai.");
        }
        userEntity.setLastLoginTime(new Timestamp(new Date().getTime()));
        userEntity.setToken(authenLogin.getPrincipal().getToken());
        userRepo.save(userEntity);
        return new JwtAuthenticationToken(
                authenLogin.getPrincipal(),
                authenLogin.getCredentials(),
                jwtUserDetails.getToken());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(
                JwtAuthenticationLogin.class);
    }
}
