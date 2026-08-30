package com.amit.backend.controller;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest {

    private final HelloController controller = new HelloController();

    @Test
    void homeShouldReturnApplicationStatus() {
        Map<String, String> response = controller.home();

        assertEquals("Java 3-Tier Application", response.get("message"));
        assertEquals("running", response.get("status"));
    }

    @Test
    void helloShouldReturnBackendMessage() {
        Map<String, String> response = controller.hello();

        assertEquals("Hello from Spring Boot Backend", response.get("message"));
    }
}
