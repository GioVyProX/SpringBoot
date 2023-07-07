package com.example.springboot.service;

import com.example.springboot.dao.MealRepository;
import com.example.springboot.model.Meal;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    private MealRepository mealRepository;
    private Double MIN_SUMMER_TEMP = 20.0;
    private Double MAX_WINTER_TEMP = 40.0;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void addMeal(Meal meal) {
        if (meal.getName() == null) throw new IllegalArgumentException("Meal name cannot be null!");
        if (meal.getPrice() <= 0) throw new IllegalArgumentException("Price must be greater than 0");

        mealRepository.save(meal);
    }

    public void deleteMeal(Long ID) {
        mealRepository.deleteById(ID);
    }

    public void updateMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }


    public List<Meal> test() {

        return mealRepository.findByName("Veggie Burger");

//        return mealRepository.findByPriceGreaterThanAndName(9.99, "Hamburger");
//
//        System.out.println(mealRepository.findByDescription("Descrizione Piatto"));
//        System.out.println(mealRepository.findByDescriptionAndPriceLowerThan("Descrizione Piatto", 9.99));
//        System.out.println(mealRepository.findByPriceGreaterThan(19.99));
//        System.out.println(mealRepository.findByPriceLowerThanAndGreaterThan(25.99, 9.99));

    }
    private Double currentTemperatureInCentigrade = getTemperatureInDegrees();


    public List<Meal> getWinterMeals (){

        if (currentTemperatureInCentigrade > MAX_WINTER_TEMP) return new ArrayList<>();


            return mealRepository.findByIsWinterMeal(true);

    }



    public List<Meal> getSummerMeals() {



        if (currentTemperatureInCentigrade < MIN_SUMMER_TEMP) return new ArrayList<>();


        return mealRepository.findByIsSummerMeal(true);
    }



    private Double getTemperatureInDegrees () {
        try {
            JSONObject response =
                    Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=40.8522&longitude=14.2681&current_weather=true")
                            .asJson().getBody().getObject();

            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }

    }
}
