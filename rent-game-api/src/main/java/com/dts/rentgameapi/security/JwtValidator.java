package com.dts.rentgameapi.security;

import com.dts.rentgameapi.RentConstant;
import com.dts.rentgameapi.security.jwt.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class JwtValidator {
    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(RentConstant.SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setUsername(claims.getSubject());
            jwtUser.setPassword(claims.get("password").toString());
            jwtUser.setRoles(claims.get("roles").toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        return jwtUser;
    }
}
