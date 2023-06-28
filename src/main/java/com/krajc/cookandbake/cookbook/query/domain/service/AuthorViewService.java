package com.krajc.cookandbake.cookbook.query.domain.service;

import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView;
import com.krajc.cookandbake.cookbook.query.ports.AuthorQueryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorViewService { //TODO exceptions
    AuthorQueryPort authorQueryPort;

    public AuthorViewService(AuthorQueryPort authorQueryPort) {
        this.authorQueryPort = authorQueryPort;
    }

    public List<AuthorView> findAll() {
        return authorQueryPort.findAll();
    }

    //TODO exceptions
    public AuthorView findById(String id) {
        return authorQueryPort.findById(UUID.fromString(id)).get();
    }
}
