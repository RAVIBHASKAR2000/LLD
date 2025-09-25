package org.example.airlinesystem.model;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<FlightDetails> outgoingFlights;

    public City(String name) {
        this.name = name;
        this.outgoingFlights = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<FlightDetails> getOutgoingFlights() {
        return outgoingFlights;
    }

    public void addFlight(FlightDetails flight){
        outgoingFlights.add(flight);
    }
}
