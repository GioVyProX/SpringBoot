package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Ex3 {

    private List<Meal> meals = new ArrayList<>();


    @PutMapping(value = "/meal")
    public ResponseEntity <String> putMeal (@RequestBody Meal meal){
        this.meals.add(meal);
        return ResponseEntity.ok("Meal added!");
        }


}
