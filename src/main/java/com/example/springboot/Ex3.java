package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Ex3 {
    private List<Meal> meals = new ArrayList<>();


    @GetMapping(value = "/get/meal")
    public ResponseEntity<List<Meal>> getMeal(){
        return ResponseEntity.ok(meals);
    }
    @PutMapping(value = "/put/meal")
    public ResponseEntity<String> putMeal (@RequestBody Meal meal){
        this.meals.add(meal);
        return ResponseEntity.ok("Meal added!");
    }

    @PostMapping (value = "/meal/{name}")
    public ResponseEntity<String> postMeal (@PathVariable String name, @RequestBody Meal meal){

        this.meals.removeIf(m -> m.name.equals(name));
        this.meals.add(meal);
        return ResponseEntity.ok("Meal updated!");
    }
}
