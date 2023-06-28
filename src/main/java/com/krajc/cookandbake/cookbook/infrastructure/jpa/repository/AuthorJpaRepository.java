package com.krajc.cookandbake.cookbook.infrastructure.jpa.repository;

import com.krajc.cookandbake.cookbook.infrastructure.jpa.model.AuthorJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorJpaRepository extends JpaRepository<AuthorJpa, UUID> {
}
