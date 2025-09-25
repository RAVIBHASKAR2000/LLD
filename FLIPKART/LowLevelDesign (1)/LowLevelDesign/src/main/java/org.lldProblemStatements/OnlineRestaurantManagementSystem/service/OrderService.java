package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.service;

import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Item;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Order;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.OrderStatus;
import main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.models.Restaurant;

import java.util.HashMap;
import java.util.List;

public class OrderService {
    private HashMap<String, Order> orders;
    private RestaurantService restaurantService;
    private static OrderService instance;

    private OrderService(){
        this.orders = new HashMap<>();
        restaurantService = RestaurantService.getInstance();
    }

    public static OrderService getInstance(){
        if(instance==null){
            instance = new OrderService();
        }
        return instance;
    }

    public void dispatchOrder(String orderID){
        if(!orders.containsKey(orderID)){
            System.out.println("Invalid orderID");
            return;
        }
        Order order = orders.get(orderID);

        if(order.getStatus().equals(OrderStatus.DISPATCHED)){
            System.out.println("Order is already dispatched!");
            return;
        }

        order.dispatchOrder();
        order.displayAboutOrder();
    }

    public void placeOrder(List<String> orderItems, String orderID){
        if(orders.containsKey(orderID)){
            System.out.println("Duplicate orderID!");
            return;
        }

        HashMap<String, Restaurant> restaurantMap = restaurantService.getRestaurants();

        if(restaurantMap.size()==0){
            System.out.println("No restaurant available");
            return;
        }

        List<Restaurant> restaurantList = restaurantMap.values().stream().toList();
        Restaurant restaurant = restaurantService.getStrategy().selectRestaurant(restaurantList, orderItems);

        if(restaurant==null){
            System.out.println("Unable to find a valid restaurant");
            return;
        }

        List<Item> orderItemsObject = orderItems.stream().map(item-> restaurant.getMenu().getItem(item)).toList();

        Order newOrder = new Order(orderID,restaurant,orderItemsObject);

        restaurant.acceptOrder(newOrder);
        orders.put(orderID,newOrder);
        newOrder.displayAboutOrder();
    }
}
