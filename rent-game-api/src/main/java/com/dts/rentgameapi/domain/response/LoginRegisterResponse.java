package com.dts.rentgameapi.domain.response;

import com.dts.rentgameapi.domain.response.base.BaseResponse;

/**
 * @author Rin-DTS
 */
public class LoginRegisterResponse extends BaseResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public LoginRegisterResponse(String token) {
        setSuccess();
        this.token = token;
    }


    public void setToken(String token) {
        this.token = token;
    }

    public LoginRegisterResponse(String message, int code) {
        super(message, code);
        this.token = "@@@";
    }


    @Override
    public String toString() {
        return "LoginRegisterResponse{" +
                "token='" + token + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
