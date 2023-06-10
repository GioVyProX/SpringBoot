package com.example.springboot.service;

import com.example.springboot.Meal;
import com.example.springboot.dao.IngredientRepository;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;


    @Autowired IngredientService (IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    public void addIngredientTest(){
//        if (ingredient.getName() == null) throw new IllegalArgumentException ("Ingredient name cannot be null!");

        ingredientRepository.save(new Ingredient("Cheese", true, false, true, false));
    }


}
