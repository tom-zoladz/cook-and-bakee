package com.krajc.cookandbake.cookbook.infrastructure.jpa.repository;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.ApplianceJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceJpaRepository extends JpaRepository<ApplianceJpa, Long> {
}
