package com.krajc.cookandbake.cookbook.command.domain.service;

import com.krajc.cookandbake.cookbook.command.domain.model.Recipe;
import com.krajc.cookandbake.cookbook.command.ports.RecipeCommandPort;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RecipeService {
    RecipeCommandPort recipeCommandPort;

    public RecipeService(RecipeCommandPort recipeCommandPort) {
        this.recipeCommandPort = recipeCommandPort;
    }

    public Recipe save(Recipe recipe) {
        return recipeCommandPort.save(recipe);
    }

    public void deleteById(String id) {
        recipeCommandPort.deleteById(UUID.fromString(id));
    }
}
