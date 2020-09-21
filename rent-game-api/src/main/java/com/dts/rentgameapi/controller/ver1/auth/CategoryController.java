package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.dto.ver1.Category;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@CrossOrigin
@RequestMapping("/auth/api/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestBody Category category) {
        BaseResponse response = null;
        try {
            response = categoryServiceImpl.saveCategory(category);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public BaseResponse update(@PathVariable long id, @RequestBody Category category) {
        BaseResponse response = null;
        try {
            response = categoryServiceImpl.updateCategory(category);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
    }

}
