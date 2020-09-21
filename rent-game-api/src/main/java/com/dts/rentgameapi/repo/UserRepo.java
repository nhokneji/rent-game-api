package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rin-DTS
 */
@Repository
public interface UserRepo extends CrudRepository<TblUserEntity, Integer> {
    TblUserEntity findByUsername(String username);
    Boolean existsByUsername(String username);
}
