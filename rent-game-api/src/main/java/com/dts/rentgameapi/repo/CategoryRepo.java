package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rin-DTS
 */
@Repository
public interface CategoryRepo extends CrudRepository<TblCategoryEntity, Integer> {
}
