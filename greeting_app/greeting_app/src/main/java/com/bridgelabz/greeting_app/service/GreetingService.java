package com.bridgelabz.greeting_app.service;

import org.springframework.stereotype.Service;
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
}
