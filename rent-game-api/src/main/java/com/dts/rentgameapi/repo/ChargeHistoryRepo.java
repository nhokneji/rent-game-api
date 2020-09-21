package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblChargeHistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public interface ChargeHistoryRepo extends CrudRepository<TblChargeHistoryEntity,Integer> {


    @Query(value = "select * from ezplay.tbl_charge_history where user_id = :user_id and part between :from and :to", nativeQuery = true)
    List<TblChargeHistoryEntity> findByUserIdPartBetween(@Param("user_id") Integer user_id,
                                                         @Param("from") Integer from,
                                                         @Param("to") Integer to);


    @Query(value = "select * from ezplay.tbl_charge_history where user_id = :user_id limit :start,:limit ", nativeQuery = true)
    List<TblChargeHistoryEntity> findByUSerIDAndPages( @Param("user_id") Integer user_id,
                                                       @Param("start") Integer start,
                                                       @Param("limit") Integer limit);


    Long countByUserId(Integer user_id);
}
