package com.dts.rentgameapi.repo.custom;

import com.dts.rentgameapi.domain.dto.mapping.DetailGameAccountMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public class GameAccountCustomRepo extends BaseCustomRepo {

    public List<DetailGameAccountMapping> findGameAccountByShopId(int shop_id, int start, int limit) {
        List<DetailGameAccountMapping> detailGameAccountEntities = null;
        try {
            StoredProcedureQuery query = this.entityManager
                    .createStoredProcedureQuery("ProcGetListGameAccountByShopId", "DetailGameAccountEntityMapping");
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            query.setParameter(1,shop_id);
            query.setParameter(2,start);
            query.setParameter(3,limit);
            query.execute();
            detailGameAccountEntities = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return detailGameAccountEntities;
    }


}
