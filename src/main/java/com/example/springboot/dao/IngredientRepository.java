package com.example.springboot.dao;

import com.example.springboot.Meal;
import com.example.springboot.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository <Ingredient, Long>{
}
