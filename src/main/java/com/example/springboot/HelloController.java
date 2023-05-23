package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

private List<Meal> meals = Arrays.asList(
		new Meal("A Meal made by the chef", "19.99","Chef's Special"),
		new Meal("Chicken burger bacon", "9.99","Chicken burger"),
		new Meal("Hamburgher with bacon and fries", "10.99","Hamburgher")


);

	@GetMapping("/")
	public String index() {
		return "Ciao caro fai 10 diesel";
	}

	@GetMapping("/chefs-special/{dayOfTheWeekIndex}")
	public ResponseEntity <Meal> chefsSpecial(@PathVariable("dayOfTheWeekIndex") int dayOfTheWeekIndex){

		return ResponseEntity.ok(meals.get(dayOfTheWeekIndex));
	}


}
