package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ingredient")
public class IngredientJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ingredient_id")
    private UUID id;
    private String name;

    @ManyToMany
    @JoinTable(name = "ingredient_recipe",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<RecipeJpa> recipes;

    public IngredientJpa() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
