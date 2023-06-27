package com.krajc.cookandbake.cookbook.command.ui;

import com.krajc.cookandbake.cookbook.command.domain.model.Recipe;
import com.krajc.cookandbake.cookbook.command.domain.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/recipes")
public class RecipeEndpoint {

    RecipeService service;

    public RecipeEndpoint(RecipeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Recipe> postRecipe(@RequestBody Recipe recipe) {
        Recipe responseBody = service.save(recipe);
        return ResponseEntity.ok(responseBody);
    }
}
