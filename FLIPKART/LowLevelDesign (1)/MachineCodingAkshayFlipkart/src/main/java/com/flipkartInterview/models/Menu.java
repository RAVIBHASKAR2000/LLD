package main.java.com.flipkartInterview.models;

import java.util.HashMap;

public class Menu {
    private HashMap<String,Item> items;

    public Menu() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item){
        items.put(item.getItemName(), item);
    }

    public void removeItem(String itemName){
        items.remove(itemName);
    }

    public void updateMenu(String itemName, double price){
        items.get(itemName).setPrice(price);
    }

    public boolean validateItem(Item item){
        return items.containsKey(item.getItemName());
    }

    public void displayMenu(){
        for(Item item: items.values()){
            System.out.println(item.getItemName()+":    "+item.getPrice() +" INR");
        }
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public Item getItem(String itemName){return this.items.get(itemName);}
}
