package main.java.org.lldProblemStatements.JiraBoardManagementSystem;

import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.Access;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.models.Priority;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.services.BoardManager;
import main.java.org.lldProblemStatements.JiraBoardManagementSystem.services.UserManagement;

public class Client {
    public static void main(String[] args){
        BoardManager taskManager = BoardManager.getInstance();
        UserManagement userManagement = UserManagement.getInstance();

        taskManager.createBoard("OrdersProjectBoard", Access.PUBLIC);
        taskManager.createBoard("SupplyProjectBoard", Access.PRIVATE);
        taskManager.createBoard("AndroidProjectBoard", Access.PUBLIC);

        userManagement.create("Scott","scott@g.in");
        userManagement.create("Brett","brett@g.in");
        userManagement.create("Tina","tina@g.in");
        userManagement.create("Chan","chan@g.in");
        userManagement.create("Thor","thor@g.in");

        taskManager.addMember("OrdersProjectBoard","Scott");
        taskManager.addMember("SupplyProjectBoard","Brett");

        taskManager.deleteBoard("SupplyProjectBoard");

        taskManager.createList("OrderProjectList1","OrdersProjectBoard");
        taskManager.createList("OrderProjectList2","OrdersProjectBoard");
        taskManager.createList("SupplyProjectList1","SupplyProjectBoard");
        taskManager.createList("AndroidProjectList1","AndroidProjectBoard");
        taskManager.createList("AndroidProjectList2","AndroidProjectBoard");
        taskManager.createList("AndroidProjectList3","AndroidProjectBoard");

        taskManager.deleteList("SupplyProjectList1");

        taskManager.createCard("OrderProjectTask1", "OrderProjectList1", Priority.P0);
        taskManager.createCard("OrderProjectTask2", "OrderProjectList1", Priority.P2);
        taskManager.createCard("OrderProjectTask3", "OrderProjectList2", Priority.P1);
        taskManager.createCard("OrderProjectTask4", "OrderProjectList2", Priority.P1);
        taskManager.createCard("OrderProjectTask5", "OrderProjectList1", Priority.P0);

        taskManager.assignCard("Scott","OrderProjectTask4");
        taskManager.unassignCard("OrderProjectTask4");

        taskManager.deleteCard("OrderProjectTask4");

        taskManager.displayBoard("OrdersProjectBoard","Scott");

        userManagement.removeUser("Scott");

        taskManager.moveCardToAnotherProject("SupplyProjectBoard","OrdersProjectBoard","OrderProjectTask1","Scott");
    }
}
