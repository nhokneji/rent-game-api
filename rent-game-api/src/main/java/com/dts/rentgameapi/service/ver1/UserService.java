package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.User;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */
public interface UserService {
    BaseResponse findById(Integer username);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveUser(User user);

    BaseResponse updateUser(User user);

    BaseResponse findAll();

}
