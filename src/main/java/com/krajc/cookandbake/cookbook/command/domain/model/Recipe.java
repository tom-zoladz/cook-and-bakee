package com.krajc.cookandbake.cookbook.command.domain.model;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;

import java.util.List;
import java.util.UUID;

public record Recipe(
    UUID id,
    String title,
    String description,
    Author author,
    List<Ingredient> ingredients,
    List<Appliance> appliances
) {
    public static Recipe getFromJpa(RecipeJpa recipeJpa) {
        return new Recipe(
                recipeJpa.getId(),
                recipeJpa.getTitle(),
                recipeJpa.getDescription(),
                Author.getFromJpa(recipeJpa.getAuthor()),
                recipeJpa.getIngredients()
                        .stream()
                        .map(Ingredient::getFromJpa)
                        .toList(),
                recipeJpa.getAppliances()
                        .stream()
                        .map(Appliance::getFromJpa)
                        .toList()
        );
    }

    public RecipeJpa toJpa() {
        return new RecipeJpa(
                this.title,
                this.description,
                this.author.toJpa(),
                this.ingredients
                        .stream()
                        .map(Ingredient::toJpa)
                        .toList(),
                this.appliances
                        .stream()
                        .map(Appliance::toJpa)
                        .toList()
        );
    }
}
