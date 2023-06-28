package com.krajc.cookandbake.cookbook.command.ports;

import com.krajc.cookandbake.cookbook.command.domain.model.Recipe;

import java.util.UUID;

public interface RecipeCommandPort {
    Recipe save(Recipe recipe);
    void deleteById(UUID id);
}
