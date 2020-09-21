package com.dts.rentgameapi.security;

import com.dts.rentgameapi.RentConstant;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.security.jwt.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author Rin-DTS
 */
public class JwtGenerator {
	final String SECRET = "md-cinema";
    public String generate(JwtUser jwtUser) {
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());
        claims.put("password", jwtUser.getPassword());
        claims.put("roles", jwtUser.getRoles());
        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + RentConstant.TIME_TOKEN_EXPIRE))
                .compact();
    }

}
