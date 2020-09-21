package com.dts.rentgameapi.service.ver2;

import com.dts.rentgameapi.domain.request.UpdateProfileRequest;
import com.dts.rentgameapi.domain.response.base.BaseResponse;
import org.springframework.http.HttpHeaders;

/**
 * @author Rin-DTS (Nguyễn Văn Đức 57TH4)
 */
public interface UserServiceVer2 {

    BaseResponse updateProfile(UpdateProfileRequest request, HttpHeaders headers);
}
