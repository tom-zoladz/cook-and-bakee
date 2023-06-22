package com.krajc.cookandbake.cookbook.command.domain.service;

import com.krajc.cookandbake.cookbook.command.domain.model.Recipe;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.DescriptionJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.RecipeJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeViewCommandService {
    RecipeJpaRepository repository;

    public RecipeViewCommandService(RecipeJpaRepository repository) {
        this.repository = repository;
    }

    public Recipe save(Recipe recipe) {
        repository.save(recipe.toJpa());
        return recipe;
    }
    public Recipe updateTitle(String id, String title) {
        Optional<RecipeJpa> recipeFromRepo = repository.findById(UUID.fromString(id));
        if (recipeFromRepo.isPresent()) {
            RecipeJpa recipeJpa = recipeFromRepo.get();
            recipeJpa.setTitle(title);
            repository.save(recipeJpa);
            return Recipe.getFromJpa(recipeJpa);
        }
        else return null;
    }
    public Recipe updateDescription(DescriptionJpa descriptionJpa) {
        Optional<RecipeJpa> recipeFromRepo = repository.findById(descriptionJpa.recipeId());
        if (recipeFromRepo.isPresent()) {
            RecipeJpa recipeJpa = recipeFromRepo.get();
            recipeJpa.setDescription(descriptionJpa.description());
            repository.save(recipeJpa);
            return Recipe.getFromJpa(recipeJpa);
        }
        else return null;
    }

    public boolean deleteById(String id) {
        Optional<RecipeJpa> recipeFromRepo = repository.findById(UUID.fromString(id));
        if (recipeFromRepo.isPresent()) {
            repository.deleteById(UUID.fromString(id));
            return true;
        }
        return false;
    }

}
