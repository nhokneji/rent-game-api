package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblShopEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Rin-DTS
 */
@Repository
public interface ShopRepo extends CrudRepository<TblShopEntity, Integer> {
    @Query(value = "SELECT * from tbl_shop where user_id =:user_id limit 1", nativeQuery = true)
    TblShopEntity findByUserId(@Param("user_id") Integer user_id);

    boolean existsByAlias(String alias);

    boolean existsByShopName(String shop_name);
}

