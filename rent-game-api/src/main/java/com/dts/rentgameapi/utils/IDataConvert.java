package com.dts.rentgameapi.utils;

/**
 * @author Rin-DTS
 */
public interface IDataConvert<DTO, ENTITY> {
     DTO entity2Dto(ENTITY entity);
     ENTITY dto2Entity(DTO dto);
}
