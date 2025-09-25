package models;
import java.time.LocalDate;
import java.util.*;

abstract public class User {
    protected String userId;
    protected String username;
    protected String email;
    protected String phoneNumber;
    protected LocalDate dateOfBirth;

    public User(String userId, String username, String email, String phoneNumber, LocalDate dateOfBirth) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean login(String username, String password) {
        // Simplified login logic
        return this.username.equals(username);
    }

    // Getters
    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
}
