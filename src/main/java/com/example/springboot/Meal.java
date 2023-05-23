package com.example.springboot;

public class Meal {

    public String description;
    public String price;
    public String name;

    public Meal(String description, String price, String name) {
        this.description = description;
        this.price = price;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
