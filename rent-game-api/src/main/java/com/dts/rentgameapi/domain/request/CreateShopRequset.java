package com.dts.rentgameapi.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rin-DTS
 */
@Getter
@Setter
public class CreateShopRequset {
    private String shop_name;
    private String phone;
    private String alias;
    private String description;
    private String slogan;
    private Double balance;
    private String facebook_link;
    private String link_shop;
    private String logo;

    public boolean validate() {
        if (shop_name == null || phone == null || alias == null
                || description == null ||
                slogan == null ||
                balance == null ||
                facebook_link == null ||
                link_shop == null ||
                logo == null
        )
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CreateShopRequset{" +
                "shop_name='" + shop_name + '\'' +
                ", phone='" + phone + '\'' +
                ", alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", slogan='" + slogan + '\'' +
                ", balance=" + balance +
                ", facebook_link='" + facebook_link + '\'' +
                ", link_shop='" + link_shop + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
