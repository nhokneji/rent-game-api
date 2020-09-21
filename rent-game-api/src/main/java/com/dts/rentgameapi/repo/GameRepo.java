package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.dto.mapping.GameFormMapping;
import com.dts.rentgameapi.domain.entity.TblGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public interface GameRepo extends JpaRepository<TblGameEntity, Integer> {

    @Query(value = "select * from ezplay.tbl_game where category_id = :cat_id  ORDER BY tbl_game.updated_at desc limit :start,:limit ", nativeQuery = true)
    List<TblGameEntity> findGamesByCategoryId(
            @Param("cat_id") Integer cat_id,
            @Param("start") Integer start,
            @Param("limit") Integer limit);

    @Query(value = "select * from ezplay.tbl_game where store_id = :store_id  ORDER BY tbl_game.updated_at desc limit :start,:limit ", nativeQuery = true)
    List<TblGameEntity> findGamesByStoreId(
            @Param("store_id") Integer store_id,
            @Param("start") Integer start,
            @Param("limit") Integer limit);


    @Query(value = "select * from ezplay.tbl_game  ORDER BY tbl_game.updated_at desc  limit :start,:limit ", nativeQuery = true)
    List<TblGameEntity> findGamesByPagesDesc(
            @Param("start") Integer start,
            @Param("limit") Integer limit);

    @Query(value = "select * from ezplay.tbl_game  ORDER BY tbl_game.updated_at asc  limit :start,:limit ", nativeQuery = true)
    List<TblGameEntity> findGamesByPagesAsc(
            @Param("start") Integer start,
            @Param("limit") Integer limit);

    Long countByStoreId(Integer store_id);

    Long countByCategoryId(Integer cat_id);

    Long countByProviderId(Integer pro_id);

    Long countByStoreIdAndCategoryId(Integer store_id,Integer cat_id);


    List<TblGameEntity> findAllByCategoryId(Integer cat_id);

    List<TblGameEntity> findAllByProviderId(Integer pro_id);

    @Query(value = "select * from ezplay.tbl_game where provider_id = :provider_id  ORDER BY tbl_game.updated_at desc limit :start,:limit ", nativeQuery = true)
    List<TblGameEntity> findGamesByProviderId(@Param("provider_id") Integer provider_id,
                                              @Param("start") Integer start,
                                              @Param("limit") Integer limit);

    @Query(value = "SELECT * FROM tbl_shop_games a inner join tbl_game b on a.game_id=b.id ORDER BY play_count desc limit :limit", nativeQuery = true)
    List<GameFormMapping> findByTopPlay(@Param("limit") Integer limit);

    @Query(value = "SELECT * FROM tbl_shop_games a inner join tbl_game b on a.game_id=b.id ORDER BY updated_at desc limit :limit;", nativeQuery = true)
    List<GameFormMapping> findByTopNewest(@Param("limit") Integer limit);

}
