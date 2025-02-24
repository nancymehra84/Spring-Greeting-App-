package com.bridgelabz.greeting_app.controller;

import com.bridgelabz.greeting_app.dto.Greeting;
import com.bridgelabz.greeting_app.model.GreetingEntity;
import org.springframework.web.bind.annotation.*;
import com.bridgelabz.greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

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

    // Save Greeting
    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }

    // Get All Greetings
    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    // Get Greeting by ID
    @GetMapping("/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    //UC-7
    @Autowired

    // API to update a greeting message by ID
    @PutMapping("/update/{id}")
    public GreetingEntity updateGreeting(@PathVariable(value="id") Long id, @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

    //UC-8
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGreeting(@PathVariable("id") Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.ok("Greeting message with ID " + id + " deleted successfully!");
    }
}
