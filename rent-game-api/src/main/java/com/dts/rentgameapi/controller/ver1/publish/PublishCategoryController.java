package com.dts.rentgameapi.controller.ver1.publish;

import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class PublishCategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = categoryServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

    @GetMapping
    public BaseResponse findAll() {
        BaseResponse response = null;
        try {
            response = categoryServiceImpl.findAll();
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @GetMapping("/games/{cat_id}")
    public BaseResponse getGames(@PathVariable Integer cat_id,
                                 @RequestParam Integer start,
                                 @RequestParam Integer limit) {
        BaseResponse response = null;
        try {
            if (start == -1) {
                response=categoryServiceImpl.findAllByCatId(cat_id);
            } else {
                response = categoryServiceImpl.getListGameByCatId(cat_id, start, limit);
            }
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


}
