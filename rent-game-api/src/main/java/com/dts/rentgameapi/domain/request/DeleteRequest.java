package com.dts.rentgameapi.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Setter
@Getter
public class DeleteRequest {
    private Integer id;
    @Override
    public String toString() {
        return "DeleteRequest{" +
                "id=" + id +
                '}';
    }
}
