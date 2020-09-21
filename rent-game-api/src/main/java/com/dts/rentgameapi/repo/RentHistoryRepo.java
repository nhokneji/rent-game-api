package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblGameAccountEntity;
import com.dts.rentgameapi.domain.entity.TblRentHistoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public interface RentHistoryRepo extends CrudRepository<TblRentHistoryEntity, Integer> {
    @Query(value = "select * from ezplay.tbl_rent_history where shop_id = :shop_id limit :start,:limit ", nativeQuery = true)
    List<TblRentHistoryEntity> findByShopIdPages(@Param("shop_id") Integer shop_id,
                                                 @Param("start") Integer start,
                                                 @Param("limit") Integer limit);

    Long countByShopId(Integer shop_id);

    @Query(value = "select * from ezplay.tbl_rent_history where user_id = :user_id and status =0 limit 1 ", nativeQuery = true)
    TblRentHistoryEntity findByUserId(@Param("user_id") Integer user_id);

    List<TblRentHistoryEntity> findByPartBetween(Integer from, Integer to);

    @Query(value = "select * from ezplay.tbl_rent_history where shop_id = :shop_id and part between :from and :to", nativeQuery = true)
    List<TblRentHistoryEntity> findByShopIdPartBetween(@Param("shop_id") Integer shop_id,
                                                       @Param("from") Integer from,
                                                       @Param("to") Integer to);

    @Query(value = "select * from ezplay.tbl_rent_history where user_id = :user_id limit :start,:limit ", nativeQuery = true)
    List<TblRentHistoryEntity> findByUserId(@Param("user_id") Integer user_id,
                                            @Param("start") Integer start,
                                            @Param("limit") Integer limit);

    @Query()
    Long countByUserId(Integer user_id);

    @Query(value = "select * from ezplay.tbl_rent_history where user_id = :user_id and status = 0 limit 1", nativeQuery = true)
    TblRentHistoryEntity findByUserAndId(
            @Param("user_id") Integer user_id);

    //    Integer user_id, Integer account_id);
}
