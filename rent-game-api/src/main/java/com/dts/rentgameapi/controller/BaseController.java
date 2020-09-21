package com.dts.rentgameapi.controller;

import com.dts.rentgameapi.security.JwtValidator;
import com.dts.rentgameapi.security.jwt.JwtUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

/**
 * @author Rin-DTS
 */
public class BaseController {
    @Autowired
    private JwtValidator jwtValidator;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected JwtUser retrieveJwtUser(HttpHeaders httpHeaders) {
        String token = httpHeaders.get("Rin-Author").toString();
        token = token.substring(1, token.length() - 1);
        return jwtValidator.validate(token);
    }


}
