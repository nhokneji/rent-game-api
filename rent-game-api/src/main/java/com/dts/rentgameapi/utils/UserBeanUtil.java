package com.dts.rentgameapi.utils;

import com.dts.rentgameapi.domain.dto.ver1.User;
import com.dts.rentgameapi.domain.entity.TblShopEntity;
import com.dts.rentgameapi.domain.entity.TblUserEntity;
import com.dts.rentgameapi.repo.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Rin-DTS
 */
@Component
public class UserBeanUtil implements IDataConvert<User, TblUserEntity> {
    @Autowired
    private ShopBeanUtil shopBeanUtil;
    @Autowired
    private ShopRepo shopRepo;

    @Override
    public User entity2Dto(TblUserEntity entity) {
        User dto = new User();
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setMoblie(entity.getMoblie());
        dto.setLevel(entity.getLevel());
        dto.setVip(entity.getVip());
        dto.setBalance(entity.getBalance());
        dto.setTotalAmount(entity.getTotalAmount());
        dto.setStatus(entity.getStatus());
        dto.setRefrenceId(entity.getRefrenceId());
        dto.setCreateTime(entity.getCreateTime());
        dto.setLastLoginTime(entity.getLastLoginTime());
        dto.setLastUpdateTime(entity.getLastUpdateTime());
        dto.setPlayCount(entity.getPlayCount());
        dto.setToken(entity.getToken());
        dto.setAvatar(entity.getAvatar());
        dto.setDisplay_name(entity.getDisplayName());
        TblShopEntity shopEntity = shopRepo.findByUserId(entity.getUserId());
        if (shopEntity != null) {
            dto.setShopId(shopEntity.getId());
            dto.setShopName(shopEntity.getShopName());
        } else {
            dto.setShopId(-1);
            dto.setShopName("");
        }

        return dto;
    }

    @Override
    public TblUserEntity dto2Entity(User dto) {
        TblUserEntity entity = new TblUserEntity();
        if (dto.getUserName() != null)
            entity.setUsername(dto.getUserName());

        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setMoblie(dto.getMoblie());
        entity.setLevel(dto.getLevel());
        entity.setVip(dto.getVip());
        entity.setBalance(dto.getBalance());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setStatus(dto.getStatus());
        entity.setRefrenceId(dto.getRefrenceId());
        entity.setCreateTime(dto.getCreateTime());
        entity.setLastLoginTime(dto.getLastLoginTime());
        entity.setLastUpdateTime(dto.getLastUpdateTime());
        entity.setPlayCount(dto.getPlayCount());
        entity.setToken(dto.getToken());
        entity.setAvatar(dto.getAvatar());
        entity.setDisplayName(dto.getDisplay_name());
        //entity.setRoleEntity(RoleBeanUtil.dto2Entity(dto.getRoleDTO()));
        return entity;
    }
}
