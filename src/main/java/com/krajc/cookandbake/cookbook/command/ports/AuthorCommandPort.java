package com.krajc.cookandbake.cookbook.command.ports;

import com.krajc.cookandbake.cookbook.command.domain.model.Author;

import java.util.UUID;

public interface AuthorCommandPort {
    Author save(Author author);
    void deleteById(UUID id);
}