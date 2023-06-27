package com.krajc.cookandbake.cookbook.command.ui;

import com.krajc.cookandbake.cookbook.command.domain.model.Author;
import com.krajc.cookandbake.cookbook.command.domain.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/authors")
public class AuthorEndpoint {
    AuthorService service;

    public AuthorEndpoint(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Author> postAuthor(@RequestBody Author author) {
        Author responseBody = service.save(author);
        return ResponseEntity.ok(responseBody);
    }
}
