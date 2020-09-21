package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.Affiliate;
import com.dts.rentgameapi.domain.entity.TblAffiliateEntity;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class AffiliateBeanUtil implements IDataConvert<Affiliate, TblAffiliateEntity> {

    @Override
    public Affiliate entity2Dto(TblAffiliateEntity entity) {
        Affiliate dto = new Affiliate();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setBalance(entity.getBalance());
        return dto;
    }

    @Override
    public TblAffiliateEntity dto2Entity(Affiliate dto) {
        TblAffiliateEntity entity = new TblAffiliateEntity();
        entity.setId(dto.getId());
        // entity.setAffiliate_user(dto.getUserEntity());
        entity.setBalance(dto.getBalance());
        return entity;
    }
}
