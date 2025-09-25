package main.java.org.lldProblemStatements.EcommerceWebsite;

import java.util.*;

public class Order {
    private List<Product> product;
    private User orderedBy;
    private OrderStatus status;
    private String address;
    private List<User> observers;

    private void notifyObservers(){
        // notify all the observers
    }

    public void updateOrderStatus(){
        notifyObservers();
    }
}
