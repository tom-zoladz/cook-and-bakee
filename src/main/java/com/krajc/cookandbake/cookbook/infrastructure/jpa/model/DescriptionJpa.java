package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import java.util.UUID;

public record DescriptionJpa (
    UUID recipeId,
    String description
) {
}
