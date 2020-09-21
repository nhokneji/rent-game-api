package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblGameAccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public interface GameAccountRepo extends CrudRepository<TblGameAccountEntity, Integer> {
    List<TblGameAccountEntity> findAllByShopId(Integer shop_id);

    List<TblGameAccountEntity> findAllByGameId(Integer game_id);

    @Query(value = "select * from ezplay.tbl_game_account where shop_id = :shop_id limit :start,:limit ", nativeQuery = true)
    List<TblGameAccountEntity> findByShopIdAndPages(@Param("shop_id") Integer shop_id,
                                                    @Param("start") Integer start,
                                                    @Param("limit") Integer limit);
    Long countByShopId(Integer shop_id);

    Long countByGameId(Integer game_id);

    Long countByGameIdAndShopId(Integer game_id, Integer shop_id);

    @Query(value = "select * from ezplay.tbl_game_account where game_id = :game_id limit :start,:limit ", nativeQuery = true)
    List<TblGameAccountEntity> findByGameIdAndPages(@Param("game_id") Integer game_id,
                                                    @Param("start") Integer start,
                                                    @Param("limit") Integer limit);


    @Query(value = "select * from ezplay.tbl_game_account where game_id = :game_id and shop_id = :shop_id limit :start,:limit ", nativeQuery = true)
    List<TblGameAccountEntity> findByGameIdAndShopIdPages(@Param("game_id") Integer game_id,
                                                          @Param("shop_id") Integer shop_id,
                                                          @Param("start") Integer start,
                                                          @Param("limit") Integer limit);


    @Query(value = "select * from ezplay.tbl_game_account where game_id = :game_id and status =0 limit 1", nativeQuery = true)
    TblGameAccountEntity findGameAccountAvaiable(@Param("game_id") Integer game_id);

    @Query(value = "SELECT min(price) FROM ezplay.tbl_game_account where game_id = :game_id", nativeQuery = true)
    Double findMinPrice(@Param("game_id") Integer game_id);

}
