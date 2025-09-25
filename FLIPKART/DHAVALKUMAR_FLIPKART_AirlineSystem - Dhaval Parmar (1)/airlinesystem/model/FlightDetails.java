package org.example.airlinesystem.model;

import org.example.airlinesystem.extraservice.Service;

import java.util.Set;

public class FlightDetails {
    private City source;
    private City destination;
    private int cost;
    private Airline airline;
    private Set<Service> services;

    public FlightDetails(City source, City destination, int cost, Airline airline, Set<Service> services) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
        this.airline = airline;
        this.services = services;
    }

    public City getSource() {
        return source;
    }

    public City getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    public Airline getAirline() {
        return airline;
    }

    public void addService(Service service){
        services.add(service);
    }

    public boolean hasService(Set<Class<? extends Service>> requiredServices){
        for (Class<? extends Service> service : requiredServices) {
            boolean hasService = services.stream().anyMatch(service::isInstance);
            if (!hasService) {
                return false;
            }
        }
        return true;
    }
}
