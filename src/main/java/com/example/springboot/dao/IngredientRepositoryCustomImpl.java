package com.example.springboot.dao;

import com.example.springboot.dao.IngredientRepository;
import com.example.springboot.dao.IngredientRepositoryCustom;
import com.example.springboot.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class IngredientRepositoryCustomImpl implements IngredientRepositoryCustom {

    private IngredientRepository ingredientRepository;
    @Autowired
    public IngredientRepositoryCustomImpl(@Lazy IngredientRepository ingredientRepository) {this.ingredientRepository = ingredientRepository;}

    @Override
    public void updateIngredient(Ingredient ingredient, Long id) {
        Ingredient ingredientRepo = ingredientRepository.findById(id).orElseThrow(NoSuchFieldError::new);

        ingredientRepo.setName(ingredient.getName());
        ingredientRepo.setIsLactoseFree(ingredient.isLactoseFree());
        ingredientRepo.setIsVegan(ingredient.isVegan());
        ingredientRepo.setIsGlutenFree(ingredient.isGlutenFree());
        ingredientRepo.setIsVegetarian(ingredient.isVegetarian());

        ingredientRepository.save(ingredientRepo);

    }
}
