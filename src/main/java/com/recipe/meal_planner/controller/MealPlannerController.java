package com.recipe.meal_planner.controller;

import com.recipe.meal_planner.model.WeeklyPlan;
import com.recipe.meal_planner.service.MealPlannerService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlannerController {

    private final MealPlannerService mealPlannerService;

    public MealPlannerController(MealPlannerService mealPlannerService) {
        this.mealPlannerService = mealPlannerService;
    }

    @GetMapping("/weekly-plan")
    public WeeklyPlan getWeeklyPlan() {
        return mealPlannerService.generateWeeklyPlan();
    }
}
