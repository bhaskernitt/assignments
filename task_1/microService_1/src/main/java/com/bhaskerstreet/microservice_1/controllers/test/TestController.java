package com.bhaskerstreet.microservice_1.controllers.test;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController will not be available in dev and production profiles. it will only be used to mock
 * the application 2 and application 3 responses.
 */
@RestController
@Profile("test")
public class TestController {
    @GetMapping("/app2")
    public String stubApp2() {
        return "Hello";
    }

    @PostMapping("/app3")
    public String stubApp3() {
        return "james Bond";
    }
}
