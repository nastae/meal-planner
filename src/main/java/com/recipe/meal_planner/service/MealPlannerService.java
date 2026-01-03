package com.recipe.meal_planner.service;

import com.recipe.meal_planner.model.MealType;
import com.recipe.meal_planner.model.Recipe;
import com.recipe.meal_planner.model.WeeklyPlan;
import com.recipe.meal_planner.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.recipe.meal_planner.model.MealType.BREAKFAST;
import static com.recipe.meal_planner.model.MealType.DINNER;
import static com.recipe.meal_planner.model.MealType.LATE_NIGHT_SNACK;
import static com.recipe.meal_planner.model.MealType.LUNCH;

@Service
public class MealPlannerService {

    private final RecipeRepository recipeRepository;

    public MealPlannerService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private final List<String> days = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
//    private final List<String> mealTypes = List.of("breakfast", "lunch", "dinner", "snack");
    private final List<MealType> mealTypes = List.of(BREAKFAST, LUNCH, DINNER, LATE_NIGHT_SNACK);

//    TODO: set start day (maybe better select days (TUESDAY, WEDNESDAY))
    public WeeklyPlan generateWeeklyPlan() {
        Map<String, Map<MealType, Recipe>> weeklyPlan = new HashMap<>();
        Map<MealType, Recipe> previousDayRecipes = new HashMap<>();

        for (String day : days) {
            Map<MealType, Recipe> meals = new HashMap<>();
            for (MealType mealType : mealTypes) {
                List<Recipe> recipes = recipeRepository.findByMealType(mealType);

//                FROM https://stackoverflow.com/questions/32101688/illegalargumentexception-bound-must-be-positive
                if (!recipes.isEmpty()) {
                    // Rule: avoid eating the same recipe two days in a row
                    Recipe selected = recipes.get(new Random().nextInt(recipes.size()));
                    if (previousDayRecipes.containsKey(mealType) && previousDayRecipes.get(mealType).equals(selected)) {
//                        recipes.indexOf(selected) → finds the position of the randomly selected recipe in the current list.
//                        + 1 → moves to the next recipe in the list.
//                        % recipes.size() → wraps around to the start if it reaches the end.
//                        If the random recipe was the same as yesterday’s, it picks the next one in the list instead.
                        selected = recipes.get((recipes.indexOf(selected) + 1) % recipes.size());
                    }
//                    TODO: If previous dish is X, then next Y days should be same dish on same eating time

                    meals.put(mealType, selected);
                }
            }
            weeklyPlan.put(day, meals);
            previousDayRecipes = meals;
        }
        return new WeeklyPlan(weeklyPlan);
    }
}
