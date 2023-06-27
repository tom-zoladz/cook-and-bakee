package com.krajc.cookandbake.cookbook.query.domain.model;

import java.util.List;
import java.util.UUID;

public record RecipeView(
        UUID id,
        String title,
        String description,
        AuthorView author,
        List<IngredientView> ingredients,
        List<ApplianceView> appliances
) {}
