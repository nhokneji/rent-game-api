package com.dts.rentgameapi.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Rin-DTS
 */
@Entity
@Table(name = "tbl_shop", schema = "ezplay", catalog = "")
public class TblShopEntity {
    private int id;
    private String shopName;
    private String alias;
    private Timestamp createdTime;
    private double balance;
    private String facebookLink;
    private String iconPath;
    private Integer userId;
    private String linkShop;
    private String slogan;
    private String description;
    private String phone;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "facebook_link")
    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    @Basic
    @Column(name = "icon_path")
    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "link_shop")
    public String getLinkShop() {
        return linkShop;
    }

    public void setLinkShop(String linkShop) {
        this.linkShop = linkShop;
    }

    @Basic
    @Column(name = "slogan")
    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblShopEntity that = (TblShopEntity) o;
        return id == that.id &&
                Double.compare(that.balance, balance) == 0 &&
                Objects.equals(shopName, that.shopName) &&
                Objects.equals(alias, that.alias) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(facebookLink, that.facebookLink) &&
                Objects.equals(iconPath, that.iconPath) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(linkShop, that.linkShop) &&
                Objects.equals(slogan, that.slogan) &&
                Objects.equals(description, that.description) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shopName, alias, createdTime, balance, facebookLink, iconPath, userId, linkShop, slogan, description, phone);
    }
}
