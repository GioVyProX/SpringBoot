package com.example.springboot.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;
    private String name;

    private double price;

    private String description;

    private Boolean isSummerMeal;

    private Boolean isWinterMeal;

    public Meal(Long id, String name, double price, String description, Boolean isSummerMeal, Boolean isWinterMeal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isSummerMeal = isSummerMeal;
        this.isWinterMeal = isWinterMeal;
    }

    public Meal () {
    }

    public Boolean getSummerMeal() {
        return isSummerMeal;
    }

    public Boolean getWinterMeal() {
        return isWinterMeal;
    }

    public void setWinterMeal(Boolean winterMeal) {
        isWinterMeal = winterMeal;
    }

    public void setSummerMeal(Boolean summerMeal) {
        isSummerMeal = summerMeal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Meal { " +
                "\nid = " + id +
                ", \ningredients = " + ingredients +
                ", \nname = '" + name + '\'' +
                ", \nprice = " + price +
                '}'+ "\n\n";
    }
}
