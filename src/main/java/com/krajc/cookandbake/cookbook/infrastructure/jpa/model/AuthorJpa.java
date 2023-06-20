package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table
public class AuthorJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID authorId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RecipeJpa> recipes;

    public AuthorJpa() {
    }

    public AuthorJpa(String name) {
        this.name = name;
    }

    public AuthorJpa(String name, List<RecipeJpa> recipes) {
        this.name = name;
        this.recipes = recipes;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID id) {
        this.authorId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeJpa> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeJpa> recipes) {
        this.recipes = recipes;
    }
}
