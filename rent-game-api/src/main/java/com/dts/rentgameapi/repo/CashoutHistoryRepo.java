package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblCashoutHistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public interface CashoutHistoryRepo extends CrudRepository<TblCashoutHistoryEntity, Integer> {

    @Query(value = "select * from ezplay.tbl_cashout_history where shop_id = :store_id limit :start,:limit ", nativeQuery = true)
    List<TblCashoutHistoryEntity> findByShopIdPages(@Param("store_id") Integer store_id,
                                                    @Param("start") Integer start,
                                                    @Param("limit") Integer limit);

    Long countByShopId(Integer shop_id);
}
