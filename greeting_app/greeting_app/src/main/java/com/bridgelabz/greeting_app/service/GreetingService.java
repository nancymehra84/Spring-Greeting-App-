package com.bridgelabz.greeting_app.service;

import com.bridgelabz.greeting_app.model.GreetingEntity;
import com.bridgelabz.greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    public String getGreetingMessage() {
        return "Hello World";
    }

    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + " from BridgeLabz!";
        } else if (firstName != null) {
            return "Hello " + firstName + " from BridgeLabz!";
        } else if (lastName != null) {
            return "Hello " + lastName + " from BridgeLabz!";
        } else {
            return "Hello World!";
        }
    }
    @Autowired
    private GreetingRepository greetingRepository;



    // Save greeting to the database
    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

    // Get all greetings
    public List<GreetingEntity> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Get greeting by ID
    public Optional<GreetingEntity> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    //UC-5

    public GreetingEntity findGreetingById(Long id) {
        Optional<GreetingEntity> greeting = greetingRepository.findById(id);
        return greeting.orElse(null); // Returns null if not found (or throw exception)
    }

    //UC-7
    // Method to update a greeting message by ID
    public GreetingEntity updateGreeting(Long id, String newMessage) {
        return greetingRepository.findById(id).map(greeting -> {
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }).orElseThrow(() -> new RuntimeException("Greeting with ID " + id + " not found"));
    }

    //UC-8
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public void deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Greeting with ID " + id + " not found");
        }
    }
}
