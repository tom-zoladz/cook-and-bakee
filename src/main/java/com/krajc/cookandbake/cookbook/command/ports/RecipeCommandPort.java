package com.krajc.cookandbake.cookbook.command.ports;

import com.krajc.cookandbake.cookbook.command.domain.model.Recipe;

public interface RecipeCommandPort {
    Recipe save(Recipe recipe);
}
