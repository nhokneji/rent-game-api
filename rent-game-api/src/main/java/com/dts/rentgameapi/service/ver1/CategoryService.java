package com.dts.rentgameapi.service.ver1;

import com.dts.rentgameapi.domain.dto.ver1.Category;
import com.dts.rentgameapi.domain.response.base.BaseResponse;

import java.util.Map;

/**
 * @author Rin-DTS
 */

public interface CategoryService {
    BaseResponse findById(Integer id);

    BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

    BaseResponse saveCategory(Category category);

    BaseResponse updateCategory(Category category);

    BaseResponse findAll();
}
