package com.krajc.cookandbake.cookbook.command.domain.model;

import java.util.List;
import java.util.UUID;

public record Author(
        UUID id,
        String name,
        List<UUID> recipeIds
) {}
