package main.java.com.flipkartInterview;

import main.java.com.flipkartInterview.models.Item;
import main.java.com.flipkartInterview.models.Menu;
import main.java.com.flipkartInterview.models.Restaurant;
import main.java.com.flipkartInterview.models.RestaurantInventory;
import main.java.com.flipkartInterview.services.ExecutorService;
import main.java.com.flipkartInterview.services.RestaurantService;

public class Main {
    public static void main(String[] args){
        RestaurantService restaurantService = RestaurantService.getInstance();

        Item item1 = new Item("Burger", 150);
        Item item2 = new Item("Fries", 80);
        Item item3 = new Item("Cold Drink", 40);
        Item item4 = new Item("Pizza", 200);
        Item item5 = new Item("Burger", 100);
        Item item6 = new Item("Fries", 40);

        Menu menu1 = new Menu();
        menu1.addItem(item1);
        menu1.addItem(item2);
        menu1.addItem(item3);

        Menu menu2 = new Menu();
        menu2.addItem(item3);
        menu2.addItem(item4);

        Menu menu3 = new Menu();
        menu3.addItem(item5);
        menu3.addItem(item6);

        RestaurantInventory inventory1 = new RestaurantInventory();
        inventory1.addItem("Burger",5);
        inventory1.addItem("Fries",5);
        inventory1.addItem("Cold Drink",5);

        RestaurantInventory inventory2 = new RestaurantInventory();
        inventory2.addItem("Cold Drink",5);
        inventory2.addItem("Pizza",5);

        RestaurantInventory inventory3 = new RestaurantInventory();
        inventory3.addItem("Burger",5);
        inventory3.addItem("Fries",5);

//        Restaurant restaurant1 = new Restaurant("rest1", menu1,2,inventory1);
        Restaurant restaurant2 = new Restaurant("rest2", menu2,2,inventory2);
        Restaurant restaurant3 = new Restaurant("rest3", menu3,2,inventory3);

//        restaurantService.addRestaurant(restaurant1);
        restaurantService.addRestaurant(restaurant2);
        restaurantService.addRestaurant(restaurant3);

        // task executor
        ExecutorService executorService = ExecutorService.getInstance();

        executorService.addCommand("2,PLACE_ORDER,order3,Fries,Burger,Burger");
        executorService.addCommand("3,SHOW_MENU,rest2");
        executorService.addCommand("12,DISPATCH_ORDER,order1");
        executorService.addCommand("6,UPDATE_PRICE,rest1,Burger,200");
        executorService.addCommand("5,SHOW_MENU,rest2");
        executorService.addCommand("11,PLACE_ORDER,order2,Burger,Fries");
        executorService.addCommand("9,PLACE_ORDER,order4,Burger");
        executorService.addCommand("7,PLACE_ORDER,order1,Burger");
        executorService.addCommand("4,UPDATE_ITEM_NAME,rest2,Cold Drink,Coke Cola");
        executorService.addCommand("8,PLACE_ORDER,order99,invalid");
        executorService.addCommand("1,ONBOARD_RESTAURANT,rest1,2,Menu,Burger,100,Fries,40,Inventory,Burger,5,Fries,5");
        executorService.addCommand("10,PLACE_ORDER,order3,Fries");
        executorService.addCommand("13,SHOW_DISPATCH_ORDER");

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
