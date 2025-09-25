package com.flipkart.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Board {

    String id;
    String boardName;
    Access access;
    HashSet<String> members;
    HashMap<String, Project> projects;


    public Board(String id, Access access) {
        this.id = id;
        this.boardName = id;
        this.access = access;
        this.members = new HashSet<>();
        this.projects = new HashMap<>();
    }

    public HashMap<String, Project> getProjects() {
        return projects;
    }

    public String getId() {
        return id;
    }


    public void addMember(String userId){
        members.add(userId);
    }

    public void removeMember(String user){
        members.remove(user);
    }

    public void addProject(String projectId){
        Project proj = new Project(projectId);
        this.projects.put(projectId, proj);
    }

    public void removeProject(String projectId){
        for(Project proj : this.projects.values()){
            if(proj.id.equals(projectId)){
                this.projects.remove(projectId);
            }
        }
    }
}
