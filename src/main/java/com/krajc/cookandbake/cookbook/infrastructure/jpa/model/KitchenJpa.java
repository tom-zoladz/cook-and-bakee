package com.krajc.cookandbake.cookbook.infrastructure.jpa.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "kitchen")
public class KitchenJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "kitchen_id")
    private UUID id;
    private String name;
    private String description;

    @OneToOne(mappedBy = "kitchen")
    private AuthorJpa author;

    public KitchenJpa() {}

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
}
