package com.krajc.cookandbake.cookbook.query.domain.model;


import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa;

import java.util.List;
import java.util.UUID;

public record AuthorView(
        UUID authorId,
        String name,
        List<RecipeView> recipes
) {
    public static AuthorView getFromJpa(AuthorJpa authorJpa) {
        return new AuthorView(
                authorJpa.getAuthorId(),
                authorJpa.getName(),
                authorJpa.getRecipes()
                        .stream()
                        .map(RecipeView::getFromJpa)
                        .toList()
        );
    }
}
