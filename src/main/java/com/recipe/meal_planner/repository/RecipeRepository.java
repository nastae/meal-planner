package com.recipe.meal_planner.repository;

import com.recipe.meal_planner.model.MealType;
import com.recipe.meal_planner.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByMealType(MealType mealType);
}
