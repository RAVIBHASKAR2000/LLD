package main.java.org.lldProblemStatements.JiraBoardManagementSystem.models;

import java.util.UUID;

public class Card {
    private final UUID cardID;
    private String name;
    private User assignedUser;
    private Priority priority;

    // mention that builder pattern can be used to instantiate the class
    public Card(String name){
        this.name = name;
        this.cardID = UUID.randomUUID();
        this.priority = Priority.P1;
    }

    public Card(String name, Priority priority){
        this.name = name;
        this.cardID = UUID.randomUUID();
        this.priority = priority;
    }

    public UUID getCardID() {
        return cardID;
    }

    public String getName() {
        return name;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void unAssignUser() {
        this.assignedUser = null;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
