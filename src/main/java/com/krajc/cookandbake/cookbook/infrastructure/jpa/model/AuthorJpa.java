package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Author")
public class AuthorJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "author_id")
    private UUID id;
    private String name;
    @OneToMany//(mappedBy = "author")
    private List<RecipeJpa> recipes;

    public AuthorJpa() {
    }

    public AuthorJpa(String name) {
        this.name = name;
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

    public List<RecipeJpa> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeJpa> recipes) {
        this.recipes = recipes;
    }
}
