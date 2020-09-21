package com.dts.rentgameapi.service.ver1.impl;

import com.dts.rentgameapi.domain.dto.mapping.GameSliderMapping;
import com.dts.rentgameapi.repo.GameRepo;
import com.dts.rentgameapi.service.BaseService;
import com.dts.rentgameapi.utils.GameBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Service
public class UserRentGameInfoService extends BaseService {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private GameRepo gameRepo;
    @Autowired
    private GameBeanUtil gameBeanUtil;

    public void test()
    {
        List<GameSliderMapping> gameSliders=null;

                String sql = "SELECT b.*,a.id as slider_id " +
                        "FROM tbl_slider a  inner join tbl_game b " +
                        "on a.game_id=b.id; ";
        Query query = this.entityManager.createNativeQuery(sql, GameSliderMapping.class);
        gameSliders=query.getResultList();



        System.out.printf("");
    }

//    public BaseResponse getGamesByPage() {
//        int user_id = 4;
//        ListUserGameInfoResponse rentGameInfoResponse = new ListUserGameInfoResponse();
//        String sql = "SELECT distinct tbl_game_account.game_id " +
//                "FROM tbl_user inner join tbl_rent_history " +
//                "on tbl_rent_history.user_id=tbl_user.user_id " +
//                "inner join tbl_game_account " +
//                "on tbl_game_account.id=tbl_rent_history.account_id " +
//                "where tbl_user.user_id = :user_id";
//        Query query = this.entityManager.createNativeQuery(sql);
//        query.setParameter("user_id", user_id);
//        List<Integer> gameIds = query.getResultList();
//
//
//        Iterator<TblGameEntity> userEntities = gameRepo.findAll().iterator();
//        List<UserRentGameInfoMapping> games = new ArrayList<>();
//        userEntities.forEachRemaining(tblUserEntity -> {
//            UserRentGameInfoMapping userRentGameInfo = new UserRentGameInfoMapping();
//            userRentGameInfo.setId(tblUserEntity.getId());
//            userRentGameInfo.setId(tblUserEntity.getId());
//            userRentGameInfo.setCount(tblUserEntity.getId());
//            if (gameIds.contains(tblUserEntity.getId()))
//                userRentGameInfo.setStatus((byte) 1);
//            else
//                userRentGameInfo.setStatus((byte) 0);
//        });
//
//        ListGameResponse response = new ListGameResponse();
//        response.setResult(games, games.size());
//        return response;
//
//        System.out.println();
//        return null;
//    }
}
