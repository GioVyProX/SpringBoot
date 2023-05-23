package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class Ex2 {

    private List<Meal> meals = Arrays.asList(
            new Meal("A Meal made by the chef", "19.99","Chef's Special"),
            new Meal("Chicken burger bacon", "9.99","Chicken burger"),
            new Meal("Hamburgher with bacon and fries", "10.99","Hamburgher"));

@GetMapping("/meals")
    public List<Meal> index (){
        return meals;
    }


    @GetMapping("/meals/{name}")
    public Meal mealByName (@PathVariable ("name") String name){

        for (Meal meal : meals) {
            if (Objects.equals(meal.name, name)) {

                return meal;

            }
            return null;
        }


        return null;
    }

}