package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

private List<Meal> meals = new ArrayList<>();


	@GetMapping("/get/meals")
	public ResponseEntity<List<Meal>> getMeals() {
		return ResponseEntity.ok(meals);
	}

	@PutMapping(value = "/put/meal")
	public ResponseEntity <String> putMeal(@RequestBody Meal meal) {
		this.meals.add(meal);
		return ResponseEntity.ok("Meal added!");
	}

	@DeleteMapping (value = "/delete/meal/{mealName}")
	public ResponseEntity <String> deleteMeal(@PathVariable String mealName){

		this.meals.removeIf(meal -> meal.getName().equals(mealName));
		return ResponseEntity.ok("Meal deleted!");

	}

	@PostMapping (value = "/post/replace-meal")
	public ResponseEntity<String> postMeal (@RequestBody Meal meal){
		this.meals.removeIf(m -> m.getName().equals(meal.getName()));
		this.meals.add(meal);
		return ResponseEntity.ok("Meal updated");
	}


}
