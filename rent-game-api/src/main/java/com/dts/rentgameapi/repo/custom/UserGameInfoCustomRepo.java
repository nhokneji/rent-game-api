package com.dts.rentgameapi.repo.custom;

import com.dts.rentgameapi.domain.dto.mapping.UserRentGameInfoMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public class UserGameInfoCustomRepo extends BaseCustomRepo {

    public List<UserRentGameInfoMapping> findByGameStore(Integer store_id, Integer start, Integer limit) {
        List<UserRentGameInfoMapping> userRentGameInfos = null;
        String sql = "SELECT distinct a.*,b.status as game_status FROM ezplay.tbl_game a " +
                "inner join tbl_user_game_info b " +
                "on a.id=b.game_id where a.store_id = :store_id limit :start,:limit";
        try {
            Query query = this.entityManager.createNativeQuery(sql, "UserRentGameInfoMapping");
            query.setParameter("store_id", store_id);
            query.setParameter("start", start);
            query.setParameter("limit", limit);
            userRentGameInfos = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e.getCause());
        }
        return userRentGameInfos;
    }

//    public List<UserRentGameInfoMapping> findGamesByPages(List<Integer> ids, Integer store_id, Integer start, Integer limit) {
//        List<UserRentGameInfoMapping> gameSliders = null;
//        String sql = "SELECT * FROM ezplay.tbl_game a " +
//                "where  a.store_id = :store_id and a.id not in (:ids) limit :start,:limit";
//        try {
//            Query query = this.entityManager.createNativeQuery(sql, UserRentGameInfoMapping.class);
//            query.setParameter("store_id", store_id);
//            query.setParameter("ids", ids);
//            query.setParameter("start", start);
//            query.setParameter("limit", limit);
//            List list = query.getResultList();
//            gameSliders = list;
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        return gameSliders;
//
//    }
}
