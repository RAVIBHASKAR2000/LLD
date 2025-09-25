package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.service;

import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Item;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Restaurant;

import java.util.List;

public interface RestaurantSelectionStrategy {
    Restaurant selectRestaurant(List<Restaurant> restaurantList, List<String> items);
}

class LowestPriceStrategy implements RestaurantSelectionStrategy {
    @Override
    public Restaurant selectRestaurant(List<Restaurant> restaurants, List<String> items) {
        Restaurant bestRestaurant = null;
        int minCost = Integer.MAX_VALUE;

        for (Restaurant restaurant : restaurants) {
            if (!restaurant.checkIfItemAvailable(items)) continue; // check inventory
            if(!restaurant.validateAllItemsInOrder(items))  continue; // check menu
            if(restaurant.isRestaurantBusy())  continue; // check if busy

            int cost = 0;
            for (String item : items) {
                Item itemObject = restaurant.getMenu().getItem(item);
                cost += itemObject.getPrice();
            }

            if (cost < minCost) {
                minCost = cost;
                bestRestaurant = restaurant;
            }
        }

        return bestRestaurant;
    }
}

