package com.example.springboot.controller;

import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.model.Meal;
import com.example.springboot.service.MealService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.assembler.MethodExclusionMBeanInfoAssembler;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

@RestController
@RequestMapping("api/meal")
public class MealController {

    private MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;

    }


    @GetMapping("/getMeals")
    public ResponseEntity<String> getMeals() {
        try {
            return ResponseEntity.ok(mealService.getMeals().toString());

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping(value = "/put")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/")
    public ResponseEntity<String> deleteMeal(@RequestParam Long ID) {

        mealService.deleteMeal(ID);
        return ResponseEntity.ok("Meal deleted!");

    }

    @GetMapping(value = "/test")

    public ResponseEntity<?> test() {

        return ResponseEntity.ok(mealService.test());
    }

    @GetMapping(value = "summer-meals")
    public ResponseEntity<List<Meal>> getSummerMeals() {

        return ResponseEntity.ok(mealService.getSummerMeals());
    }
}
