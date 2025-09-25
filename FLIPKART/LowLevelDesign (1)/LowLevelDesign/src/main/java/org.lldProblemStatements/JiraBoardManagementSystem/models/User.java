package main.java.org.lldProblemStatements.JiraBoardManagementSystem.models;

import java.util.*;

public class User {
    private final UUID userID;
    private String name;
    private String emailID;

    public User(String name, String emailID) {
        this.name = name;
        this.emailID = emailID;
        this.userID = UUID.randomUUID();
    }

    public UUID getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
}
