package com.example.springboot.controller;

import com.example.springboot.model.Ingredient;
import com.example.springboot.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping ("ingredient/")
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping (value = "insert")
    public ResponseEntity<?> insertIngredient (@RequestBody Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping (value = "delete/{id}")
    public ResponseEntity<?> deleteIngredient (@PathVariable Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "get/{id}")
    public ResponseEntity<?> getIngredientById (@PathVariable Long id){
      return ResponseEntity.ok(ingredientService.getIngredientById(id));
    }

    @PutMapping (value = "update/{id}")
    public ResponseEntity<?> updateIngredient (@RequestBody Ingredient ingredient, @PathVariable Long id){

        ingredientService.updateIngredient(ingredient, id);
        return ResponseEntity.ok().build();
    }


    @GetMapping (value = "getAll")

    public ResponseEntity<?> getAllFromDB ()
    {
        try {

            return ResponseEntity.ok().body(ingredientService.getAllFromDB());
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body("Fratm hai sbagliato qualcosa");
        }
    }



}
