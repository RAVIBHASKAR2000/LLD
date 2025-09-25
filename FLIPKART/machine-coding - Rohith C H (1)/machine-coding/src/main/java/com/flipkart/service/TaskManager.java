package com.flipkart.service;

import com.flipkart.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {

    private UserService userService = ServiceFactory.getUserService();
    private HashMap<String, Board> boardList;
    private HashMap<String, Project> projectList;
    private HashMap<String, Card> cardList;

    public TaskManager() {
        this.boardList = new HashMap<>();
        this.projectList = new HashMap<>();
        this.cardList = new HashMap<>();
    }

    public String createBoard(String boardId, Access acc){
        String newBoardId;
        Board newBoard = new Board(boardId, acc);
        boardList.put(boardId, newBoard);
        return newBoard.getId();

    }

    public boolean deleteBoard(String boardId, String actionByUser){
        boolean isSuccess = false;
        User user = userService.getUserById(actionByUser);
        if(boardList.containsKey(boardId)){
            boardList.remove(boardId);
            isSuccess = true;
        }

        return isSuccess;
    }

    public void viewBoard(String boardId, String viewer){
        List<String> allCards = new ArrayList<>();
        if(boardList.containsKey(boardId)){
            Board board = boardList.get(boardId);
            for(Project project : board.getProjects().values()){
                for(Card card : project.getCards()){
                    allCards.add(card.getId());
                }

            }
        }
        System.out.println("Cards in Board = " + allCards);

    }


    public boolean addMemberToBoard(String boardId, String userId){
        boolean isSuccess = false;
        User user = userService.getUserById(userId);
        if(user != null){
            if(boardList.containsKey(boardId)){
                Board board = boardList.get(boardId);
                board.addMember(userId);
                isSuccess = true;
            }
            else{
                System.out.println("Invalid BOARD");
            }
        }
        else{
            System.out.println("User is null!");
        }

        return isSuccess;
    }

    public boolean removeMemberFromBoard(String boardId, String userId){
        boolean isSuccess = false;
        User user = userService.getUserById(userId);
        if(user != null){
            if(boardList.containsKey(boardId)){
                Board board = boardList.get(boardId);
                board.removeMember(userId);
                isSuccess = true;
            }
            else{
                System.out.println("Invalid BOARD");
            }
        }
        else{
            System.out.println("User is null!");
        }

        return isSuccess;
    }

    public String createProjectForBoard(String projectId, String boardId){
        String proj = null;
        if(boardList.containsKey(boardId)) {
            Board board = boardList.get(boardId);
            board.addProject(projectId);
            proj = projectId;

        }
        return proj;
    }

    public boolean deleteProject(String projectId, String actionByUser){
        boolean isSuccess = false;
        User user = userService.getUserById(actionByUser);

        if(user != null){
            for (Board bd : boardList.values()){
                for(Project proj : bd.getProjects().values()){
                    if(proj.getId().equals(projectId)){
                        bd.removeProject(projectId);
                        return true;
                    }
                }
            }
        }
        else{
            System.out.println("User is null!");
        }

        return isSuccess;
    }

    public String createCard(String id, String projectId, Priority p){
        Card card  = new Card(id, id, p, projectId);
        String cardId = null;
        for (Board bd : boardList.values()){
            for(Project proj : bd.getProjects().values()){
                if(proj.getId().equals(projectId)){
                    proj.addCard(card);
                    cardId = card.getId();
                }
            }
        }
        return cardId;

    }

    public String assignCardToUser(String cardId, String userId ){
        String user = null;
        if(cardList.containsKey(cardId)){
            cardList.get(cardId).setAssignedUser(userId);
            user = userId;

        }
        return user;
    }

    public boolean unassignCard(String cardId){
        boolean isSuccess = false;

        if(cardList.containsKey(cardId)){
            cardList.remove(cardId);
            isSuccess = true;
        }

        return isSuccess;
    }

//    public boolean moveCard(String fromProjectId, String ToProjectId){
//
//    }

    public void deleteCard(String cardId, String actionByUser){
        // print message
        cardList.remove(cardId);
    }










}
