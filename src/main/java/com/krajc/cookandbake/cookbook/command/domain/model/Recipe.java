package com.krajc.cookandbake.cookbook.command.domain.model;

import java.util.List;
import java.util.UUID;

public record Recipe(
    UUID id,
    String title,
    String description,
    UUID authorId,
    List<UUID> ingredientIds,
    List<Long> applianceIds
) {}
