package com.example.springboot.dao;

import com.example.springboot.model.Ingredient;

public interface IngredientRepositoryCustom {
     void updateIngredient(Ingredient ingredient, Long id);

}
