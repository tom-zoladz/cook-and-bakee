package com.krajc.cookandbake.cookbook.query.ports;

import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView;

import java.util.List;
import java.util.UUID;

public interface AuthorQueryPort {
    List<AuthorView> findAll();
    AuthorView findById(UUID id);

}
