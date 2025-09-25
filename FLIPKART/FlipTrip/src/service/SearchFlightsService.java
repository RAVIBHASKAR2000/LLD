package service;

import dto.Flight;
import dto.RouteNode;
import enums.ProBo;
import repository.InMemoryRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SearchFlightsService {

    public List<Flight> routeWithMinimumHopes(String source, String destination, List<Flight> flights) {
        Map<String, List<Flight>> flightMap = new ConcurrentHashMap<>();
        for (Flight flight : flights) {
            flightMap.computeIfAbsent(flight.getSource(), k -> new ArrayList<>()).add(flight);
        }

        Queue<List<Flight>> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        if (flightMap.containsKey(source)) {
            for (Flight flight : flightMap.get(source)) {
                List<Flight> initialRoute = new ArrayList<>();
                initialRoute.add(flight);
                queue.offer(initialRoute);
            }
            visited.add(source);
        }

        while (!queue.isEmpty()) {
            List<Flight> currentRoute = queue.poll();
            Flight lastFlight = currentRoute.get(currentRoute.size() - 1);

            if (lastFlight.getDestination().equals(destination)) {
                return currentRoute;
            }

            if (flightMap.containsKey(lastFlight.getDestination())) {
                for (Flight nextFlight : flightMap.get(lastFlight.getDestination())) {
                    if (!visited.contains(nextFlight.getDestination())) {
                        List<Flight> newRoute = new ArrayList<>(currentRoute);
                        newRoute.add(nextFlight);
                        queue.offer(newRoute);
                    }
                }
            }
            visited.add(lastFlight.getDestination());
        }

        return new ArrayList<>();
    }


        public List<Flight> cheapestRoute(String source, String destination, List<Flight> flights) {
            Map<String, List<Flight>> flightMap = new ConcurrentHashMap<>();
            for (Flight flight : flights) {
                flightMap.computeIfAbsent(flight.getSource(), k -> new ArrayList<>()).add(flight);
            }

            PriorityQueue<RouteNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.getTotalCost()));

            Map<String, Integer> minCostMap = new ConcurrentHashMap<>();

            if (flightMap.containsKey(source)) {
                for (Flight flight : flightMap.get(source)) {
                    List<Flight> initialRoute = new ArrayList<>();
                    initialRoute.add(flight);
                    pq.offer(new RouteNode(flight.getCost(), initialRoute));
                    minCostMap.put(flight.getDestination(), flight.getCost());
                }
            }

            while (!pq.isEmpty()) {
                RouteNode currentNode = pq.poll();
                List<Flight> currentRoute = currentNode.getRoute();
                Flight lastFlight = currentRoute.get(currentRoute.size() - 1);
                int currentCost = currentNode.getTotalCost();

                if (lastFlight.getDestination().equals(destination)) {
                    return currentRoute;
                }

                if (flightMap.containsKey(lastFlight.getDestination())) {
                    for (Flight nextFlight : flightMap.get(lastFlight.getDestination())) {
                        int newCost = currentCost + nextFlight.getCost();

                        if (newCost < minCostMap.getOrDefault(nextFlight.getDestination(), Integer.MAX_VALUE)) {
                            List<Flight> newRoute = new ArrayList<>(currentRoute);
                            newRoute.add(nextFlight);
                            pq.offer(new RouteNode(newCost, newRoute));
                            minCostMap.put(nextFlight.getDestination(), newCost);
                        }
                    }
                }
            }

            return new ArrayList<>();
        }





    public void filterSearch(String source, String destination, ProBo proBo){

        List<Flight> flights = InMemoryRepository.getFlightMap().entrySet().stream()
                .filter(e -> e.getValue().getProBos().contains(proBo))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println("\n * Route with Minimum Hops:\n");

        List<Flight> flightRouteWithMinimumHopes=routeWithMinimumHopes(source,destination,flights);

        int totalCost = 0;
        int totalNumberOfHopes=0;

        for (Flight flight:flightRouteWithMinimumHopes) {
            System.out.println(flight);
            totalCost+=flight.getCost();
            totalNumberOfHopes++;
        }

        System.out.println("Total Flights ="+totalNumberOfHopes);
        System.out.println("Total Cost ="+totalCost);

        System.out.println("\n * Cheapest Route:\n");

        List<Flight> flightCheapestRoute=cheapestRoute(source,destination,flights);

        totalCost = 0;
        totalNumberOfHopes=0;

        for (Flight flight:flightCheapestRoute) {
            System.out.println(flight);
            totalCost+=flight.getCost();
            totalNumberOfHopes++;
        }

        System.out.println("Total Flights ="+totalNumberOfHopes);
        System.out.println("Total Cost ="+totalCost);
    }

    public void search(String source,String destination){
        List<Flight> flights = InMemoryRepository.getFlightMap().entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        System.out.println("\n * Route with Minimum Hops:\n");

        List<Flight> flightRouteWithMinimumHopes=routeWithMinimumHopes(source,destination,flights);

        int totalCost = 0;
        int totalNumberOfHopes=0;

        for (Flight flight:flightRouteWithMinimumHopes) {
            System.out.println(flight);
            totalCost+=flight.getCost();
            totalNumberOfHopes++;
        }

        System.out.println("Total Flights ="+totalNumberOfHopes);
        System.out.println("Total Cost ="+totalCost);

        System.out.println("\n * Cheapest Route:\n");

        List<Flight> flightCheapestRoute=cheapestRoute(source,destination,flights);

        totalCost = 0;
        totalNumberOfHopes=0;

        for (Flight flight:flightCheapestRoute) {
            System.out.println(flight);
            totalCost+=flight.getCost();
            totalNumberOfHopes++;
        }

        System.out.println("Total Flights ="+totalNumberOfHopes);
        System.out.println("Total Cost ="+totalCost);
    }

}
