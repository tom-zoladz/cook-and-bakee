package com.krajc.cookandbake.cookbook.infrastructure.jpa.repository;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.KitchenJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KitchenJpaRepository extends JpaRepository<KitchenJpa, UUID> {
}
