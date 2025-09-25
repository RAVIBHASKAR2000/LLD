package main.java.com.flipkartInterview.services;

import main.java.com.flipkartInterview.models.Item;
import main.java.com.flipkartInterview.models.Restaurant;

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
            if (!restaurant.checkIfItemAvailable(items)) continue;
            if(!restaurant.validateAllItemsInOrder(items))  continue;
            if(!restaurant.canProcessOrder(items.size()))  continue;

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
