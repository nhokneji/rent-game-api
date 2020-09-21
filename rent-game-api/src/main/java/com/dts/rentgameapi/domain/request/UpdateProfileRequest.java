package com.dts.rentgameapi.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS (Nguyễn Văn Đức 57TH4)
 */
@Getter
@Setter
public class UpdateProfileRequest {
    private String email;
    private String moblie;
    private String avatar;
    private String display_name;

    public boolean validate() {
        if ( email == null || moblie == null|| avatar == null||display_name==null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UpdateProfileRequest{" +
                "email='" + email + '\'' +
                ", moblie='" + moblie + '\'' +
                ", avatar='" + avatar + '\'' +
                ", display_name='" + display_name + '\'' +
                '}';
    }
}
