package com.flipkart.service;

import com.flipkart.model.User;

import java.util.HashMap;

public class UserService {
    HashMap<String, User> allUsers  = new HashMap<>();

    public User getUserById(String id){
        if(allUsers.containsKey(id)){
            return allUsers.get(id);
        }
        System.out.println("User not found");
        return null;
    }

    public String addUser(String id, String name, String email){
        User newUser = new User(id, name, email);
        allUsers.put(id, newUser);
        return newUser.getId();
    }

    public void deleteUser(String id){
        if(allUsers.containsKey(id)){
            // remove from all assigned tasks
            allUsers.remove(id);
        }
    }


}
