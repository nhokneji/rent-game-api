package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblUserGameInfoEntity;
import com.dts.rentgameapi.domain.entity.TblUserGameInfoEntityPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Rin-DTS
 */
public interface UserGameInfoRepo extends CrudRepository<TblUserGameInfoEntity, TblUserGameInfoEntityPK> {

    List<TblUserGameInfoEntity> findByUserId(Integer id);
}
