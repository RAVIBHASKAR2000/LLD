package org.example.airlinesystem.search;

import org.example.airlinesystem.extraservice.Service;
import org.example.airlinesystem.model.Airline;
import org.example.airlinesystem.model.City;
import org.example.airlinesystem.model.FlightDetails;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FlightDetailsGraph {
    private Map<String, City> cities;

    public FlightDetailsGraph(){
        cities = new ConcurrentHashMap<>();
    }

    public void addCity(City city){
        cities.put(city.getName(), city);
    }

    public City getCity(String name){
        return cities.get(name);
    }

    public synchronized void addFlight(String srcCity, String destinationCity, int price, Airline airline, Set<Service> services){
        City sourceCity = getCity(srcCity);
        City destCity = getCity(destinationCity);
        FlightDetails flightDetails = new FlightDetails(sourceCity, destCity, price, airline, services);
        sourceCity.addFlight(flightDetails);
    }

    public List<FlightDetails> findOptimalPath(String src, String dest) {
        PriorityQueue<FlightPath> queue = new PriorityQueue<>(Comparator
                .comparingInt(FlightPath::getTotalCost)
                .thenComparingInt(FlightPath::getNumberOfHops));
        Map<City, FlightPath> bestPathMap = new ConcurrentHashMap<>();

        City srcCity = getCity(src);
        City destCity = getCity(dest);
        queue.add(new FlightPath());

        while (!queue.isEmpty()) {
            FlightPath currentPath = queue.poll();
            City currentCity = currentPath.getLastCity();

            if(currentCity == null){
                currentCity = srcCity;
            }
            if (currentCity.equals(destCity)) {
                return currentPath.getFlights();
            }

            if (bestPathMap.containsKey(currentCity)) {
                FlightPath bestPath = bestPathMap.get(currentCity);
                if (currentPath.getTotalCost() > bestPath.getTotalCost() ||
                        (currentPath.getTotalCost() == bestPath.getTotalCost() && currentPath.getNumberOfHops() >= bestPath.getNumberOfHops())) {
                    continue;
                }
            }

            bestPathMap.put(currentCity, currentPath);

            for (FlightDetails flight : currentCity.getOutgoingFlights()) {
                FlightPath newPath = new FlightPath(currentPath);
                newPath.addFlight(flight);
                queue.add(newPath);
            }
        }

        return new ArrayList<>();
    }

    public List<FlightDetails> findOptimalPathWithExtraServices(String src, String dest, Set<Class<? extends Service>> requiredServices) {
        PriorityQueue<FlightPath> queue = new PriorityQueue<>(Comparator
                .comparingInt(FlightPath::getTotalCost)
                .thenComparingInt(FlightPath::getNumberOfHops));
        Map<City, FlightPath> bestPathMap = new ConcurrentHashMap<>();

        City srcCity = getCity(src);
        City destCity = getCity(dest);
        queue.add(new FlightPath());

        while (!queue.isEmpty()) {
            FlightPath currentPath = queue.poll();
            City currentCity = currentPath.getLastCity();

            if(currentCity == null){
                currentCity = srcCity;
            }

            if (currentCity.equals(destCity)) {
                return currentPath.getFlights();
            }

            if (bestPathMap.containsKey(currentCity)) {
                FlightPath bestPath = bestPathMap.get(currentCity);
                if (currentPath.getTotalCost() > bestPath.getTotalCost() ||
                        (currentPath.getTotalCost() == bestPath.getTotalCost() && currentPath.getNumberOfHops() >= bestPath.getNumberOfHops())) {
                    continue;
                }
            }

            bestPathMap.put(currentCity, currentPath);

            for (FlightDetails flight : currentCity.getOutgoingFlights()) {
                if (flight.hasService(requiredServices)) {
                    FlightPath newPath = new FlightPath(currentPath);
                    newPath.addFlight(flight);
                    queue.add(newPath);
                }
            }
        }

        return new ArrayList<>();
    }

}
