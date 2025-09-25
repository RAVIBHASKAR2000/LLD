package org.example.airlinesystem.search;

import org.example.airlinesystem.model.City;
import org.example.airlinesystem.model.FlightDetails;

import java.util.ArrayList;
import java.util.List;

class FlightPath {
    private List<FlightDetails> flights;
    private int totalCost;

    public FlightPath() {
        this.flights = new ArrayList<>();
        this.totalCost = 0;
    }

    public FlightPath(FlightPath other) {
        this.flights = new ArrayList<>(other.flights);
        this.totalCost = other.totalCost;
    }

    // Method to add a flight to the path
    public void addFlight(FlightDetails flight) {
        flights.add(flight);
        totalCost += flight.getCost();
    }

    public List<FlightDetails> getFlights() {
        return flights;
    }

    public City getLastCity() {
        return flights.isEmpty() ? null : flights.get(flights.size() - 1).getDestination();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getNumberOfHops() {
        return flights.size();
    }
}

