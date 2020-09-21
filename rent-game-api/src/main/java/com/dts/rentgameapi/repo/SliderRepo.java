package com.dts.rentgameapi.repo;

import com.dts.rentgameapi.domain.entity.TblSliderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rin-DTS
 */
@Repository
public interface SliderRepo extends JpaRepository<TblSliderEntity,Integer> {
}
