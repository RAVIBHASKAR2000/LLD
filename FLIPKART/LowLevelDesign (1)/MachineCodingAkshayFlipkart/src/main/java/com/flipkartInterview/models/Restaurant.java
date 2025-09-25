package main.java.com.flipkartInterview.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String restaurantName;
    private final Menu menu;
    private final int maxProcessingCapacity;
    private int currentItemsProcessing;
    private List<Order> orderProcessingList;
    private List<Order> orderDispatchedList;
    private final RestaurantInventory inventory;

    public Restaurant(String restaurantName,Menu menu, int maxProcessingCapacity, RestaurantInventory inventory){
        this.maxProcessingCapacity = maxProcessingCapacity;
        this.menu = menu;
        this.orderProcessingList = new ArrayList<>();
        this.orderDispatchedList = new ArrayList<>();
        this.inventory = inventory;
        this.restaurantName =restaurantName;
        this.currentItemsProcessing = 0;
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

    public void updateItemName(String oldItemName, String newItemName){
        if(!menu.getItems().containsKey(oldItemName)){
            System.out.println("No item exists!");
            return;
        }
        Item item = menu.getItem(oldItemName);
        menu.removeItem(oldItemName);
        item.setItemName(newItemName);
        menu.addItem(item);
    }

    public void removeItemFromMenu(String itemName){
        menu.removeItem(itemName);
    }

    public void addItemToInventory(Item item, int count){
        inventory.addItem(item.getItemName(),count);
    }

    public boolean checkIfItemAvailable(List<String> orderItems){
        for(String item: orderItems){
            if(!inventory.itemAvailable(item,1)){
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

    public boolean canProcessOrder(int itemCount){
        if(this.currentItemsProcessing+itemCount>this.maxProcessingCapacity){
            return false;
        }
        else{
            return true;
        }
    }

    public void acceptOrder(Order order){
        this.orderProcessingList.add(order);
        currentItemsProcessing += order.getOrderItemCount();
    }

    public void update(Order order){
        orderProcessingList.remove(order);
        orderDispatchedList.add(order);
        currentItemsProcessing -= order.getOrderItemCount();
        if(currentItemsProcessing<0){
            currentItemsProcessing = 0;
        }
        System.out.println("Restaurant Notification: Order "+order.getOrderID()+" dispatched");
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void displayMenu(){
        System.out.println("Menu of "+this.restaurantName);
        menu.displayMenu();
    }

    public void displayDispatched(){
        System.out.println("Dispatched orders of "+restaurantName);
        for(Order order:orderDispatchedList){
            System.out.println(order.getOrderID());
        }
    }

}
