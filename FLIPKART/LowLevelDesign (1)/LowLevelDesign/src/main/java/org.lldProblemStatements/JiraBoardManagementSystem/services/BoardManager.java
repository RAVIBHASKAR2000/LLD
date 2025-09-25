package main.java.org.lldProblemStatements.JiraBoardManagementSystem.services;

import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.Board;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.Access;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.Lists;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.User;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.Card;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.Priority;

import java.beans.PropertyEditor;
import java.util.*;

public class BoardManager {
    private HashMap<String, Board> boards; // boardName -> board object mapping

    private UserManagement userManagement;
    private HashMap<String, Lists> lists; // ListName -> list object mapping
    private HashMap<String, Card> cards; // CardName -> card Object mapping
    private static BoardManager instance;

    private BoardManager(){
        this.boards = new HashMap<>();
        this.userManagement = UserManagement.getInstance();
        this.lists = new HashMap<>();
        this.cards = new HashMap<>();
    }

    public static BoardManager getInstance(){
        if(instance==null){
            instance = new BoardManager();
        }
        return instance;
    }

    public void createBoard(String boardName, Access accessType){
        Board newBoard = new Board(boardName,accessType);
        boards.put(boardName,newBoard);

        System.out.println("Successfully created board with id: "+newBoard.getBoardID());
    }

    public void addMember(String boardName, String userName){
        // check if the user exists
        User user;
        if(this.userManagement.getUser(userName)==null){
            System.out.println("No user found!");
            return;
        }
        else{
            user = this.userManagement.getUser(userName);
        }

        // check if the board exists
        Board board;

        if(this.boards.containsKey(boardName)){
            board = this.boards.get(boardName);
        }
        else{
            System.out.println("No Board found!");
            return;
        }

        board.addMember(user.getUserID().toString(),user);

        System.out.println("User "+ userName+" successfully added!");
    }

    public void removeMember(String boardName, String userName){
        User user;
        if(this.userManagement.getUser(userName)==null){
            System.out.println("No user found!");
            return;
        }
        else{
            user = this.userManagement.getUser(userName);
        }

        Board board;

        if(this.boards.containsKey(boardName)){
            board = this.boards.get(boardName);
        }
        else{
            System.out.println("No Board found!");
            return;
        }

        board.removeMember(user.getUserID().toString());
        System.out.println("User "+userName+" removed from the board successfully!");
    }

    private void removeList(Lists list){
        for(Card card: list.getMemberTasks().values()){
            this.cards.remove(card.getName());
        }

        lists.remove(list.getProjectName());
    }

    private void removeAllLists(Board board){
        for(Lists list: board.getProjects().values()){
            removeList(list);
        }
    }

    public void deleteBoard(String boardName) {
        Board board = this.boards.get(boardName);

        if(!this.boards.containsKey(boardName)){
            System.out.println("Failed to delete the board");
            System.out.println("No board Exists!");
            return;
        }

        removeAllLists(board);
        this.boards.remove(boardName);
        System.out.println("Successfully deleted the board");
    }

    public void createList(String projectName, String boardName){
        // check if the board exists or not

        Board board = boards.get(boardName);

        Lists newList = new Lists(projectName);
        this.lists.put(projectName,newList);

        System.out.println("Created new project: "+ newList.getProjectID());
    }

    public void deleteList(String projectName){
        // add a check for validity of the projectName
        Lists list = lists.get(projectName);

        removeList(list);
        lists.remove(projectName);

        System.out.println("Successfully removed the project");
    }

    public void createCard(String cardName, String projectName, Priority priority){
        Lists list = lists.get(projectName);

        Card newCard = new Card(cardName, priority);
        cards.put(cardName, newCard);

        System.out.println("Successfully created a new card! "+newCard.getCardID());
    }

    public void deleteCard(String cardName){
        // check if the cardName is valid

        cards.remove(cardName);
        System.out.println("Successfully removed the card");
    }

    public void assignCard(String userName, String cardName){
        // check if the user is valid
        // check if the card is valid

        User user = userManagement.getUser(userName);
        Card card = cards.get(cardName);

        card.setAssignedUser(user);
    }

    public void unassignCard(String cardName){
        // check if card is valid
        Card card = cards.get(cardName);
        card.unAssignUser();
    }

    public void moveCardToAnotherProject(String pp, String pa, String cardName, String userName){
        // check if both of them are valid or not

        Lists p1 = lists.get(pp);
        Lists p2 = lists.get(pa);
        Card card = cards.get(cardName);

        p1.removeTask(card.getCardID().toString());
        p2.addTask(card);

        System.out.println("Successfully moved card from one project to another");
    }

    public void deleteUser(String userName){
        userManagement.removeUser(userName);
    }

    public void displayBoard(String boardName, String userName){
        // check if the board is valid
        Board board = boards.get(boardName);
        List<Card> cards = new ArrayList<>();
        for(Lists list: board.getProjects().values()){
            for(Card card: list.getMemberTasks().values()){
                cards.add(card);
            }
        }

        for(Card card: cards){
            System.out.println("Card: "+card.getName());
        }
    }
}
