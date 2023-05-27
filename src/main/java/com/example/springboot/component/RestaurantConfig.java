package com.example.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class RestaurantConfig {

    private double minPrice = 2.0;
    private double maxPrice = 10.3;
    private double totalDiscount = 1.5;

    public RestaurantConfig() {

    }

    public double getMaxPrice() {return maxPrice;}

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
