package com.krajc.cookandbake.cookbook.query.domain.model;


import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa;

import java.util.UUID;

public record AuthorView(
        UUID id,
        String name
) {
    public static AuthorView getFromJpa(AuthorJpa authorJpa) {
        return new AuthorView(
                authorJpa.getId(),
                authorJpa.getName());
    }
}
