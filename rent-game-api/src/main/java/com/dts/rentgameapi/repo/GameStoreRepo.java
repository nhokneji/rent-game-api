package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblGameStoreEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rin-DTS
 */
@Repository
public interface GameStoreRepo extends CrudRepository<TblGameStoreEntity,Integer> {
}
