package com.dts.rentgameapi.domain.response.base;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SingleItemResponse;

/**
 * @author Rin-DTS
 */
public class LoginResponse extends BaseResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse() {}

    public LoginResponse(String message, int code, String token) {
        super(message, code);
        this.token = token;
    }

    public void setSuccess(String token) {
        super.setSuccess();
        this.token = token;
    }

    public void setResult(String token, String msgError) {
        if (token == null) {
            super.setItemNotFound(msgError);
        } else {
            setSuccess(token);
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
