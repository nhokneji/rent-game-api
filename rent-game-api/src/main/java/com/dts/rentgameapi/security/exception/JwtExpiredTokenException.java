package com.dts.rentgameapi.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Rin-DTS
 */
public class JwtExpiredTokenException extends AuthenticationException {
    private String token;
    public JwtExpiredTokenException(String msg, String token, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
