package org.example;

public class Flight {
    private final String airlineName;
    private final City source;
    private final City destination;
    private final int cost;
    private final boolean meals;

    public Flight(final String airlineName, final City source, final City destination, final int cost,
                   final boolean meals) {
        this.airlineName = airlineName;
        this.source = source;
        this.destination = destination;
        this.cost = cost;
        this.meals = meals;
    }

    public Flight(final String airlineName, final City source, final City destination, final int cost) {
        this.airlineName = airlineName;
        this.source = source;
        this.destination = destination;
        this.cost = cost;
        this.meals = false;
    }

    public String getAirlineName() {
        return airlineName;
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

    public boolean isMeals() {
        return meals;
    }
}
