package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.service;

import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Restaurant;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Menu;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Item;

import java.util.HashMap;

public class RestaurantService {
    private HashMap<String, Restaurant> restaurants;
    private RestaurantSelectionStrategy strategy;
    private static RestaurantService instance;

    private RestaurantService(){
        this.restaurants = new HashMap<>();
        this.strategy = new LowestPriceStrategy();
    }

    public static RestaurantService getInstance(){
        if(instance==null){
            instance = new RestaurantService();
        }
        return instance;
    }

    public void setSelectionStrategy(RestaurantSelectionStrategy strategy){
        this.strategy = strategy;
    }

    private boolean validateRestaurant(String restaurantName){
        return this.restaurants.containsKey(restaurantName);
    }


    public void updateMenu(String item, double newPrice, String restaurantName){
        if(!validateRestaurant(restaurantName)){
            System.out.println("Invalid Restaurant!");
            return;
        }

        Restaurant restaurant = restaurants.get(restaurantName);

        restaurant.updateMenu(item,newPrice);
        restaurant.displayMenu();
    }

    public void updateInventory(String restaurantName, String itemName, int count){
        if(!validateRestaurant(restaurantName)){
            System.out.println("Invalid Restaurant!");
            return;
        }

        Restaurant restaurant = restaurants.get(restaurantName);
        Item item = restaurant.getMenu().getItem(itemName);
        restaurant.addItemToInventory(item,count);
    }

    public void addItemToMenu(String restaurantName, String itemName, double price){
        if(!validateRestaurant(restaurantName)){
            System.out.println("Invalid Restaurant!");
            return;
        }

        Restaurant restaurant = restaurants.get(restaurantName);
        Menu menu = restaurant.getMenu();
        menu.addItem(new Item(itemName,price));

        restaurant.displayMenu();
    }

    public HashMap<String, Restaurant> getRestaurants() {
        return restaurants;
    }

    public RestaurantSelectionStrategy getStrategy() {
        return strategy;
    }

    public void addRestaurant(Restaurant restaurant){
        restaurants.put(restaurant.getRestaurantName(),restaurant);
    }
}
