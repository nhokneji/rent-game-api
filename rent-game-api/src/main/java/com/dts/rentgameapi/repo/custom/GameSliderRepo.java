package com.dts.rentgameapi.repo.custom;

import com.dts.rentgameapi.domain.dto.mapping.GameSliderMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public class GameSliderRepo extends BaseCustomRepo {
    public List<GameSliderMapping> findAll() {
        List<GameSliderMapping> gameSliders = null;
        String sql = "SELECT b.*,a.id as slider_id " +
                "FROM tbl_slider a  inner join tbl_game b " +
                "on a.game_id=b.id";
        try {
            Query query = this.entityManager.createNativeQuery(sql, "GameSliderMapping");
            gameSliders = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return gameSliders;
    }
}
