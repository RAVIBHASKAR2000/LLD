package main.java.org.lldProblemStatements.bookMyShow.services;

import main.java.org.lldProblemStatements.bookMyShow.models.AdminUser;
import main.java.org.lldProblemStatements.bookMyShow.models.User;

import java.util.HashMap;

public class AdminService {
    private HashMap<String, User> admins;
    private static AdminService instance;

    private AdminService(){
        this.admins = new HashMap<>();
    }

    public static AdminService getInstance(){
        if(instance==null){
            instance = new AdminService();
        }
        return instance;
    }

    public void addUser(AdminUser user){
        admins.put(user.getUserName(),user);}

    public void removeUser(String userName){
        admins.remove(userName);}

    public boolean isValidUser(String userName){return admins.containsKey(userName);}
}
