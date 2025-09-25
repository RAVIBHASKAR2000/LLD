package main.java.com.flipkartInterview.models;

import java.util.HashMap;

public class RestaurantInventory {
    private HashMap<String, Integer> inventory;

    public RestaurantInventory() {
        this.inventory = new HashMap<>();
    }

    public void addItem(String item, int count){
        if(inventory.containsKey(item)){
            inventory.put(item, inventory.get(item)+count);
        }
        else{
            inventory.put(item,count);
        }
    }

    public boolean itemAvailable(String item, int count){
        return inventory.getOrDefault(item,0)>=count;
    }

    public void removeItem(String item, int count){
        if(inventory.containsKey(item)){
            if(itemAvailable(item,count)) {
                inventory.put(item, inventory.get(item)-count);
            }
            else{
                System.out.println("Not enough item in the inventory!");
            }
        }
        else{
            inventory.put(item,count);
        }
    }
}
