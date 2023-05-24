package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class Ex2 {

//    private List<Meal> meals = Arrays.asList(
//            new Meal("A Meal made by the chef", 19.99, "Chef's Special"),
//            new Meal("Chicken burger bacon", 9.99, "Chicken burger"),
//            new Meal("Hamburgher with bacon and fries", 10.99, "Hamburgher"));
//
//    @GetMapping("/meals")
//    public List<Meal> index() {
//        return meals;
//    }
//
//
//    @GetMapping("/meals/name")
//    public Meal mealByName(@RequestParam("name") String name) {
//
//        for (Meal meal : meals) {
//            if (Objects.equals(meal.name, name)) {
//                return meal;
//            }
//        }
//        return null;
//    }
//
//
//    @GetMapping ("/meal")
//    public ResponseEntity<?> getByDescription (
//            @RequestParam ("description") String description){
//
//        for (Meal meal: meals) {
//            if (meal.description.contains(description)){
//                return ResponseEntity.ok(meal);
//            }
//        }
//
//        return null;
//    }
//
//
//
//    @GetMapping ("/meal/price")
//    public ResponseEntity<?> getByPrice (
//            @RequestParam ("max_price") double max_price,
//            @RequestParam ("min_price") double min_price) {
//
//        for (Meal meal: meals) {
//        if (meal.price <= max_price && meal.price >= min_price) {
//            return ResponseEntity.ok(meal);
//        }
//
//        }
//    return null;
//    }
}
