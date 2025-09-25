package com.flipkart.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    String id;
    String projectName;
    List<Card> cards;
    String boardId;

    public Project(String id) {
        this.id = id;
        this.projectName = id;
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getId() {
        return id;
    }

    public String getBoardId() {
        return boardId;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }
}
