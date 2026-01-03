-- V1__create_recipe_table.sql
CREATE TABLE recipe (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    meal_type VARCHAR(50)
)