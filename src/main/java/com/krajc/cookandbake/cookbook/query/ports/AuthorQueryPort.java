package com.krajc.cookandbake.cookbook.query.ports;

import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorQueryPort {
    List<AuthorView> findAll();
    Optional<AuthorView> findById(UUID id);

}
