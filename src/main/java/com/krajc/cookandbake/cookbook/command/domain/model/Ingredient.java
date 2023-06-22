package com.krajc.cookandbake.cookbook.command.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.IngredientJpa;

import java.util.UUID;

public record Ingredient(
        UUID id,
        String name
) {
    public static Ingredient getFromJpa(IngredientJpa ingredientJpa) {
        return new Ingredient(ingredientJpa.getId(), ingredientJpa.getName());
    }

    public IngredientJpa toJpa() {
        return new IngredientJpa(this.name);
    }
}
