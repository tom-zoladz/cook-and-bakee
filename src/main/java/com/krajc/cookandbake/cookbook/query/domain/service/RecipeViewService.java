package com.krajc.cookandbake.cookbook.query.domain.service;

import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.query.ports.RecipeQueryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeViewService {

    RecipeQueryPort recipeQueryPort;

    public RecipeViewService(RecipeQueryPort recipeQueryPort) {
        this.recipeQueryPort = recipeQueryPort;
    }

    public List<RecipeView> findAll() {
        return recipeQueryPort.findAll();
    }

    //TODO exceptions
    public RecipeView findById(String id) {
        return recipeQueryPort.findById(UUID.fromString(id)).get();
    }

    public List<RecipeView> findByTitleContaining(String titleLike) {
        return recipeQueryPort.findByTitleContaining(titleLike);
    }
}
