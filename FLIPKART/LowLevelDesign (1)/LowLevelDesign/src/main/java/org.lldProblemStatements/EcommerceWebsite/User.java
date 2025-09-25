package main.java.org.lldProblemStatements.EcommerceWebsite;

import java.util.*;

public class User {
    private ShoppingCart cart;
    private List<Order> orders;

    public void addItemToCart(Product product){
        cart.addItem(product);
    }



}
