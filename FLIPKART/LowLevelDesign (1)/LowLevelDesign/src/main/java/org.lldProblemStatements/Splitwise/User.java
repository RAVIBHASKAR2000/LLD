package main.java.org.lldProblemStatements.Splitwise;

import java.util.*;

public class User {
    private String userName;
    private List<Group> userGroups;
    private String name;

    public User(String name){
        this.name = name;
        this.userName = name+"123";
        this.userGroups = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public List<Group> getUserGroups() {
        return userGroups;
    }

    public void addToGroup(Group group){
        userGroups.add(group);
    }

    public void removeFromGroup(Group group){
        userGroups.remove(group);
    }
}
