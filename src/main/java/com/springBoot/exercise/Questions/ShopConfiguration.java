package com.springBoot.exercise.Questions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShopConfiguration {
    @Value("${shop.name}")
    private String shopName;

    @Value("${shop.city}")
    private String shopCity;

    @Value("${shop.owner}")
    private String shopOwner;

    public String getShopName() {
        return shopName;
    }

    public String getShopCity() {
        return shopCity;
    }

    public String getShopOwner() {
        return shopOwner;
    }
}
