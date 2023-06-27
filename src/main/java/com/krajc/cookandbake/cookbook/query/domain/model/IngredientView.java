package com.krajc.cookandbake.cookbook.query.domain.model;

import java.util.UUID;

public record IngredientView(
        UUID id,
        String name
) {}
