package com.krajc.cookandbake.cookbook.infrastructure.jpa.repository;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.RecipeJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RecipeJpaRepository extends JpaRepository<RecipeJpa, UUID> {
    List<RecipeJpa> findAllByTitleContaining(String titleContaining);
}
