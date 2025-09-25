package main.java.org.lldProblemStatements.Splitwise;

import java.util.*;

public class SplitWise {
    private List<User> allUsers;
    private static SplitWise instance;
    private List<Group> allGroups;

    private SplitWise(){
        allUsers = new ArrayList<>();
        allGroups = new ArrayList<>();
    }

    public static SplitWise getInstance(){
        if(instance==null){
            instance = new SplitWise();
        }
        return instance;
    }

    public void addUser(User user){
        allUsers.add(user);
    }

    public List<Group> getGroups(User currentUser){
        return currentUser.getUserGroups();
    }

    public Group createGroup(String groupName,List<User> users, User createdBy){
        Group newGroup = new Group(groupName,users,createdBy);
        allGroups.add(newGroup);
//        createdBy.addToGroup(newGroup);
        return newGroup;
    }

    public void individualBalances(User user){
        // print whatever the current user owes to other users

    }

    public List<Group> getAllGroups() {
        return allGroups;
    }
}
