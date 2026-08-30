package com.amit.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "message", "Java 3-Tier Application",
            "status", "running"
        );
    }

    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        return Map.of(
            "message", "Hello from Spring Boot Backend"
        );
    }
}
