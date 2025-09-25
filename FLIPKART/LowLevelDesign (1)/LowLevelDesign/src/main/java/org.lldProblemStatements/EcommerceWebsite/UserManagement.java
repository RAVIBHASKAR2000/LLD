package main.java.org.lldProblemStatements.EcommerceWebsite;

import java.util.*;

public class UserManagement {
    private List<User> users;

    public UserManagement() {
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }
}
