package com.krajc.cookandbake.cookbook.query.ui;

import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.query.domain.service.RecipeViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/recipes")
public class RecipeViewEndpoint {

    RecipeViewService queryService;

    public RecipeViewEndpoint(RecipeViewService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeView>> getAllRecipesViews() {
        return ResponseEntity.ok(
                queryService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeView> getRecipeViewById(@PathVariable String id) {
        return ResponseEntity.ok(queryService.findById(id));
    }

}
