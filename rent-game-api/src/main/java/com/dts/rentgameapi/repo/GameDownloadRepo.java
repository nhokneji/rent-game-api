package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblGameDownloadEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rin-DTS
 */
@Repository
public interface GameDownloadRepo extends CrudRepository<TblGameDownloadEntity,Integer> {
    List<TblGameDownloadEntity> findByGameId(Integer game_id);

    @Query(value = "select * from ezplay.tbl_game_download where game_id = :game_id limit :start,:limit ", nativeQuery = true)
    List<TblGameDownloadEntity> findGamesByCategoryId(
            @Param("game_id") Integer game_id,
            @Param("start") Integer start,
            @Param("limit") Integer limit);
    Long countByGameId(Integer game_id);
}
