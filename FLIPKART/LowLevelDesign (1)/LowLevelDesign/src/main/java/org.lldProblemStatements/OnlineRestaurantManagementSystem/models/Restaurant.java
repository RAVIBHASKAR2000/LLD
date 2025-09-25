package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models;

import java.util.*;

public class Restaurant {
    private final String restaurantName;
    private final Menu menu;
    private final int maxProcessingCapacity;
    private List<Order> orderProcessingList;
    private List<Order> orderDispatchedList;
    private boolean isRestaurantBusy;
    private final RestaurantInventory inventory;

    public Restaurant(String restaurantName,Menu menu, int maxProcessingCapacity, RestaurantInventory inventory){
        this.maxProcessingCapacity = maxProcessingCapacity;
        this.menu = menu;
        this.orderProcessingList = new ArrayList<>();
        this.orderDispatchedList = new ArrayList<>();
        this.inventory = inventory;
        this.restaurantName =restaurantName;
        this.isRestaurantBusy = false;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getMaxProcessingCapacity() {
        return maxProcessingCapacity;
    }

    public void updateMenu(String itemName, double amount){
        menu.updateMenu(itemName,amount);
    }

    public void removeItemFromMenu(String itemName){
        menu.removeItem(itemName);
    }

    public void addItemToInventory(Item item, int count){
        inventory.addItem(item,count);
    }

    public boolean checkIfItemAvailable(List<String> orderItems){
        for(String item: orderItems){
            if(!inventory.itemAvailable(menu.getItem(item),1)){
                return false;
            }
        }

        return true;
    }

    public boolean validateAllItemsInOrder(List<String> orderItems){
        for(String item: orderItems){
            if(!menu.validateItem(menu.getItem(item))){
                return false;
            }
        }

        return true;
    }

    public void acceptOrder(Order order){
        this.orderProcessingList.add(order);
        if(orderProcessingList.size()==maxProcessingCapacity){
            isRestaurantBusy = true;
        }
    }

    public void update(Order order){
        orderProcessingList.remove(order);
        orderDispatchedList.add(order);
        isRestaurantBusy = false;
        System.out.println("Order "+order.getOrderID()+" was dispatched");
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void displayMenu(){
        System.out.println("Menu of "+this.restaurantName);
        menu.displayMenu();
    }

    public void displayDipatched(){
        System.out.println("Dispatched orders of "+restaurantName);
        for(Order order:orderDispatchedList){
            System.out.println(order.getOrderID());
        }
    }

    public boolean isRestaurantBusy() {
        return isRestaurantBusy;
    }
}
