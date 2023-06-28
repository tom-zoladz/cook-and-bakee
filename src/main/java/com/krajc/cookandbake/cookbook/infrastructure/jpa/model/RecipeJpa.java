package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recipe")
public class RecipeJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "recipe_id")
    private UUID id;
    private String title;
    private String description;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "author_id")
    private AuthorJpa author;

    @ManyToMany
    @JoinTable(name = "ingredient_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<IngredientJpa> ingredients;

    @ManyToMany
    @JoinTable(name = "appliance_recipe",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "appliance_id"))
    private List<ApplianceJpa> appliances;


    public RecipeJpa() {
    }

    public RecipeJpa(UUID id, String title, String description, AuthorJpa author, List<IngredientJpa> ingredients, List<ApplianceJpa> appliances) {
        this.id = id;
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
