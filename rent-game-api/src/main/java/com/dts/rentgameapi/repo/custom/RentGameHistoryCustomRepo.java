package com.dts.rentgameapi.repo.custom;

import com.dts.rentgameapi.domain.dto.mapping.GameAggregateMoneyMapping;
import com.dts.rentgameapi.domain.dto.mapping.RentHisShopGameAccountMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public class RentGameHistoryCustomRepo extends BaseCustomRepo {
    public List<GameAggregateMoneyMapping> aggregateMoney(int shop_id, int status) {
        List<GameAggregateMoneyMapping> gameAggregateMonies = null;
        try {
            StoredProcedureQuery query = this.entityManager
                    .createStoredProcedureQuery("ProcGamesAggregateMoney", "GameAggregateMoneyEntityMapping");
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.setParameter(1, shop_id);
            query.setParameter(2, status);
            query.execute();
            gameAggregateMonies = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return gameAggregateMonies;
    }


    public List<RentHisShopGameAccountMapping> rentGameByShopId(int shop_id, int start, int limit) {
        List<RentHisShopGameAccountMapping> shopGameAccountEntities = null;
        try {
            StoredProcedureQuery query = this.entityManager
                    .createStoredProcedureQuery("ProcRentHistoryByShop", "RentHisShopGameAccountMapping");
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            query.setParameter(1, shop_id);
            query.setParameter(2, start);
            query.setParameter(3, limit);
            query.execute();
            shopGameAccountEntities = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return shopGameAccountEntities;
    }

}
