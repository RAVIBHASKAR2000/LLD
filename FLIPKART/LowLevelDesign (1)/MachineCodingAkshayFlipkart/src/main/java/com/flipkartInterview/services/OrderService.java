package main.java.com.flipkartInterview.services;

import main.java.com.flipkartInterview.models.Item;
import main.java.com.flipkartInterview.models.Order;
import main.java.com.flipkartInterview.models.OrderStatus;
import main.java.com.flipkartInterview.models.Restaurant;

import javax.sound.midi.SysexMessage;
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
    }

    public void placeOrderWithRestaurant(List<String> orderItems, String orderID, String restaurantName){
        if(orders.containsKey(orderID)){
            System.out.println("Duplicate orderID!");
            return;
        }

        if(!restaurantService.getRestaurants().containsKey(restaurantName)){
            System.out.println("Invalid restaurant name");
            return;
        }

        Restaurant restaurant = restaurantService.getRestaurants().get(restaurantName);

        if(!restaurant.canProcessOrder(orderItems.size())){
            System.out.println("No processing capacity");
            return;
        }

        if(!restaurant.validateAllItemsInOrder(orderItems)){
            System.out.println("Invalid item in order");
            return;
        }

        if(!restaurant.checkIfItemAvailable(orderItems)){
            System.out.println("Item not available at restaurant");
            return;
        }

        List<Item> orderItemsObject = orderItems.stream().map(item-> restaurant.getMenu().getItem(item)).toList();

        Order newOrder = new Order(orderID,restaurant,orderItemsObject);

        restaurant.acceptOrder(newOrder);
        orders.put(orderID,newOrder);
        newOrder.displayAboutOrder();
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

        List<Restaurant> restaurantList = restaurantMap.values().stream().filter(r->r.canProcessOrder(orderItems.size())).toList();

        if(restaurantList.size()==0){
            System.out.println("No restaurant available with this capacity");
            return;
        }

        Restaurant restaurant = restaurantService.getStrategy().selectRestaurant(restaurantList, orderItems);

        if(restaurant==null){
            System.out.println("Unable to find a valid restaurant with the requirements");
            return;
        }

        List<Item> orderItemsObject = orderItems.stream().map(item-> restaurant.getMenu().getItem(item)).toList();

        Order newOrder = new Order(orderID,restaurant,orderItemsObject);

        restaurant.acceptOrder(newOrder);
        orders.put(orderID,newOrder); // db call

        newOrder.displayAboutOrder();
    }
}
