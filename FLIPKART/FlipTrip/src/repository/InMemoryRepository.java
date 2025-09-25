package repository;

import dto.Flight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRepository {
    public static Map<Integer, Flight> flightMap;

    public InMemoryRepository() {
        flightMap=new ConcurrentHashMap<>();
    }
    public static Map<Integer, Flight> getFlightMap() {
        return flightMap;
    }

}
