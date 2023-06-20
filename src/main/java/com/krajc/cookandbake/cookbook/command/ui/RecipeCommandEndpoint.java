package com.krajc.cookandbake.cookbook.command.ui;

import com.krajc.cookandbake.cookbook.command.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.command.domain.service.RecipeViewCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/recipes")
public class RecipeCommandEndpoint {

    RecipeViewCommandService service;

    public RecipeCommandEndpoint(RecipeViewCommandService service) {
        this.service = service;
    }

    @PostMapping
    public void postRecipe(@RequestBody RecipeView recipeView) {
        service.save(recipeView);
    }
}
