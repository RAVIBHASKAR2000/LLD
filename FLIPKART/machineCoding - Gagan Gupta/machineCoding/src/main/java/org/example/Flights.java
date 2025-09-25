package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flights {
    private final List<Flight> flightList = new ArrayList<>();
    private static final Map<City,List<Pair<City, Integer>>> flightMap = new HashMap<>();
    private final SearchEngine searchEngine = SearchEngine.getSearchEngine();
    public void registerFlights(Flight flight) {
        flightList.add(flight);
        System.out.println(String.format("Flight Name %s, Source %s -> Destination %s registered",
                flight.getAirlineName(), flight.getSource().getCityName(),
                flight.getDestination().getCityName()));

        List<Pair<City,Integer>> flightsTo = flightMap.get(flight.getSource());
        if(flightsTo == null) {
            flightsTo = new ArrayList<>();
            flightMap.put(flight.getSource(),flightsTo);
        }
        flightsTo.add(new Pair<>(flight.getDestination(), flight.getCost()));

    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void search(final City source, final City destination, final  boolean isMealRequired) {
        searchEngine.search(flightMap,source,destination,isMealRequired);

    }

}
