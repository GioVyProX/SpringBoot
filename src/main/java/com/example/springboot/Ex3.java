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


    @PostMapping(value = "/meal")
    public ResponseEntity <String> addMeal(@RequestBody Meal meal) {
        this.meals.add(meal);
        return ResponseEntity.ok("Meal added!");
    }

    @PutMapping (value = "/meal/{name}")
    public ResponseEntity<String> updateMeal(@PathVariable String name, @RequestBody Meal meal){
        this.meals.removeIf(m -> m.name.equals(name));
        this.meals.add(meal);
        return ResponseEntity.ok("Meal updated!");
    }

    @DeleteMapping (value = "/meal/price/{price}")
    public ResponseEntity<String> deleteMeal (@PathVariable double price){
        this.meals.removeIf(meal -> meal.price > price);
        return ResponseEntity.ok("Deleted!");
    }

    @PutMapping (value = "/meal/{name}/price")
    public ResponseEntity <String> updatePriceMeal(@PathVariable String name, @RequestBody double price){

        for (Meal meal: meals) {
            if (meal.name.equals(name)){
                meal.setPrice(price);
            }
        }
        return ResponseEntity.ok("Meal updated");
    }


}
