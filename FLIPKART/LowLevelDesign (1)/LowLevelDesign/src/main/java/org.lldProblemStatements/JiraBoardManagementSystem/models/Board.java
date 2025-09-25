package main.java.org.lldProblemStatements.JiraBoardManagementSystem.models;

import java.util.*;

public class Board {
    private final UUID boardID;
    private String name;

    private Access accessType;
    private HashMap<String,User> members;
    private HashMap<String, Lists> projects;

    public Board(String name) {
        this.name = name;
        this.accessType = Access.PRIVATE;
        this.members = new HashMap<>();
        this.projects = new HashMap<>();
        this.boardID = UUID.randomUUID();

    }

    public Board(String name, Access accessType) {
        this.name = name;
        this.members = new HashMap<>();
        this.projects = new HashMap<>();
        this.boardID = UUID.randomUUID();
        this.accessType = accessType;

    }

    public UUID getBoardID() {
        return boardID;
    }

    public String getName() {
        return name;
    }

    public Access getAccessType() {
        return accessType;
    }

    public HashMap<String, User> getMembers() {
        return members;
    }

    public HashMap<String, Lists> getProjects() {
        return projects;
    }

    public void addMember(String userID, User member){
        this.members.put(userID,member);
    }

    public void removeMember(String userID){
        this.members.remove(userID);
    }

    public void addProject(String userID, Lists project){
        this.projects.put(userID,project);
    }

    public void removeProject(String projectID){
        this.projects.remove(projectID);
    }
}
