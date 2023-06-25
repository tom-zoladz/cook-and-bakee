package com.krajc.cookandbake.cookbook.infrastructure.jpa.adapters;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.AuthorJpaRepository;
import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView;
import com.krajc.cookandbake.cookbook.query.ports.AuthorQueryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class AuthorRepositoryAdapter implements AuthorQueryPort {
    AuthorJpaRepository authorRepository;

    public AuthorRepositoryAdapter(AuthorJpaRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorView> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper)
                .toList();
    }

    @Override
    public AuthorView findById(UUID id) {
        Optional<AuthorJpa> optionalAuthorJpa = authorRepository.findById(id);
        if (optionalAuthorJpa.isPresent()) {
            return optionalAuthorJpa
                    .map(authorMapper)
                    .get();
        }
        return null;
    }

    private Function<AuthorJpa, AuthorView> authorMapper = authorJpa ->
            new AuthorView(
                    authorJpa.getId(),
                    authorJpa.getName()
            );
}
