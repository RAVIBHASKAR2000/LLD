package main.java.org.lldProblemStatements.EcommerceWebsite;

import java.util.*;

public class InventoryManagement {
    private HashMap<Product,Integer> inventory;
    private static InventoryManagement instance;

    private InventoryManagement(){
        this.inventory = new HashMap<>();
    }

    public static InventoryManagement getInstance(){
        if(instance==null){
            instance = new InventoryManagement();
        }

        return instance;
    }

    public void addNewProduct(Product product){
        inventory.put(product,0);
    }

    public void addToProductInventory(Product product,int count){
        inventory.put(product,inventory.get(product)+count);
    }

    public void removeFromProductInventory(Product product, int count){
        inventory.put(product,inventory.get(product)-count);
    }
}
