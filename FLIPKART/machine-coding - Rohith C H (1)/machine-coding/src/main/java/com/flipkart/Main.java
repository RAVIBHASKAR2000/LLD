package com.flipkart;

import com.flipkart.model.Access;
import com.flipkart.model.Priority;
import com.flipkart.service.ServiceFactory;
import com.flipkart.service.TaskManager;
import com.flipkart.service.UserService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        TaskManager taskManager = ServiceFactory.getTaskManagerService();

        UserService userService = ServiceFactory.getUserService();


        taskManager.createBoard( "OrdersProjectBoard", Access.PUBLIC);
        userService.addUser("scott@g.in", "scott@g.in", "scott@g.in");
        userService.addUser("brett@g.in", "brett@g.in", "brett@g.in");
        userService.addUser("tina@g.in", "tina@g.in", "tina@g.in");

        taskManager.addMemberToBoard("OrdersProjectBoard", "brett@g.in");
        taskManager.addMemberToBoard("OrdersProjectBoard", "scott@g.in");

        taskManager.createProjectForBoard("OrderProjectList1", "OrdersProjectBoard");
        taskManager.createProjectForBoard("OrderProjectList2", "OrdersProjectBoard");

        taskManager.createCard("OrderProjectTask1", "OrderProjectList1", Priority.P0);
        taskManager.createCard("OrderProjectTask2", "OrderProjectList1", Priority.P1);

        taskManager.assignCardToUser("OrderProjectTask1", "brett@g.in");
        taskManager.assignCardToUser("OrderProjectTask2", "scott@g.in");

        taskManager.unassignCard("OrderProjectTask2");






    }
}