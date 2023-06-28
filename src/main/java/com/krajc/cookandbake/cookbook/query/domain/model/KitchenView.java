package com.krajc.cookandbake.cookbook.query.domain.model;

import java.util.UUID;

public record KitchenView(
        UUID id,
        String name,
        String description,
        UUID authorId
) {
}
