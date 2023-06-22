package com.krajc.cookandbake.cookbook.query.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;

import java.util.List;
import java.util.UUID;

public record RecipeView(
        UUID id,
        String title,
        String description,
        AuthorView author,
        List<IngredientView> ingredients,
        List<ApplianceView> appliances
) {
    public static RecipeView getFromJpa(RecipeJpa recipeJpa) {
        return new RecipeView(
                recipeJpa.getId(),
                recipeJpa.getTitle(),
                recipeJpa.getDescription(),
                AuthorView.getFromJpa(recipeJpa.getAuthor()),
                recipeJpa.getIngredients()
                        .stream()
                        .map(IngredientView::getFromJpa)
                        .toList(),
                recipeJpa.getAppliances()
                        .stream()
                        .map(ApplianceView::getFromJpa)
                        .toList()
        );
    }
}
