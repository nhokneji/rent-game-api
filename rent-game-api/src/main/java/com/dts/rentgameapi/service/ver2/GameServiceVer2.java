package com.dts.rentgameapi.service.ver2;

        import com.dts.rentgameapi.domain.dto.ver1.Game;
        import com.dts.rentgameapi.domain.response.base.BaseResponse;

        import java.util.Map;

public interface GameServiceVer2 {
    BaseResponse findGameFormByOffset(String sortDirection, Integer start, Integer limit, Integer store_id, Integer category_id);

    BaseResponse findGamesOwnerByOffset(String sortDirection, Integer start, Integer limit, String user_name, Integer store_id, Integer category_id);

    BaseResponse findById(Integer id);
}
