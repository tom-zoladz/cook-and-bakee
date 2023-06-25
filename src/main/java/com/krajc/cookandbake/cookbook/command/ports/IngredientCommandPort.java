package com.krajc.cookandbake.cookbook.command.ports;

import com.krajc.cookandbake.cookbook.command.domain.model.Ingredient;

public interface IngredientCommandPort {
    Ingredient save(Ingredient ingredient);
}
