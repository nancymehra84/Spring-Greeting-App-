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
}
