package main.java.org.lldProblemStatements.JiraBoardManagementSystem.services;

import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.User;
import java.util.*;

public class UserManagement {
    private HashMap<String, User> users;
    private static UserManagement instance;

    private UserManagement(){
        this.users = new HashMap<>();
    }

    public static UserManagement getInstance(){
        if(instance==null){
            instance = new UserManagement();
        }
        return instance;
    }

    public void create(String userName, String emailID){
        User newUser = new User(userName, emailID);

        users.put(userName, newUser);

        System.out.println("Successfully created user "+newUser.getUserID());
    }

    public User getUser(String userName){
        return this.users.get(userName);
    }

    public void removeUser(String userName){
        this.users.remove(userName);
    }
}
