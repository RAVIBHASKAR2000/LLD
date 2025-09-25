package org.example;

import java.util.*;

public class SearchEngine {
    private static SearchEngine searchEngine;
    private SearchEngine(){};
    public static SearchEngine getSearchEngine() {
        if(searchEngine == null) {
            searchEngine = new SearchEngine();
        }
        return searchEngine;
    }

     public void search(final Map<City,List<Pair<City, Integer>>>flightMap,final City start, final City end, final  boolean isMealRequired) {
         System.out.println("Route with minimum Hop");
         minHopPath(flightMap,start,end);
         int price = calculatePrice(flightMap,start,end);
         System.out.printf("Minimum price flight $%.2f%n", price);
     }

    private int calculatePrice(Map<City, List<Pair<City, Integer>>> flightMap, City start, City end) {
        Map<City, Integer> costMap = null;
        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(costMap::get));
        costMap = new HashMap<>();

        costMap.put(start, 0);
        pq.offer(start);

        while (!pq.isEmpty()) {
            City currentCity = pq.poll();

            // Check if we have reached the destination
            if (currentCity.equals(end)) {
                return costMap.get(end); // Return the lowest price
            }

            // Explore neighbors
            for (Pair<City, Integer> neighbor : flightMap.getOrDefault(currentCity, Collections.emptyList())) {
                City neighborCity = neighbor.getFirst();
                int neighborCost = neighbor.getSecond();
                int totalCost = costMap.getOrDefault(currentCity, Integer.MAX_VALUE) + neighborCost;

                if (!costMap.containsKey(neighborCity) || totalCost < costMap.get(neighborCity)) {
                    costMap.put(neighborCity, totalCost);
                    pq.offer(neighborCity);
                }
            }
        }
        return -1;
    }


    private void minHopPath(final Map<City,List<Pair<City, Integer>>>flightMap,final City start, final City end) {
        Queue<City> queue = new LinkedList<>();
        Map<City, City> parentMap = new HashMap<>();
        Set<City> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            City currentCity = queue.poll();

            // Check if we have reached the destination
            if (currentCity.equals(end)) {
                printPath(parentMap, start, end);
            }

            // Explore neighbors
            for (Pair<City, Integer> neighbor : flightMap.getOrDefault(currentCity, Collections.emptyList())) {
                City neighborCity = neighbor.getFirst();
                if (!visited.contains(neighborCity)) {
                    visited.add(neighborCity);
                    parentMap.put(neighborCity, currentCity);
                    queue.add(neighborCity);
                }
            }
        }

    }

    private void printPath(Map<City, City> parentMap, City start, City end) {
        for (City at = end; at != null; at = parentMap.get(at)) {
            System.out.print(at.getCityName() + " " + "->");
        }
    }


}
