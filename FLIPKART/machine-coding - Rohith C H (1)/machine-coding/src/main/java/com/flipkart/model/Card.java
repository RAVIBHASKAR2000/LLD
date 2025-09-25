package com.flipkart.model;

public class Card {
    String id;
    String cardName;
    String assignedUser;
    Priority prio;
    String projectId;

    public Card(String id, String cardName, Priority prio, String projectId) {
        this.id = id;
        this.cardName = cardName;
        this.prio = prio;
        this.projectId = projectId;
    }

    public String getId() {
        return id;
    }

    public Priority getPrio() {
        return prio;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }
}
