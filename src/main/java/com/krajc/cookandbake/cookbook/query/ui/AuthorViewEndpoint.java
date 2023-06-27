package com.krajc.cookandbake.cookbook.query.ui;


import com.krajc.cookandbake.cookbook.query.domain.model.AuthorView;
import com.krajc.cookandbake.cookbook.query.domain.service.AuthorViewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/authors")
public class AuthorViewEndpoint {
    AuthorViewService queryService;

    public AuthorViewEndpoint(AuthorViewService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorView>> getAllAuthors() {
        return ResponseEntity.ok(
                queryService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorView> getAuthorViewById(@PathVariable String id) {
        return ResponseEntity.ok(queryService.findById(id));
    }

}
