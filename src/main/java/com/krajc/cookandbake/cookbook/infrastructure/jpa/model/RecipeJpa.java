package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Recipe")
public class RecipeJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "recipe_id")
    private UUID id;
    private String title;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "author_id")
    private AuthorJpa author;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<IngredientJpa> ingredients;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ApplianceJpa> appliances;


    public RecipeJpa() {
    }

    public RecipeJpa(
            String title,
            String description,
            AuthorJpa author,
            List<IngredientJpa> ingredients,
            List<ApplianceJpa> appliances) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.ingredients = ingredients;
        this.appliances = appliances;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AuthorJpa getAuthor() {
        return author;
    }

    public void setAuthor(AuthorJpa author) {
        this.author = author;
    }

    public List<IngredientJpa> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientJpa> ingredients) {
        this.ingredients = ingredients;
    }

    public List<ApplianceJpa> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<ApplianceJpa> appliances) {
        this.appliances = appliances;
    }
}
