package com.dts.rentgameapi.security.register;

import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.repo.UserRepo;
import com.dts.rentgameapi.security.exception.AuthenticationUsernamePasswordInvalidException;
import com.dts.rentgameapi.security.jwt.JwtAuthenticationToken;
import com.dts.rentgameapi.security.jwt.JwtUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;


@Component
public class JwtRegisterProvider implements AuthenticationProvider {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationRegister register = (JwtAuthenticationRegister) authentication;
        JwtUserDetails jwtUserDetails = register.getPrincipal();
        TblUserEntity userEntities = userRepo.findByUsername(jwtUserDetails.getUsername());
        if (userEntities != null) {
            throw new AuthenticationUsernamePasswordInvalidException("Người dùng này đã tồn tại.");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncode = passwordEncoder.encode(register.getCredentials());


        TblUserEntity insert = new TblUserEntity();
        insert.setUsername(register.getPrincipal().getUsername());
        insert.setPassword(passwordEncode);

        insert.setEmail(register.getEmail());
        insert.setMoblie(register.getPhone());
        insert.setToken(register.getPrincipal().getToken());
        insert.setCreateTime(new Timestamp(new Date().getTime()));
        insert.setLastUpdateTime(new Timestamp(new Date().getTime()));
        insert.setLastLoginTime(new Timestamp(new Date().getTime()));
        insert.setDisplayName(register.getDisplay_name());
        insert.setType(TblUserEntity.Type.APP.getTypeValue());
        TblUserEntity result = userRepo.save(insert);
        if (result == null) {
            throw new AuthenticationServiceException("Can not insert user into database");
        }
        return new JwtAuthenticationToken(
                register.getPrincipal(),
                register.getCredentials(),
                jwtUserDetails.getToken());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(JwtAuthenticationRegister.class);
    }
}
