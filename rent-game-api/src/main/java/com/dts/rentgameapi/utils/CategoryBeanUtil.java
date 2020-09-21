package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.Category;
import com.dts.rentgameapi.domain.entity.TblCategoryEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class CategoryBeanUtil implements IDataConvert<Category, TblCategoryEntity> {

    @Override
    public Category entity2Dto(TblCategoryEntity entity) {
        Category dto = new Category();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDesciption(entity.getDesciption());
        dto.setImage(entity.getImage());
        return dto;
    }

    @Override
    public TblCategoryEntity dto2Entity(Category dto) {
        TblCategoryEntity entity = new TblCategoryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDesciption(dto.getDesciption());
        entity.setImage(dto.getImage());
        return entity;
    }
}
