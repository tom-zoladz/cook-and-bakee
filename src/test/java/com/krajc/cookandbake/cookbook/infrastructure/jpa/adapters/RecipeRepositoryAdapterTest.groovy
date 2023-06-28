package com.krajc.cookandbake.cookbook.infrastructure.jpa.adapters

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.KitchenJpa
import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.ApplianceJpaRepository
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.AuthorJpaRepository
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.IngredientJpaRepository
import com.krajc.cookandbake.cookbook.infrastructure.jpa.repository.RecipeJpaRepository
import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView
import com.krajc.cookandbake.cookbook.query.domain.model.RecipeView
import spock.lang.Specification

class RecipeRepositoryAdapterTest extends Specification {

    def recipeRepository = Mock(RecipeJpaRepository)
    def authorRepository = Mock(AuthorJpaRepository)
    def ingredientRepository = Mock(IngredientJpaRepository)
    def applianceRepository = Mock(ApplianceJpaRepository)

    def recipeRepositoryAdapter = new RecipeRepositoryAdapter(
            recipeRepository,
            authorRepository,
            ingredientRepository,
            applianceRepository
    )

    def "should return Optional with RecipeView"() {
        given:
        recipeRepository.findById(input) >> givenRecipeJpaOptional
        authorRepository.findById(null) >> Optional.of(new AuthorJpa(
                UUID.fromString("00000000-0000-0000-0000-000000000000"),
                "name",
                List.of(),
                new KitchenJpa()
        )
        )

        when:
        def returnedList = recipeRepositoryAdapter.findById(input)

        then:
        returnedList == givenRecipeViews

        where:
        input = UUID.fromString("00000000-0000-0000-0000-000000000000")
    }

    private static final def givenRecipeJpaOptional = Optional.of(
            new RecipeJpa(
                    UUID.fromString("00000000-0000-0000-0000-000000000000"),
                    "Bigos",
                    "Test description of Bigos",
                    new AuthorJpa(),
                    List.of(),
                    List.of()
            )
    )

    private static final def givenRecipeViews = Optional.of(
            new RecipeView(
                    UUID.fromString("00000000-0000-0000-0000-000000000000"),
                    "Bigos",
                    "Test description of Bigos",
                    new AuthorView(
                            UUID.fromString("00000000-0000-0000-0000-000000000000"),
                            "name",
                            List.of(),
                            null
                    ),
                    List.of(),
                    List.of()
            )
    )
}
