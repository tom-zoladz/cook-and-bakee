package com.krajc.cookandbake.cookbook.query.domain.model;

import java.util.List;
import java.util.UUID;

public record AuthorView(
        UUID id,
        String name,
        List<UUID> recipes
) {}
