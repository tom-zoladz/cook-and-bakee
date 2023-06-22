package com.krajc.cookandbake.cookbook.command.ui;

import com.krajc.cookandbake.cookbook.command.domain.model.Recipe;
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
    public ResponseEntity<Recipe> postRecipe(@RequestBody Recipe recipe) {
        Recipe responseBody = service.save(recipe);
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/title")
    public ResponseEntity<Recipe> updateRecipe(@RequestParam String id, @RequestParam String title) {
        Recipe responseBody = service.updateTitle(id, title);
        return responseBody==null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody) :
                ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/description")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody DescriptionJpa descriptionJpa) {
        Recipe responseBody = service.updateDescription(descriptionJpa);
        return responseBody==null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody) :
                ResponseEntity.ok(responseBody);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRecipe(@RequestParam String id) {
        if (service.deleteById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
