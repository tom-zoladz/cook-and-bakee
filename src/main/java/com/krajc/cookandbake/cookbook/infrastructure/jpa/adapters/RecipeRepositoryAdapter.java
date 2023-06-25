package com.krajc.cookandbake.cookbook.infrastructure.jpa.adapters;

import com.krajc.cookandbake.cookbook.command.domain.model.Appliance;
import com.krajc.cookandbake.cookbook.command.domain.model.Ingredient;
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
import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView;
import com.krajc.cookandbake.cookbook.query.ports.RecipeQueryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class RecipeRepositoryAdapter implements RecipeCommandPort, RecipeQueryPort {
    RecipeJpaRepository recipeRepository;
    AuthorJpaRepository authorRepository;
    IngredientJpaRepository ingredientRepository;
    ApplianceJpaRepository applianceJpaRepository;

    AuthorRepositoryAdapter authorRepositoryAdapter;

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
                .map(recipeJpa ->
                        new RecipeView(
                                recipeJpa.getId(),
                                recipeJpa.getTitle(),
                                recipeJpa.getDescription(),
                                authorRepositoryAdapter
                                ingredientRepository.findAllById(recipeJpa.getIngredients()
                                        .stream()
                                        .map(IngredientJpa::getId)
                                        .toList()),
                                applianceJpaRepository.findAllById(recipeJpa.getAppliances()
                                        .stream()
                                        .map(ApplianceJpa::getId)
                                        .toList())
                        )

                )
                .toList();
    }

    @Override
    public RecipeView findById(UUID id) {
        return null;
    }

    @Override
    public Recipe save(Recipe recipe) {
//        AuthorJpa authorJpa = null;
//        Optional<AuthorJpa> authorJpaOptional = authorRepository.findById(recipe.author().id());
//        if (authorJpaOptional.isPresent()) {
//            authorJpa = authorJpaOptional.get();
//        }
//
//        RecipeJpa savedRecipeJpa = recipeRepository.save(new RecipeJpa(
//                        recipe.title(),
//                        recipe.description(),
//                        authorJpa,
//                        ingredientRepository.findAllById(
//                                recipe.ingredients()
//                                        .stream()
//                                        .map(Ingredient::id)
//                                        .toList()
//                        ),
//                        applianceJpaRepository.findAllById(
//                                recipe.appliances()
//                                        .stream()
//                                        .map(Appliance::id)
//                                        .toList()
//                        )
//                )
//        );
        return null; //TODO
    }
}
