package com.dts.rentgameapi.security;

import com.dts.rentgameapi.RentConstant;
import com.dts.rentgameapi.domain.response.LoginRegisterResponse;
import com.dts.rentgameapi.security.exception.AuthenticationUsernamePasswordInvalidException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Rin-DTS
 */
public class JwtAuthenticationLoginRegisterFailureHandler implements AuthenticationFailureHandler {
    private ObjectMapper objectMapper;

    public JwtAuthenticationLoginRegisterFailureHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setStatus(HttpStatus.OK.value());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        if (e instanceof AuthenticationUsernamePasswordInvalidException) {
//            objectMapper.writeValue(httpServletResponse.getWriter(), ResponseUtils.getBaseResponse(RentConstant.STATUS_CODE_USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
            objectMapper.writeValue(httpServletResponse.getWriter(), new LoginRegisterResponse(e.getMessage(), RentConstant.STATUS_CODE_USERNAME_OR_PASSWORD_INVALID));
        } else {
//            objectMapper.writeValue(httpServletResponse.getWriter(), ResponseUtils.getBaseResponse(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
            objectMapper.writeValue(httpServletResponse.getWriter(), new LoginRegisterResponse(e.getMessage(), HttpStatus.UNAUTHORIZED.value()));
        }
    }

}
