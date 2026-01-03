package com.recipe.meal_planner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
//    TODO: update to enum
//    Type safety.
//    With String, you can accidentally write "breakfastt" or "Lunch" (case mismatch).
//    Enum ensures only allowed values exist: BREAKFAST, LUNCH, DINNER, SNACK.
//    Future proof
//    If you later add or remove meal types, you change only the enum, not scattered string values in code.
//    Using enums is still “future-proof” for coding and type safety, but you need a tiny bit of care when removing enum values from production data.
//    How to handle it safely:
//    Option 1: Soft delete → Don’t delete enum values, mark them as deprecated in code.
//    Option 2: Data migration → Update DB rows before removing the enum value.
//    Option 3: Keep enum values for historical data → Even if you stop using them in logic, don’t delete from enum immediately.
    @Enumerated(EnumType.STRING)
    private MealType mealType; // enum instead of String
//    private String mealType; // breakfast, lunch, dinner, snack
//    TOOD: receptas gali tureti produktus
//    TODO: receptas gali tureti laiko paruosimo laika
}
