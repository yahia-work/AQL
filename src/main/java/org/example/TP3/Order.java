package org.example.TP3;

public class Order {
    private long id;
    private String description;

    // Constructor, Getters, Setters
    public Order(long id, String description) {
        this.id = id;
        this.description = description;
    }
    public long getId() { return id; }
    public String getDescription() { return description; }
}

