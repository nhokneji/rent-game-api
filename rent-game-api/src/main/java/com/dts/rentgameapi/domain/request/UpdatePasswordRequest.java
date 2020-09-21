package com.dts.rentgameapi.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS (Nguyễn Văn Đức 57TH4)
 */
@Getter
@Setter
public class UpdatePasswordRequest {
    private String new_password;
    private String old_password;

    public boolean validate()
    {
        if (old_password==null||new_password==null)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UpdatePasswordRequest{" +
                "new_password='" + new_password + '\'' +
                ", old_password='" + old_password + '\'' +
                '}';
    }
}
