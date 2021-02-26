package com.udacity.exercise.lesson2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for receiving requests.
 */
@Controller
@RequestMapping("/food")
public class FoodController {


    private FoodService foodService;


    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String getHomePage(FoodForm foodForm, Model model) {
        foodService.addFood(foodForm.getFoodName(), foodForm.getCalories(), foodForm.getMealTime());
        return "foodAdded";
    }

}
