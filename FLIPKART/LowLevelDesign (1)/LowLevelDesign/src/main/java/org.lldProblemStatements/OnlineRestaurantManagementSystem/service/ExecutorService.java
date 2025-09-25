package main.java.org.lldProblemStatements.OnlineRestaurantManagementSystem.service;

import java.util.*;

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
            case "UPDATE_MENU":{
                String restaurant = tokens[1];
                String item = tokens[2];
                int newPrice = Integer.parseInt(tokens[3]);
                restaurantService.updateMenu(item,newPrice,restaurant);
                break;
            }
            case "SHOW_DISPATCH_ORDER":{
                String restaurant = tokens[1];
                restaurantService.getRestaurants().get(restaurant).displayDipatched();
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