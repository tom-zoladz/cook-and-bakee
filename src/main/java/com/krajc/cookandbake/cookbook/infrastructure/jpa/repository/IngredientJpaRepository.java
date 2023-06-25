package com.krajc.cookandbake.cookbook.infrastructure.jpa.repository;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.IngredientJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientJpaRepository extends JpaRepository<IngredientJpa, UUID> {
}
