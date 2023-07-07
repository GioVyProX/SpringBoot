package com.example.springboot.dao;

import com.example.springboot.model.Ingredient;
import com.example.springboot.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository <Meal, Long>{

//    List<Meal> findByName (String name);
//
//    List<Meal> findByDescription (String description);
//    List<Meal> findByPriceGreaterThan (double price);
//    List<Meal> findByPriceLowerThanAndGreaterThan (double lowerPrice, double higherPrice);
//
//    List <Meal> findByDescriptionAndPriceLowerThan (String description, double price);

    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThanAndName(double price, String name);
    List<Meal> findByIsSummerMeal(Boolean isSummerMeal);

    List<Meal> findByIsWinterMeal(Boolean isWinterMeal);


}
