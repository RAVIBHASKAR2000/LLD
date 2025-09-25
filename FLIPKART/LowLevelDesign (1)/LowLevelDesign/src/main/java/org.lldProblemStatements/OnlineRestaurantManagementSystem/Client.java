package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem;

import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Item;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Menu;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Restaurant;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.RestaurantInventory;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.service.ExecutorService;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.service.OrderService;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.service.RestaurantService;

import java.util.List;

public class Client {
    public static void main(String[] args){
        RestaurantService restaurantService = RestaurantService.getInstance();
        OrderService orderService = OrderService.getInstance();

        Item item1 = new Item("Burger", 150);
        Item item2 = new Item("Fries", 80);
        Item item3 = new Item("Cold Drink", 40);
        Item item4 = new Item("Pizza", 200);
        Item item5 = new Item("Burger", 100);
        Item item6 = new Item("Fries", 40);

        Menu menu1 = new Menu();
        menu1.addItem(item1);
        menu1.addItem(item2);

        Menu menu2 = new Menu();
        menu2.addItem(item3);
        menu2.addItem(item4);

        Menu menu3 = new Menu();
        menu3.addItem(item5);
        menu3.addItem(item6);

        RestaurantInventory inventory1 = new RestaurantInventory();
        inventory1.addItem(item1,2);
        inventory1.addItem(item2,4);

        RestaurantInventory inventory2 = new RestaurantInventory();
        inventory2.addItem(item3,2);
        inventory2.addItem(item4,4);

        RestaurantInventory inventory3 = new RestaurantInventory();
        inventory3.addItem(item5,2);
        inventory3.addItem(item6,4);

        Restaurant restaurant1 = new Restaurant("rest1", menu1,2,inventory1);
        Restaurant restaurant2 = new Restaurant("rest2", menu2,2,inventory2);
        Restaurant restaurant3 = new Restaurant("rest3", menu3,2,inventory3);

        restaurantService.addRestaurant(restaurant1);
        restaurantService.addRestaurant(restaurant2);
        restaurantService.addRestaurant(restaurant3);

        // task executor
        ExecutorService executorService = ExecutorService.getInstance();

        executorService.addCommand("5,PLACE_ORDER,order2,Burger,Fries");
        executorService.addCommand("2,UPDATE_MENU,rest1,Burger,50");
        executorService.addCommand("8,DISPATCH_ORDER,order2");
        executorService.addCommand("5,PLACE_ORDER,order3,Fries");
        executorService.addCommand("3,PLACE_ORDER,order1,Burger");
        executorService.addCommand("9,SHOW_DISPATCH_ORDER,rest1");

        executorService.executeAll();

//        orderService.placeOrder(List.of("Burger","Fries"),"order1"); //place order
//        orderService.placeOrder(List.of("Burger","Fries"),"order2");
//        orderService.placeOrder(List.of("Burger","Fries"),"order3");
//        orderService.dispatchOrder("order1"); //dispatch order
//        restaurantService.updateMenu("Fries",100,"rest1"); // update price
//        orderService.placeOrder(List.of("Burger","Fries"),"order4");
//        orderService.placeOrder(List.of("Burger","Fries"),"order5");
//        orderService.placeOrder(List.of("Burger","Fries"),"order6");
//        orderService.placeOrder(List.of("Cold Drink","Pizza"),"order7");

    }
}
