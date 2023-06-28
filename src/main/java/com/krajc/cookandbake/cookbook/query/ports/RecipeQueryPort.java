package com.krajc.cookandbake.cookbook.query.ports;

import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecipeQueryPort {
    List<RecipeView> findAll();
    Optional<RecipeView> findById(UUID id);
    List<RecipeView> findByTitleContaining(String titleContaining);
}
