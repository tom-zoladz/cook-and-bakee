package com.krajc.cookandbake.cookbook.command.domain.model;

import java.util.UUID;

public record Kitchen(
        UUID id,
        String name,
        String description,
        UUID authorId
) {
}
