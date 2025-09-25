package main.java.com.flipkartInterview.services;

import main.java.com.flipkartInterview.models.Item;
import main.java.com.flipkartInterview.models.Menu;
import main.java.com.flipkartInterview.models.Restaurant;
import main.java.com.flipkartInterview.models.RestaurantInventory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ExecutorService {
    private final RestaurantService restaurantService;
    private final OrderService orderService;
    private final PriorityQueue<CommandWrapper> commandQueue;
    private long sequence = 0;
    private static ExecutorService instance;

    private ExecutorService() {
        this.restaurantService = RestaurantService.getInstance();
        this.orderService = OrderService.getInstance();
        this.commandQueue = new PriorityQueue<>(Comparator.comparingInt(CommandWrapper::getPriority).thenComparingLong(CommandWrapper::getSequence));
    }

    public static ExecutorService getInstance(){
        if(instance==null){
            instance = new ExecutorService();
        }
        return instance;
    }

    public void addCommand(String commandLine) {
        String[] parts = commandLine.split(",", 2);

        int priority = Integer.parseInt(parts[0]);
        commandQueue.offer(new CommandWrapper(priority, sequence++, parts[1]));
    }

    public void executeAll() {
        while (!commandQueue.isEmpty()) {
            CommandWrapper cmd = commandQueue.poll();
            executeCommand(cmd.getCommand());
        }
    }

    private void executeCommand(String commandLine) {
        String[] tokens = commandLine.split(",");
        String command = tokens[0];

        switch (command) {
            case "ONBOARD_RESTAURANT":{
                String restaurantName = tokens[1];
                int maxProcessingCapacity = Integer.parseInt(tokens[2]);
                if(tokens[3].equals("Menu")){
                    Menu menu = new Menu();
                    int i=4;
                    while(!tokens[i].equals("Inventory")){
                        Item item = new Item(tokens[i],Integer.parseInt(tokens[i+1]));
                        menu.addItem(item);
                        i+=2;
                    }
                    i++;
                    RestaurantInventory inventory = new RestaurantInventory();
                    while(i<tokens.length){
                        inventory.addItem(tokens[i],Integer.parseInt(tokens[i+1]));
                        i+=2;
                    }
                    Restaurant restaurant = new Restaurant(restaurantName,menu,maxProcessingCapacity,inventory);
                    restaurantService.addRestaurant(restaurant);
                }
                break;
            }
            case "SHOW_MENU": {
                String restaurantName = tokens[1];
                restaurantService.getRestaurants().get(restaurantName).displayMenu();
                break;
            }
            case "PLACE_ORDER": {
                String orderId = tokens[1];
                List<String> items = new ArrayList<>();
                for (int i = 2; i < tokens.length; i++) {
                    items.add(tokens[i]);
                }
                orderService.placeOrder(items,orderId);
                break;
            }
            case "DISPATCH_ORDER": {
                String orderId = tokens[1];
                orderService.dispatchOrder(orderId);
                break;
            }
            case "UPDATE_PRICE":{
                String restaurant = tokens[1];
                String item = tokens[2];
                int newPrice = Integer.parseInt(tokens[3]);
                restaurantService.updateMenu(item,newPrice,restaurant);
                break;
            }
            case "UPDATE_ITEM_NAME":{
                Restaurant restaurant = restaurantService.getRestaurants().get(tokens[1]);
                restaurant.updateItemName(tokens[2],tokens[3]);
                break;
            }
            case "SHOW_DISPATCH_ORDER":{
                for(Restaurant restaurant: restaurantService.getRestaurants().values()){
                    restaurant.displayDispatched();
                }
                break;
            }
            default:
                System.out.println("Unknown command");
        }
    }

    private static class CommandWrapper {
        private final int priority;
        private final long sequence;
        private final String command;

        public CommandWrapper(int priority, long sequence, String command) {
            this.priority = priority;
            this.sequence = sequence;
            this.command = command;
        }

        public int getPriority() {
            return priority;
        }

        public long getSequence() {
            return sequence;
        }

        public String getCommand() {
            return command;
        }
    }
}
