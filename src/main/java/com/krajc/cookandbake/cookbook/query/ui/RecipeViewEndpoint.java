package com.krajc.cookandbake.cookbook.query.ui;

import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.query.domain.service.RecipeViewQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/app/recipes")
public class RecipeViewEndpoint {

    RecipeViewQueryService queryService;

    public RecipeViewEndpoint(RecipeViewQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeView>> getAllRecipesViews() {
        return ResponseEntity.ok(
                queryService.findAll()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<RecipeView> getRecipeViewById(@PathVariable UUID id) {
        Optional<RecipeView> recipeView = queryService.findById(id);

        if (recipeView.isPresent()) {
            return ResponseEntity.ok(
                    queryService.findById(id).get()
            );
        }
        else return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

}
