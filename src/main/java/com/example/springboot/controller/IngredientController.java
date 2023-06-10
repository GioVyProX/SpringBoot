package com.example.springboot.controller;

import com.example.springboot.service.IngredientService;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    private IngredientService ingredientService;


    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping (value = "/insertTest")
    public ResponseEntity<?> insertTest (){
        ingredientService.addIngredientTest();
        return ResponseEntity.ok().build();
    }



}
