package com.dts.rentgameapi.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Rin-DTS
 */
public class AuthenticationUsernamePasswordInvalidException extends AuthenticationException {
    public AuthenticationUsernamePasswordInvalidException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationUsernamePasswordInvalidException(String msg) {
        super(msg);
    }
}
