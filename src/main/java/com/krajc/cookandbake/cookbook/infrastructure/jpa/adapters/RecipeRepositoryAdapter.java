package com.krajc.cookandbake.cookbook.infrastructure.jpa.adapters;

import com.krajc.cookandbake.cookbook.command.domain.model.Recipe;
import com.krajc.cookandbake.cookbook.command.ports.RecipeCommandPort;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.ApplianceJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.IngredientJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.ApplianceJpaRepository;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.AuthorJpaRepository;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.IngredientJpaRepository;
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.RecipeJpaRepository;
import com.krajc.cookandbake.cookbook.query.domain.model.ApplianceView;
import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView;
import com.krajc.cookandbake.cookbook.query.domain.model.IngredientView;
import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.query.ports.RecipeQueryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Component
public class RecipeRepositoryAdapter implements RecipeCommandPort, RecipeQueryPort {
    private final RecipeJpaRepository recipeRepository;
    private AuthorJpaRepository authorRepository;
    private final IngredientJpaRepository ingredientRepository;
    private final ApplianceJpaRepository applianceJpaRepository;


    public RecipeRepositoryAdapter(
            RecipeJpaRepository recipeRepository,
            AuthorJpaRepository authorRepository,
            IngredientJpaRepository ingredientRepository,
            ApplianceJpaRepository applianceJpaRepository) {
        this.recipeRepository = recipeRepository;
        this.authorRepository = authorRepository;
        this.ingredientRepository = ingredientRepository;
        this.applianceJpaRepository = applianceJpaRepository;
    }


    @Override
    public List<RecipeView> findAll() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeViewMapper)
                .toList();
    }

    @Override
    public Optional<RecipeView> findById(UUID id) {
        return recipeRepository.findById(id).map(recipeViewMapper);
    }

    @Override
    public Recipe save(Recipe recipe) {
        RecipeJpa recipeJpa = new RecipeJpa();
        recipeJpa.setTitle(recipe.title());
        recipeJpa.setDescription(recipe.description());
        recipeJpa.setAuthor(authorRepository.findById(recipe.authorId()).get()); //TODO exceptions
        recipeJpa.setIngredients(ingredientRepository.findAllById(recipe.ingredientIds()));
        recipeJpa.setAppliances(applianceJpaRepository.findAllById(recipe.applianceIds()));
        RecipeJpa savedRecipe = recipeRepository.save(recipeJpa);
        return recipeMapper.apply(savedRecipe);
    }

    @Override
    public void deleteById(UUID id) {
        recipeRepository.deleteById(id);
    }

    private final Function<RecipeJpa, RecipeView> recipeViewMapper = recipeJpa -> {
        AuthorJpa authorJpa = authorRepository.findById(recipeJpa.getAuthor().getId()).get(); //TODO exceptions
        return new RecipeView(
                recipeJpa.getId(),
                recipeJpa.getTitle(),
                recipeJpa.getDescription(),
                new AuthorView(
                        authorJpa.getId(),
                        authorJpa.getName(),
                        authorJpa.getRecipes().stream().map(RecipeJpa::getId).toList(),
                        authorJpa.getKitchen().getId()),
                recipeJpa.getIngredients().stream()
                        .map(ingredientJpa -> new IngredientView(
                                        ingredientJpa.getId(),
                                        ingredientJpa.getName()
                                )
                        )
                        .toList(),
                recipeJpa.getAppliances().stream()
                        .map(applianceJpa -> new ApplianceView(
                                        applianceJpa.getId(),
                                        applianceJpa.getName()
                                )
                        )
                        .toList()
        );
    };

    private final Function<RecipeJpa, Recipe> recipeMapper = recipeJpa ->
        new Recipe(
                recipeJpa.getId(),
                recipeJpa.getTitle(),
                recipeJpa.getDescription(),
                recipeJpa.getAuthor().getId(),
                recipeJpa.getIngredients()
                        .stream()
                        .map(IngredientJpa::getId)
                        .toList(),
                recipeJpa.getAppliances()
                        .stream()
                        .map(ApplianceJpa::getId)
                        .toList()
        );
}
