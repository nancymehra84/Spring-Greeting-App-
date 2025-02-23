package com.bridgelabz.greeting_app.controller;

import com.bridgelabz.greeting_app.dto.Greeting;
import org.springframework.web.bind.annotation.*;
import com.bridgelabz.greeting_app.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello from GET Methods!");
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello from POST method!");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello from PUT Method!");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello from DELETE method!");
    }

    public final GreetingService greetingService;

    // Constructor-based dependency injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/2")
    public Greeting getGreetingService() {
        return new Greeting(greetingService.getGreetingMessage());
    }

    //UC-3
    @GetMapping("/3")
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return new Greeting(greetingService.getGreetingMessage(firstName, lastName));
    }
}
