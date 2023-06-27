package com.krajc.cookandbake.cookbook.command.domain.model;

import java.util.UUID;

public record Ingredient(
        UUID id,
        String name
) {}
