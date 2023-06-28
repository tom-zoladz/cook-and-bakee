package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "appliance")
public class ApplianceJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appliance_id")
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "appliance_recipe",
            joinColumns = @JoinColumn(name = "appliance_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private List<RecipeJpa> recipes;

    public ApplianceJpa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long applianceId) {
        this.id = applianceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
