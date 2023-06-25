package com.krajc.cookandbake.cookbook.command.ports;

import com.krajc.cookandbake.cookbook.command.domain.model.Author;

public interface AuthorCommandPort {
    Author save(Author author);
}