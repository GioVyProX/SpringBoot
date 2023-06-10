package com.example.springboot.controller;

import com.example.springboot.Meal;
import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meal/")
public class MealController {

    private MealService mealService;
    private RestaurantConfig restaurantConfig;
    @Autowired
    public MealController(MealService mealService, RestaurantConfig restaurantConfig) {
        this.mealService = mealService;
        this.restaurantConfig = restaurantConfig;
    }


    @GetMapping ("restaurant-config")
    public ResponseEntity<RestaurantConfig> getRestaurantConfig(){
        return ResponseEntity.ok(restaurantConfig);
    }

    @GetMapping("get")
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok(mealService.getMeals());
    }

    @PutMapping(value = "put")
    public ResponseEntity <String> putMeal(@RequestBody Meal meal) {
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "delete/{mealName}")
    public ResponseEntity <String> deleteMeal(@PathVariable String mealName){

        mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted!");

    }


}
