package com.krajc.cookandbake.cookbook.query.domain.service;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.RecipeJpaRepository;
import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeViewQueryService {

    RecipeJpaRepository repository;

    public RecipeViewQueryService(RecipeJpaRepository repository) {
        this.repository = repository;
    }

    public List<RecipeView> findAll() {
        return repository.findAll()
                .stream()
                .map(RecipeView::getFromJpa)
                .toList();
    }

    public Optional<RecipeView> findById(UUID id) {
        Optional<RecipeJpa> recipeFromRepo = repository.findById(id);
        if (recipeFromRepo.isPresent()) {
            RecipeJpa recipeJpa = recipeFromRepo.get();
            return Optional.of(
                    RecipeView.getFromJpa(recipeJpa)
            );
        } else return Optional.empty();
    }
}
