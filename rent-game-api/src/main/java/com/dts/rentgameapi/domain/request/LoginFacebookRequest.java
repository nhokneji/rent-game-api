package com.dts.rentgameapi.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Setter
@Getter
public class LoginFacebookRequest {
    private String identity;
    private String avatar;
    private String name;

    public boolean validate() {
        if (identity == null || name == null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LoginFacebookRequest{" +
                "identity='" + identity + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
