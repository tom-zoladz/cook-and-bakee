package com.krajc.cookandbake.cookbook.command.domain.service;

import com.krajc.cookandbake.cookbook.command.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.RecipeJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RecipeViewCommandService {
    RecipeJpaRepository repository;

    public RecipeViewCommandService(RecipeJpaRepository repository) {
        this.repository = repository;
    }

    public RecipeView save(RecipeView recipeView) {
        repository.save(recipeView.toJpa());
        return recipeView;
    }

}
