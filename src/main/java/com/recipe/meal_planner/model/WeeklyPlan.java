package com.recipe.meal_planner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyPlan {

    // Map day -> mealType -> Recipe
    private Map<String, Map<MealType, Recipe>> plan;
}
