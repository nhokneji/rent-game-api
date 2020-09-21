package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.ver1.Category;
import com.dts.rentgameapi.domain.dto.ver1.Game;
import com.dts.rentgameapi.domain.entity.TblCategoryEntity;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import com.dts.rentgameapi.domain.response.CategoryResponse;
import com.dts.rentgameapi.domain.response.ListCategoryResponse;
import com.dts.rentgameapi.domain.response.ListGameResponse;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.domain.response.base.SimpleResponse;
import com.dts.rentgameapi.repo.CategoryRepo;
import com.dts.rentgameapi.repo.GameRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.service.ver1.CategoryService;
import com.dts.rentgameapi.utils.CategoryBeanUtil;
import com.dts.rentgameapi.utils.GameBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Rin-DTS
 */
@Service
public class CategoryServiceImpl extends BaseService implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private GameBeanUtil gameBeanUtil;

    @Autowired
    private CategoryBeanUtil categoryBeanUtil;

    @Override
    public BaseResponse findById(Integer id) {
        CategoryResponse response = new CategoryResponse();
        Category category = null;
        try {
            TblCategoryEntity providerEntity = categoryRepo.findById(id).get();
            category = categoryBeanUtil.entity2Dto(providerEntity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (category == null)
            response.setItemNotFound();
        else
            response.setSuccess(category);
        return response;
    }

    @Override
    public BaseResponse findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public BaseResponse saveCategory(Category category) {
        TblCategoryEntity re = null;
        try {
            TblCategoryEntity entity = categoryBeanUtil.dto2Entity(category);
            re = categoryRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (re == null)
            response.setResult(false, "Không thế tạo category");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse updateCategory(Category category) {
        TblCategoryEntity result = null;
        try {
            TblCategoryEntity entity = categoryBeanUtil.dto2Entity(category);
            result = categoryRepo.save(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        SimpleResponse response = new SimpleResponse();
        if (result == null)
            response.setResult(false, "Không thể update");
        else
            response.setSuccess(true);
        return response;
    }

    @Override
    public BaseResponse findAll() {
        Iterator<TblCategoryEntity> userEntities = categoryRepo.findAll().iterator();
        List<Category> users = new ArrayList<>();
        userEntities.forEachRemaining(tblUserEntity -> {
            users.add(categoryBeanUtil.entity2Dto(tblUserEntity));
        });
        ListCategoryResponse response = new ListCategoryResponse();
        response.setResult(users, users.size());
        return response;
    }

    public BaseResponse getListGameByCatId(Integer cat_id, Integer start, Integer limmit) {
        ListGameResponse response = new ListGameResponse();
        List<TblGameEntity> result = new ArrayList<>();
        List<Game> games = new ArrayList<>();
        long total = 0;
        try {
            result = gameRepo.findGamesByCategoryId(cat_id, start, limmit);
            result.forEach(tblGameEntity -> {
                games.add(gameBeanUtil.entity2Dto(tblGameEntity));
            });
            total=gameRepo.countByCategoryId(cat_id);
        } catch (Exception e) {
            response.setResult(games, total, e.getMessage());
            return response;
        }
        if (result == null) {
            response.setSuccess(games, total);
        } else {
            response.setSuccess(games, total);
        }
        return response;
    }

    public BaseResponse findAllByCatId(Integer cat_id) {
        ListGameResponse response = new ListGameResponse();
        List<TblGameEntity> result = new ArrayList<>();
        List<Game> games = new ArrayList<>();
        long total = 0;
        try {
            result = gameRepo.findAllByCategoryId(cat_id);
            result.forEach(tblGameEntity -> {
                games.add(gameBeanUtil.entity2Dto(tblGameEntity));
            });
            total=result.size();
        } catch (Exception e) {
            response.setResult(games, total, e.getMessage());
            return response;
        }
        if (result == null) {
            response.setSuccess(games, total);
        } else {
            response.setSuccess(games, total);
        }
        return response;

    }
}
