package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblProviderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rin-DTS
 */
@Repository
public interface ProviderRepo extends CrudRepository<TblProviderEntity, Integer> {
}
