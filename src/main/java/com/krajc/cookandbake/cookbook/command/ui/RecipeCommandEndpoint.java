package com.krajc.cookandbake.cookbook.command.ui;

import com.krajc.cookandbake.cookbook.command.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.command.domain.service.RecipeViewCommandService;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.DescriptionJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/recipes")
public class RecipeCommandEndpoint {

    RecipeViewCommandService service;

    public RecipeCommandEndpoint(RecipeViewCommandService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecipeView> postRecipe(@RequestBody RecipeView recipeView) {
        RecipeView responseBody = service.save(recipeView);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/title")
    public ResponseEntity<RecipeView> updateRecipe(@RequestParam String id, @RequestParam String title) {
        RecipeView responseBody = service.updateTitle(id, title);
        return responseBody==null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody) :
                ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/description")
    public ResponseEntity<RecipeView> updateRecipe(@RequestBody DescriptionJpa descriptionJpa) {
        RecipeView responseBody = service.updateDescription(descriptionJpa);
        return responseBody==null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody) :
                ResponseEntity.ok(responseBody);
    }

    @DeleteMapping
    public void deleteRecipe(@RequestParam String id) {
        service.deleteById(id);
    }
}
