package com.recipe.meal_planner;

import com.recipe.meal_planner.model.MealType;
import com.recipe.meal_planner.model.Recipe;
import com.recipe.meal_planner.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class MealPlannerApplication {

//	TODO: ziureti i https://chatgpt.com/c/69540b08-985c-8329-bcec-1ddc9568a82a ir daryti MealPlanner, service logika
//	TODO: prompt: I want to create recipes for week, like I can say that I know that recipes and randomly or by rules make my week recipes for breakfast, lunch, dinner and late night snacks. It can be rule that two days in a row I eat only cottage cheese. What dependencies of spring.io for my project I need first, how code look like, write it.
	public static void main(String[] args) {
		SpringApplication.run(MealPlannerApplication.class, args);
	}

//	@Bean
//	@Profile("dev")
//	public CommandLineRunner loadDevData(RecipeRepository repo) {
//		return args -> {
//			System.out.println("Test dev");
//			repo.save(new Recipe(0L, "Omelette", MealType.BREAKFAST));
//			repo.save(new Recipe(1L, "Pancakes", MealType.BREAKFAST));
//		};
//	}
//
//	@Bean
//	@Profile("prod")
//	public CommandLineRunner loadProdData(RecipeRepository repo) {
//		return args -> {
//			System.out.println("Test prod");
//			// maybe load initial production recipes from file or skip
//		};
//	}
}
