package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final String orderID;
    private final Restaurant restaurant;
    private double totalAmount;
    private OrderStatus status;
    private List<Item> items;


    public Order(String orderID, Restaurant restaurant, List<Item> items) {
        this.orderID = orderID;
        this.restaurant = restaurant;
        this.items = items;
        this.status = OrderStatus.PROCESSING;
        this.totalAmount = 0;
        for(Item item:items){
            this.totalAmount += item.getPrice();
        }
    }

    public String getOrderID() {
        return orderID;
    }

    public OrderStatus getStatus() {
        return status;
    }

    private void notifyRestaurant(){
        restaurant.update(this);
    }

    public void dispatchOrder(){
        this.status = OrderStatus.DISPATCHED;
        notifyRestaurant();
    }

    public void displayAboutOrder(){
        System.out.println("Order " +orderID+ " successfully place in "+restaurant.getRestaurantName()+" total order value is: "+this.totalAmount);
    }
}
