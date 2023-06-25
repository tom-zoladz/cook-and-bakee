package com.krajc.cookandbake.cookbook.query.ports;

import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;

import java.util.List;
import java.util.UUID;

public interface RecipeQueryPort {
    List<RecipeView> findAll();
    RecipeView findById(UUID id);
}
