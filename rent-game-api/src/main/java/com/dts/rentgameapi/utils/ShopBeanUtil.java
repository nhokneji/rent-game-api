package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.Shop;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class ShopBeanUtil implements IDataConvert<Shop, TblShopEntity> {
//    @Autowired
//    private UserDaoImpl userDaoImpl;

    @Autowired
    private CashOutHistoryBeanUtil cashOutHistoryBeanUtil;

    @Override
    public Shop entity2Dto(TblShopEntity entity) {
        Shop dto = new Shop();
        dto.setShopName(entity.getShopName());
        dto.setAlias(entity.getAlias());
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setBalance(entity.getBalance());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setIconPath(entity.getIconPath());
        dto.setFacebookLink(entity.getFacebookLink());
        dto.setDescription(entity.getDescription());
        dto.setLinkShop(entity.getLinkShop());
        dto.setSlogan(entity.getSlogan());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    @Override
    public TblShopEntity dto2Entity(Shop dto) {
        TblShopEntity entity = new TblShopEntity();
        if (dto.getShopName() != null)
            entity.setShopName(dto.getShopName());
        entity.setAlias(dto.getAlias());
        entity.setUserId(dto.getUserId());
        entity.setBalance(dto.getBalance());
        entity.setCreatedTime(dto.getCreatedTime());
        entity.setIconPath(dto.getIconPath());
        entity.setFacebookLink(dto.getFacebookLink());
        entity.setDescription(dto.getDescription());
        entity.setLinkShop(dto.getLinkShop());
        entity.setSlogan(dto.getSlogan());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
