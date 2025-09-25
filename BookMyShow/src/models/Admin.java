package models;

import java.time.LocalDate;
import  java.util.*;
public class Admin extends User{
    private String role;
    private List<String> permissions;

    public Admin(String userId, String username, String email, String phoneNumber, LocalDate dateOfBirth, String role) {
        super(userId, username, email, phoneNumber, dateOfBirth);
        this.role = role;
        this.permissions = new ArrayList<>();
    }

    public void manageTheatres() {
        System.out.println("Managing theatres...");
    }
}
