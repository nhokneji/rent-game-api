package com.dts.rentgameapi.controller.ver1.auth;

import com.dts.rentgameapi.domain.dto.ver1.Provider;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import com.dts.rentgameapi.service.ver1.impl.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rin-DTS
 */
@RestController
@RequestMapping("/auth/api/provider")
public class ProviderController {
    @Autowired
    private ProviderServiceImpl providerServiceImpl;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Integer id) {
        BaseResponse response = null;
        try {
            response = providerServiceImpl.findById(id);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse create(@RequestBody Provider provider) {
        BaseResponse response = null;
        try {
            response = providerServiceImpl.saveProvide(provider);
        } catch (Exception e) {
            response.setFailed(e.getMessage());
        }
        return response;
    }

}
