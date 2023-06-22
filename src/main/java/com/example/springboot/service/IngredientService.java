package com.example.springboot.service;

import com.example.springboot.dao.IngredientRepository;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    @Autowired
    public IngredientService (IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }


    public void deleteIngredient (Long id){
        ingredientRepository.deleteById(id);
    }

    public void addIngredient(Ingredient ingredient){
        if (ingredient.getName() == null) throw new IllegalArgumentException ("Ingredient name cannot be null!");

        ingredientRepository.save(ingredient);
    }


    public Ingredient getIngredientById (Long id){
        return ingredientRepository.getReferenceById(id);
    }

    public void updateIngredient (Ingredient ingredient, Long id){
        ingredientRepository.updateIngredient(ingredient, id);
    }

    public List <Ingredient> getAllFromDB(){

        List<Ingredient> ingredientsFromDB = ingredientRepository.findAll();
        if (ingredientsFromDB.isEmpty()) throw new NoSuchElementException("There is nothing to see :3");
        return ingredientsFromDB;
    }


}
