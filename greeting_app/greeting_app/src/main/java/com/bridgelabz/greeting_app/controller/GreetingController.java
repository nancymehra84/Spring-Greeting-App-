package com.bridgelabz.greeting_app.controller;

import com.bridgelabz.greeting_app.dto.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Greeting getGreeting(){
        return new Greeting("Hello from GET Methods!");
    }

    @PostMapping
    public Greeting postGreeting(){
        return new Greeting("Hello from POST method!");
    }

    @PutMapping
    public Greeting putGreeting(){
        return new Greeting("Hello from PUT Method!");
    }

    @DeleteMapping
    public Greeting deleteGreeting(){
        return new Greeting("Hello from DELETE method!");
    }
}
