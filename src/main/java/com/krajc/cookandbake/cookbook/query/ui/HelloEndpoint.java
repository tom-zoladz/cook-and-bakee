package com.krajc.cookandbake.cookbook.query.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloEndpoint {

    @GetMapping
    public String helloWorld() {
        return "Hello web world!";
    }

}
