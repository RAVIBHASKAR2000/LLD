package main.java.org.lldProblemStatements.bookMyShow.services;


import main.java.org.lldProblemStatements.bookMyShow.models.User;

import java.util.HashMap;

public class UserService {
    private HashMap<String, User> users;
    private static UserService instance;

    private UserService(){
        this.users = new HashMap<>();
    }

    public static UserService getInstance(){
        if(instance==null){
            instance = new UserService();
        }
        return instance;
    }

    public void addUser(User user){users.put(user.getUserName(),user);}

    public void removeUser(String userName){users.remove(userName);}

    public boolean isValidUser(String userName){return users.containsKey(userName);}
}
