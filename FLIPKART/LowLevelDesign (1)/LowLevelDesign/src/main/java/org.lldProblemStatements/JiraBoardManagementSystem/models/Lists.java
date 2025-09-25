package main.java.org.lldProblemStatements.JiraBoardManagementSystem.models;

import java.util.HashMap;
import java.util.UUID;

public class Lists {
    private final UUID projectID;
    private String projectName;
    private HashMap<String, Card> memberTasks;

    public Lists(String projectName){
        this.projectID = UUID.randomUUID();
        this.projectName = projectName;
        this.memberTasks = new HashMap<>();
    }

    public UUID getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public HashMap<String, Card> getMemberTasks() {
        return memberTasks;
    }

    public void addTask(Card card){
        memberTasks.put(card.getCardID().toString(),card);
    }

    public void removeTask(String taskID){
        this.memberTasks.remove(taskID);
    }

    public void updateProjectName(String newProjectName){
        this.projectName = newProjectName;
    }
}
