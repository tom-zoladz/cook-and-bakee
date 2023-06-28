package com.krajc.cookandbake.cookbook.infrastructure.jpa.adapters;

import com.krajc.cookandbake.cookbook.command.domain.model.Author;
import com.krajc.cookandbake.cookbook.command.ports.AuthorCommandPort;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.AuthorJpaRepository;
import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView;
import com.krajc.cookandbake.cookbook.query.ports.AuthorQueryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Component
public class AuthorRepositoryAdapter implements AuthorCommandPort, AuthorQueryPort {
    AuthorJpaRepository authorRepository;

    public AuthorRepositoryAdapter(AuthorJpaRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorView> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorViewMapper)
                .toList();
    }

    @Override
    public Optional<AuthorView> findById(UUID id) {
        return authorRepository.findById(id).map(authorViewMapper);
    }

    @Override
    public Author save(Author author) {
        AuthorJpa authorJpa = new AuthorJpa();
        authorJpa.setName(author.name());
        AuthorJpa savedAuthor = authorRepository.save(authorJpa);
        return authorMapper.apply(savedAuthor);
    }

    @Override
    public void deleteById(UUID id) {
        authorRepository.deleteById(id);
    }

    private final Function<AuthorJpa, AuthorView> authorViewMapper = authorJpa ->
            new AuthorView(
                    authorJpa.getId(),
                    authorJpa.getName(),
                    authorJpa.getRecipes().stream().map(RecipeJpa::getId).toList()
                    );

    private final Function<AuthorJpa, Author> authorMapper = authorJpa ->
            new Author(
                    authorJpa.getId(),
                    authorJpa.getName(),
                    authorJpa.getRecipes() == null ?
                            null :
                            authorJpa.getRecipes()
                                    .stream()
                                    .map(RecipeJpa::getId)
                                    .toList()
            );
}
