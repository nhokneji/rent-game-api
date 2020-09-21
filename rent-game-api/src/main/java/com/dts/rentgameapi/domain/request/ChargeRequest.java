package com.dts.rentgameapi.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class ChargeRequest {
    private String username;
    private String explains;
    private Integer type;
    private String serial;
    private String cardCode;

    @Override
    public String toString() {
        return "ChargeRequest{" +
                "username='" + username + '\'' +
                ", explains='" + explains + '\'' +
                ", type=" + type +
                ", serial='" + serial + '\'' +
                ", cardCode='" + cardCode + '\'' +
                '}';
    }
}
