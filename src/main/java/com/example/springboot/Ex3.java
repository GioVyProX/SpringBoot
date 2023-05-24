package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Ex3 {
    private List<Meal> meals = new ArrayList<>();


    @GetMapping(value = "/get/meal")
    public ResponseEntity<List<Meal>> getMeal(){
        return ResponseEntity.ok(meals);
    }
    @PutMapping(value = "/put/meal/ex3")
    public ResponseEntity <String> putMeal(@RequestBody Meal meal) {
        this.meals.add(meal);
        return ResponseEntity.ok("Meal added!");
    }

    @PostMapping (value = "/meal/{name}")
    public ResponseEntity<String> postMeal(@PathVariable String name, @RequestBody Meal meal){

        this.meals.removeIf(m -> m.name.equals(name));
        this.meals.add(meal);
        return ResponseEntity.ok("Meal updated!");
    }

    @DeleteMapping (value = "/meal/price/{price}")
    public ResponseEntity<String> deleteMeal (@PathVariable double price){
        this.meals.removeIf(meal -> meal.price > price);
        return ResponseEntity.ok("Updated!");
    }

    @PutMapping (value = "/meal/{name}/price")
    public ResponseEntity <String> updateMeal (@PathVariable String name, @RequestBody Meal mealPrice){

        for (Meal meal: meals) {
            if (meal.name.equals(name)){
                meal.setPrice(mealPrice.getPrice());
            }
        }
        return ResponseEntity.ok("Meal updated");
    }


}
