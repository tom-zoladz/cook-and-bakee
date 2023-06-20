package com.krajc.cookandbake.cookbook.query.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.IngredientJpa;

import java.util.UUID;

public record IngredientView(
        UUID authorId,
        String name
) {
    public static IngredientView getFromJpa(IngredientJpa ingredientJpa){
        return new IngredientView(ingredientJpa.getId(), ingredientJpa.getName());
    }
}
