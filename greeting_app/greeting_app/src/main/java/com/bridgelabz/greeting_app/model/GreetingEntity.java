package com.bridgelabz.greeting_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private Long id;

    private String message;

    // Constructors
    public GreetingEntity() {}

    public GreetingEntity(String message) {
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}