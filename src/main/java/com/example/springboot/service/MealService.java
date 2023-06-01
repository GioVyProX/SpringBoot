package com.example.springboot.service;

import com.example.springboot.Meal;
import com.example.springboot.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    private MealDao mealDao;

    @Autowired
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal){
        if (meal.getName() == null) throw new IllegalArgumentException ("Meal name cannot be null!");
        if (meal.getPrice() <= 0) throw new IllegalArgumentException("Price must be greater than 0");

        mealDao.addMeal(meal);
    }
    public void deleteMeal (String mealName){
        mealDao.deleteMeal(mealName);
    }

    public void updateMeal (Meal meal){
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeals () {
        return mealDao.getMeals();
    }

}
