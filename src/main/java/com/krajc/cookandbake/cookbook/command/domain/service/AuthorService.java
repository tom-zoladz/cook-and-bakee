package com.krajc.cookandbake.cookbook.command.domain.service;

import com.krajc.cookandbake.cookbook.command.domain.model.Author;
import com.krajc.cookandbake.cookbook.command.ports.AuthorCommandPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorService {

    AuthorCommandPort authorCommandPort;

    public AuthorService(AuthorCommandPort authorCommandPort) {
        this.authorCommandPort = authorCommandPort;
    }

    public Author save(Author author) {
        return authorCommandPort.save(author);
    }

    public void deleteById(String id) {
        authorCommandPort.deleteById(UUID.fromString(id));
    }
}
