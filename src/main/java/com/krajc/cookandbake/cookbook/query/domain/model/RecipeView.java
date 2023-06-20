package com.krajc.cookandbake.cookbook.query.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public record RecipeView(
        UUID recipeId,
        String title,
        String description,
        AuthorView author,
        List<IngredientView> ingredients,
        List<ApplianceView> appliances
) {
    public static RecipeView getFromJpa(RecipeJpa recipeJpa) {
        return new RecipeView(
                recipeJpa.getRecipeId(),
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
