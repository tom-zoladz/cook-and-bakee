package com.krajc.cookandbake.cookbook.command.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa;

import java.util.List;
import java.util.UUID;

public record Author(
        UUID id,
        String name,
        List<Recipe> recipes
) {
    public static Author getFromJpa(AuthorJpa authorJpa) {
        return new Author(
                authorJpa.getId(),
                authorJpa.getName(),
                authorJpa.getRecipes()
                        .stream()
                        .map(Recipe::getFromJpa)
                        .toList()
        );
    }

    public AuthorJpa toJpa() {
        return new AuthorJpa(
                this.name
        );
    }
}
