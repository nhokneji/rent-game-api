package com.dts.rentgameapi.repo.custom;

import com.dts.rentgameapi.domain.dto.mapping.RentChargeHistoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public class ChargeHistoryCustomRepo extends BaseCustomRepo {

    public List<RentChargeHistoryEntity> findRentChargeHistoryByUser(int limit, int start, String sort, int used_id) {
        List<RentChargeHistoryEntity> rentChargeHistoryMappings = null;
        try {
            StoredProcedureQuery query = this.entityManager
                    .createStoredProcedureQuery("ProcGetListChargeHistory", RentChargeHistoryEntity.class);
            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
            query.setParameter(1, start);
            query.setParameter(2, limit);
            query.setParameter(3, used_id);
            query.setParameter(4, sort);
            query.execute();
            rentChargeHistoryMappings = query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return rentChargeHistoryMappings;
    }
}
